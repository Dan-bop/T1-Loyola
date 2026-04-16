package edu.pe.cibertec.saucedemo.stepdefinitions;

import edu.pe.cibertec.saucedemo.questions.IsCheckoutFormVisible;
import edu.pe.cibertec.saucedemo.questions.TheConfirmationMessage;
import edu.pe.cibertec.saucedemo.tasks.CompletarCheckout;
import edu.pe.cibertec.saucedemo.tasks.VerificarResumen;
import edu.pe.cibertec.saucedemo.ui.CheckoutPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.playwright.Target;
import net.serenitybdd.screenplay.playwright.interactions.Click;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.*;

public class CheckoutStepDefinitions {

    @And("she proceeds to checkout with first name {string}, last name {string} and postal code {string}")
    public void sheProceedsToCheckout(String firstName, String lastName, String postalCode) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                CompletarCheckout.con(firstName, lastName, postalCode)
        );
    }

    @And("she verifies the order summary shows item total {string}")
    public void sheVerifiesItemTotal(String total) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                VerificarResumen.itemTotal(total)
        );
    }

    @And("she completes the order")
    public void sheCompletesOrder() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Click.on(
                        Target.the("finish button")
                                .locatedBy(CheckoutPage.FINISH_BUTTON)
                )
        );
    }

    @Then("she should see the confirmation message {string}")
    public void sheShouldSeeConfirmationMessage(String msg) {
        OnStage.theActorInTheSpotlight().should(
                seeThat(TheConfirmationMessage.displayed(), equalTo(msg))
        );
    }

    @Then("the checkout form should remain visible")
    public void checkoutFormShouldRemainVisible() {
        OnStage.theActorInTheSpotlight().should(
                seeThat(IsCheckoutFormVisible.onScreen(), is(true))
        );
    }
}