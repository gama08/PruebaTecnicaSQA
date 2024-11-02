package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import com.pruebatecnica.questions.UsersListResponseQuestions;
import com.pruebatecnica.tasks.ListUsersTask;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class ListUserStepDefinitions {

    private String apiUrl;
    private Actor actor;

    @Given("que accedo al servicio de listar usuarios de ReqRes")
    public void queAccedoAlServicioDeListarUsuariosDeReqRes() {
        apiUrl = "https://reqres.in/";
        actor = Actor.named("Antonio").whoCan(CallAnApi.at(apiUrl));
    }

    @When("realizo una solicitud GET al endpoint {string}")
    public void realizoUnaSolicitudGETAlEndpoint(String endpoint) {
        actor.attemptsTo(
                ListUsersTask.fromPage(endpoint));
    }

    @Then("la respuesta debe contener la lista de usuarios en la página {int}")
    public void laRespuestaDebeContenerLaListaDeUsuariosEnLaPágina(Integer page) {
        Integer actualPage = actor.asksFor(UsersListResponseQuestions.currentPage());
        actor.should(
                seeThat("La pagina ", UsersListResponseQuestions.currentPage(), equalTo(page)).orComplainWith(
                        AssertionError.class,
                        "Se esperaba la lista de usuarios de la pagina " + page +
                                ", pero se recibió " + actualPage));

    }

    @Then("el estado de la respuesta debe ser {int}")
    public void elEstadoDeLaRespuestaDebeSer(Integer status) {
        Integer actualStatus = actor.asksFor(UsersListResponseQuestions.statusCode());
        actor.should(
                seeThat("El estado de la respuesta",
                        UsersListResponseQuestions.statusCode(),
                        equalTo(status))
                        .orComplainWith(AssertionError.class,
                                "Se esperaba que el código de estado fuera " + status +
                                        ", pero se recibió " + actualStatus));

    }
}
