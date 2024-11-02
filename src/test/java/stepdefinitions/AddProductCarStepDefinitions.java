package stepdefinitions;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import com.pruebatecnica.questions.AcknowledgmentsQuestions;
import com.pruebatecnica.questions.AddProductCarQuestions;
import com.pruebatecnica.tasks.AcknowledgmentsCategoryTask;
import com.pruebatecnica.tasks.AddProductCarTask;
import com.pruebatecnica.tasks.OpenUpTask;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;

public class AddProductCarStepDefinitions {

    @Given("que estoy en la categoría Agradecimientos")
    public void queEstoyEnLaCategoría() {
        OnStage.theActorCalled("Antonio").wasAbleTo(
                OpenUpTask.thePage(),
                AcknowledgmentsCategoryTask.accessAcknowledgments()

        );
        OnStage.theActorInTheSpotlight()
                .should(seeThat(AcknowledgmentsQuestions.pageTitle(), equalTo("AGRADECIMIENTOS")));
    }

    @When("doy clic en la opción “Añadir al carrito”")
    public void doyClicEnLaOpciónAñadirAlCarrito() {
        OnStage.theActorInTheSpotlight().attemptsTo(
            AddProductCarTask.addProductCardTask()
        );
    }

    @Then("el producto se agregará al carrito de compras")
    public void elProductoSeAgregaráAlCarritoDeCompras() {
        OnStage.theActorInTheSpotlight().should(
            seeThat(AddProductCarQuestions.isPresent(), is(true))
        );
    }

}
