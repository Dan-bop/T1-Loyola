package edu.pe.cibertec.saucedemo.questions;

import edu.pe.cibertec.saucedemo.ui.CarritoPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.playwright.Target;
import net.serenitybdd.screenplay.playwright.abilities.BrowseTheWebWithPlaywright;
import com.microsoft.playwright.Locator;

import java.util.List;
import java.util.stream.Collectors;

public class TheCartContents implements Question<List<String>> {

    public static TheCartContents displayed() {
        return new TheCartContents();
    }

    @Override
    public List<String> answeredBy(Actor actor) {
        com.microsoft.playwright.Page page = BrowseTheWebWithPlaywright
                .as(actor)
                .getCurrentPage();
        return page.locator(CarritoPage.CART_ITEMS)
                .allTextContents();
    }
}