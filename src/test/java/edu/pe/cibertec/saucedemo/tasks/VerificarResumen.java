package edu.pe.cibertec.saucedemo.tasks;

import edu.pe.cibertec.saucedemo.ui.CheckoutPage;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.playwright.Target;
import net.serenitybdd.screenplay.playwright.abilities.BrowseTheWebWithPlaywright;

public class VerificarResumen {

    public static Performable itemTotal(String totalEsperado) {
        return Task.where("{0} verifica que el total es '" + totalEsperado + "'",
                actor -> {
                    String actual = BrowseTheWebWithPlaywright
                            .as(actor)
                            .getCurrentPage()
                            .locator(CheckoutPage.ITEM_TOTAL)
                            .textContent()
                            .trim();
                    assert actual.contains(totalEsperado)
                            : "Total esperado: " + totalEsperado + " — obtenido: " + actual;
                }
        );
    }
}