package com.nttdata.stepsdefinitions;

import com.nttdata.steps.StoreSteps;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;

public class StoreStepDefs {
    private StoreSteps storeSteps = new StoreSteps();
    @Dado("estoy en la página de la tienda")
    public void estoyEnLaPaginaDeLaTienda() {
        storeSteps.abrirPagina();
    }

    @Y("me logueo con mi usuario {string} y clave {string} y se valida la autenticación con el {string}")
    public void meLogueoConMiUsuarioYClave(String usuario, String clave, String nombre) {
        storeSteps.iniciarSesion(usuario, clave);
        storeSteps.validarAutentificación(nombre);
    }

    @Cuando("navego a la categoria {string} y subcategoria {string}")
    public void navegoALaCategoriaYSubcategoria(String categoria, String subcategoria) {
        storeSteps.navegarCategoria(categoria);
        storeSteps.navegarSubcategoria(subcategoria);
    }

    @Y("agrego {string} unidades del primer producto al carrito")
    public void agregoUnidadesDelPrimerProductoAlCarrito(String cantidad) {
        storeSteps.agregarUnidadesAlCarrito(cantidad);
    }

    @Entonces("valido en el popup la confirmación del producto agregado")
    public void validoEnElPopupLaConfirmacionDelProductoAgregado() {
        storeSteps.validarPopupDeConfirmacion();
    }

    @Y("valido en el popup que el monto total calculado correctamente sea {string}")
    public void validoEnElPopupQueElMontoTotalSeaCalculadoCorrectamente(String monto) {
        storeSteps.validarMontoCarrito(monto);
    }

    @Cuando("finalizo la compra")
    public void finalizoLaCompra() {
        storeSteps.finalizarCompra();
    }

    @Entonces("valido el titulo de la pagina del carrito")
    public void validoElTituloDeLaPaginaDelCarrito() {
        storeSteps.validarElTituloPaginaDelCarrito();
    }

    @Y("vuelvo a validar el calculo de precios en el carrito sea {string}")
    public void vuelvoAValidarElCalculoDePreciosEnElCarrito(String monto) {
        storeSteps.validarCalculoPrecioCarrito(monto);
    }
}
