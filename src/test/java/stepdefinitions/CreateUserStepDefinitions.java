package stepdefinitions;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

import com.pruebatecnica.model.UserModel;
import com.pruebatecnica.questions.CreateUserResponseQuestions;
import com.pruebatecnica.tasks.CreateUserTask;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.core.Serenity;


public class CreateUserStepDefinitions {

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

    @Given("que tengo los datos para crear un nuevo usuario")
    public void queTengoLosDatosParaCrearUnNuevoUsuario() {
        userName = "Antonio Beltran";
        userJob = "Automatizador";
        user = new UserModel(userName, userJob);
        
    }

    @When("realizo una solicitud POST al endpoint {string} con los datos del usuario")
    public void realizoUnaSolicitudPOSTAlEndpointConLosDatosDelUsuario(String endpoint) {
        String url = apiUrl + endpoint;
        actor.attemptsTo(
            CreateUserTask.createUserTask(user, url)
        );
    }

    @Then("la respuesta debe indicar que el usuario fue creado exitosamente con un estado de {int}")
    public void laRespuestaDebeIndicarQueElUsuarioFueCreadoExitosamenteConUnEstadoDe(Integer code) {
        actor.should(
            seeThat("Usuario creado exitosamente", CreateUserResponseQuestions.statusCode(), equalTo(code)).orComplainWith(
                AssertionError.class,
                "No fue posible crear el usuario. Código " + code));
    }

    @Then("debe devolver el ID del usuario creado")
    public void debeDevolverElIDDelUsuarioCreado() {
        Integer userId = actor.asksFor(CreateUserResponseQuestions.userId());
        Serenity.recordReportData().withTitle("ID del nuevo usuario").andContents(userId.toString());
    }

}
