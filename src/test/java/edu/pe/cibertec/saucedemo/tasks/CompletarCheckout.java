package edu.pe.cibertec.saucedemo.tasks;

import edu.pe.cibertec.saucedemo.ui.CarritoPage;
import edu.pe.cibertec.saucedemo.ui.CheckoutPage;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.playwright.Target;
import net.serenitybdd.screenplay.playwright.interactions.Click;
import net.serenitybdd.screenplay.playwright.interactions.Enter;

public class CompletarCheckout {

    public static Performable con(String firstName, String lastName, String postalCode) {
        return Task.where("{0} completa el checkout con nombre '" + firstName + "'",
                Click.on(Target.the("cart icon")
                        .locatedBy(CarritoPage.CART_ICON)),
                Click.on(Target.the("checkout button")
                        .locatedBy(CheckoutPage.CHECKOUT_BUTTON)),
                Enter.theValue(firstName)
                        .into(Target.the("first name field")
                                .locatedBy(CheckoutPage.FIRST_NAME_FIELD)),
                Enter.theValue(lastName)
                        .into(Target.the("last name field")
                                .locatedBy(CheckoutPage.LAST_NAME_FIELD)),
                Enter.theValue(postalCode)
                        .into(Target.the("postal code field")
                                .locatedBy(CheckoutPage.POSTAL_CODE_FIELD)),
                Click.on(Target.the("continue button")
                        .locatedBy(CheckoutPage.CONTINUE_BUTTON))
        );
    }
}