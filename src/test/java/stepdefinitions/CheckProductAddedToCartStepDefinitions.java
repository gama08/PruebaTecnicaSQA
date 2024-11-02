package stepdefinitions;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

import com.pruebatecnica.questions.AcknowledgmentsQuestions;
import com.pruebatecnica.tasks.AcknowledgmentsCategoryTask;
import com.pruebatecnica.tasks.AddProductCarTask;
import com.pruebatecnica.tasks.CheckProductAddedCarTask;
import com.pruebatecnica.tasks.OpenUpTask;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;

public class CheckProductAddedToCartStepDefinitions {

    @Given("que he agregado el producto de la categoría Agradecimientos al carrito")
    public void queHeAgregadoElProductoDeLaCategoríaAgradecimientosAlCarrito() {

        OnStage.theActorCalled("Antonio").wasAbleTo(
                OpenUpTask.thePage(),
                AcknowledgmentsCategoryTask.accessAcknowledgments()

        );
        OnStage.theActorInTheSpotlight()
                .should(seeThat(AcknowledgmentsQuestions.pageTitle(), equalTo("AGRADECIMIENTOS")));

        OnStage.theActorInTheSpotlight().attemptsTo(
                AddProductCarTask.addProductCardTask());

    }

    @When("doy clic en la opción CARRO")
    public void doyClicEnLaOpciónCARRO() {

        OnStage.theActorInTheSpotlight().attemptsTo(
                CheckProductAddedCarTask.clickBtnCar()
        );

    }

    @Then("se deberán visualizar el producto agregado")
    public void seDeberánVisualizarElProductoAgregado() {

    }

}
