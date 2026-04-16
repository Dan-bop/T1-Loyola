package edu.pe.cibertec.saucedemo.tasks;

import edu.pe.cibertec.saucedemo.ui.CarritoPage;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;

public class AgregarAlCarrito {

    public  static Performable producto(String nombre) {
        return Task.where("{0} agrega al carrito '" + nombre + "'",
                Click.on(Target.the("add to cart" + nombre)
                        .locatedBy(CarritoPage.addToCartButton(nombre)))
        );
    }
}
