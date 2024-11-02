package stepdefinitions;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;


import com.pruebatecnica.questions.UpdateUserResponseQuestions;
import com.pruebatecnica.tasks.DeleteUserTask;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

public class DeleteUserStepDefinitions {

    private int userId;
    private Actor actor;
    private String apiUrl;

    @Before
    public void configuration(){
        apiUrl = "https://reqres.in";
        actor = Actor.named("Antonio").whoCan(CallAnApi.at(apiUrl));
    }

    @Given("que tengo el ID de usuario existente")
    public void queTengoElIDDeUsuarioExistente() {
        userId = 2;
    }

    @When("realizo una solicitud DELETE al endpoint {string} con id {int}")
    public void realizoUnaSolicitudDELETEAlEndpointConId(String endpoint, Integer userId) {
        String url = apiUrl + endpoint;
        actor.attemptsTo(
            DeleteUserTask.deleteUserTask(userId, url)
        );
    }

    @Then("la respuesta debe devolver un estado de {int}, indicando que el usuario fue eliminado exitosamente")
    public void laRespuestaDebeDevolverUnEstadoDeIndicandoQueElUsuarioFueEliminadoExitosamente(Integer code) {
        actor.should(
            seeThat("Usuario fue eliminado exitosamente", UpdateUserResponseQuestions.statusCode(), equalTo(code)).orComplainWith(
                AssertionError.class,
                "No fue posible eliminar el usuario. Código " + UpdateUserResponseQuestions.statusCode()));
    }

}
