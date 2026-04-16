package edu.pe.cibertec.saucedemo.questions;

import edu.pe.cibertec.saucedemo.ui.CheckoutPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.playwright.abilities.BrowseTheWebWithPlaywright;

public class IsCheckoutFormVisible implements Question<Boolean> {

    public static IsCheckoutFormVisible onScreen() {
        return new IsCheckoutFormVisible();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return BrowseTheWebWithPlaywright
                .as(actor)
                .getCurrentPage()
                .locator(CheckoutPage.CHECKOUT_FORM)
                .isVisible();
    }
}