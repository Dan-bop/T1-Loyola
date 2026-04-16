package edu.pe.cibertec.saucedemo.stepdefinitions;

import edu.pe.cibertec.saucedemo.questions.TheCartBadge;
import edu.pe.cibertec.saucedemo.questions.TheCartContents;
import edu.pe.cibertec.saucedemo.tasks.AgregarAlCarrito;
import edu.pe.cibertec.saucedemo.tasks.EliminarDelCarrito;
import edu.pe.cibertec.saucedemo.ui.CarritoPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.playwright.Target;
import net.serenitybdd.screenplay.playwright.interactions.Click;

import static org.hamcrest.MatcherAssert.assertThat;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.*;

public class CarritoStepDefinitions {

    @When("she adds the product {string} to the cart")
    public void sheAddsProductToCart(String name) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                AgregarAlCarrito.producto(name)
        );
    }

    @And("she removes the product {string} from the cart")
    public void sheRemovesProductFromCart(String name) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                EliminarDelCarrito.producto(name)
        );
    }

    @Then("the cart icon should display {string}")
    public void cartIconShouldDisplay(String count) {
        OnStage.theActorInTheSpotlight().should(
                seeThat(TheCartBadge.displayed(), equalTo(count))
        );
    }

    @Then("the cart should contain {string} and {string}")
    public void cartShouldContain(String item1, String item2) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Click.on(Target.the("cart icon").locatedBy(CarritoPage.CART_ICON))
        );
        OnStage.theActorInTheSpotlight().should(
                seeThat(TheCartContents.displayed(), hasItems(item1, item2))
        );
    }

    @Then("the cart should only contain {string}")
    public void cartShouldOnlyContain(String item) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Click.on(Target.the("cart icon").locatedBy(CarritoPage.CART_ICON))
        );

        OnStage.theActorInTheSpotlight().should(
                seeThat(TheCartContents.displayed(), hasItem(item))
        );

        OnStage.theActorInTheSpotlight().should(
                seeThat(TheCartContents.displayed(), hasSize(1))
        );
    }
}