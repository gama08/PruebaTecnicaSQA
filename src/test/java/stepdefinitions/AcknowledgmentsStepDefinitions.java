package stepdefinitions;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

import com.pruebatecnica.questions.AcknowledgmentsQuestions;
import com.pruebatecnica.tasks.AcknowledgmentsCategoryTask;
import com.pruebatecnica.tasks.OpenUpTask;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

public class AcknowledgmentsStepDefinitions {

    @Before
    public void setStage(){
        OnStage.setTheStage(new OnlineCast());
       
    }

    @Given("que estoy en la página principal de la tienda")
    public void queEstoyEnLaPáginaPrincipalDeLaTienda() {
        OnStage.theActorCalled("Antonio").wasAbleTo(OpenUpTask.thePage());
    }

    @When("selecciono la categoría Agradecimientos")
    public void seleccionoLaCategoría() {
        OnStage.theActorInTheSpotlight().attemptsTo(AcknowledgmentsCategoryTask.accessAcknowledgments());
    }

    @Then("se visualizarán los productos para esta categoría")
    public void seVisualizaránLosProductosParaEstaCategoría() {
        OnStage.theActorInTheSpotlight().should(seeThat(AcknowledgmentsQuestions.pageTitle(), equalTo("AGRADECIMIENTOS")));

    }

}
