package edu.pe.cibertec.saucedemo.tasks;

import edu.pe.cibertec.saucedemo.ui.InventoryPage;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.playwright.abilities.BrowseTheWebWithPlaywright;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class VerificarSesion {

    public static Performable enInventario() {
        return Task.where("{0} verifica si se loguea en el inventario",
                actor -> {
                    com.microsoft.playwright.Page page = BrowseTheWebWithPlaywright
                            .as(actor)
                            .getCurrentPage();
                    assertThat(page.locator(".inventory_list")).isVisible();
                }
        );
    }

    public static Performable tituloDePagina(String titulo) {
        return Task.where("{0} verifica que el título de página es '" + titulo + "'",
                actor -> {
                    com.microsoft.playwright.Page page = BrowseTheWebWithPlaywright
                            .as(actor)
                            .getCurrentPage();
                    assertThat(page.locator(InventoryPage.PAGE_TITLE))
                            .containsText(titulo);
                }
        );
    }
}