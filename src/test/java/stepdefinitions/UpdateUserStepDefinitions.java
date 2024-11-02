package stepdefinitions;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

import com.pruebatecnica.model.UserModel;
import com.pruebatecnica.questions.UpdateUserResponseQuestions;
import com.pruebatecnica.tasks.UpdateUserTask;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;

public class UpdateUserStepDefinitions {

    private String userName;
    private String userJob;
    private Actor actor;
    private String apiUrl;
    private UserModel user;

    @Before
    public void configuration(){
        apiUrl = "https://reqres.in";
        actor = Actor.named("Antonio").whoCan(CallAnApi.at(apiUrl));
    }

    @Given("que tengo un ID de usuario existente")
    public void queTengoUnIDDeUsuarioExistente() {

        userName = "Gamaliel Antonio Beltran";
        userJob = "Automatizador y Probador";
        user = new UserModel(userName, userJob);

    }

    @When("realizo una solicitud PUT al endpoint {string} con id {int} con datos actualizados")
    public void realizoUnaSolicitudPUTAlEndpointConIdConDatosActualizados(String endpoint, Integer userId) {
        String url = apiUrl + endpoint;
        actor.attemptsTo(
            UpdateUserTask.updateUserTask(userId, user, url)
        );
    }

    @Then("la respuesta debe indicar que el usuario fue actualizado exitosamente con un estado de {int}")
    public void laRespuestaDebeIndicarQueElUsuarioFueActualizadoExitosamenteConUnEstadoDe(Integer code) {
        actor.should(
            seeThat("Usuario actualizado exitosamente", UpdateUserResponseQuestions.statusCode(), equalTo(code)).orComplainWith(
                AssertionError.class,
                "No fue posible actualizar el usuario. Código " + UpdateUserResponseQuestions.statusCode()));
    }

    @Then("debe devolver los datos actualizados")
    public void debeDevolverLosDatosActualizados() {
        UserModel updateUser = actor.asksFor(UpdateUserResponseQuestions.updatedUserDetails());
    
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString;
        
        try {
            jsonString = objectMapper.writeValueAsString(updateUser);
        } catch (JsonProcessingException e) {
            jsonString = "Error al convertir a JSON: " + e.getMessage();
        }
        
        Serenity.recordReportData().withTitle("Usuario Actualizado").andContents(jsonString);
    }

}
