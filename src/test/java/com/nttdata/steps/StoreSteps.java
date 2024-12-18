package com.nttdata.steps;

import com.nttdata.page.*;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.nttdata.core.DriverManager.getDriver;
import static com.nttdata.core.DriverManager.screenShot;

public class StoreSteps {
    private WebDriver driver;

    public void abrirPagina() {
        driver = getDriver();
        driver.get("https://qalab.bensg.com/store");
        driver.findElement(StorePage.btnAbrirIniciarSesion).click();
        screenShot();
    }

    public void iniciarSesion(String usuario, String clave) {
        WebElement userInputElement = driver.findElement(StoreLoginPage.userInput);
        userInputElement.sendKeys(usuario);
        WebElement passwordInputElement = driver.findElement(StoreLoginPage.passwordInput);
        passwordInputElement.sendKeys(clave);

        driver.findElement(StoreLoginPage.btnIniciarSesion).click();
        screenShot();
    }

    public void navegarSubcategoria(String subcategoria) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(StoreMainPage.btnSubcategoria));
        element.click();
        screenShot();
    }

    public void navegarCategoria(String categoria) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        String xpath = "//*[@class='category' and contains(translate(., 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '"
                + categoria.toLowerCase() + "')]/a";

        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        element.click();
        screenShot();
    }

    public void agregarUnidadesAlCarrito(String cantidad) {
        driver.findElement(StoreMainPage.btnPrimerProducto).click();
        screenShot();
        WebElement quantityInputElement = driver.findElement(StoreProductPage.btnCantidad);
        ((JavascriptExecutor) driver).executeScript("arguments[0].value='" + cantidad + "';", quantityInputElement);
        driver.findElement(StoreProductPage.btnAñadirCarrito).click();
        screenShot();
    }

    public void validarPopupDeConfirmacion() {
        String tituloModal = "\uE876Producto añadido correctamente a su carrito de compra";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement modalElement = wait.until(ExpectedConditions.visibilityOfElementLocated(StoreModalPage.lblTituloModal));
        Assertions.assertEquals( tituloModal, modalElement.getText());
        screenShot();
    }

    public void validarMontoCarrito(String monto) {
        Assertions.assertEquals( monto, driver.findElement(StoreModalPage.lblMontoTotal).getText());
        screenShot();
    }

    public void finalizarCompra() {
        driver.findElement(StoreModalPage.btnFinalizarCompra).click();
        screenShot();
    }

    public void validarElTituloPaginaDelCarrito() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(StoreShoppingCart.lblCarrito));
        String tituloCarrito = "CARRITO";
        Assertions.assertEquals( tituloCarrito, element.getText());
        screenShot();
    }

    public void validarCalculoPrecioCarrito(String precio) {
        Assertions.assertEquals( precio, driver.findElement(StoreShoppingCart.lblCalculoPrecio).getText());
        screenShot();
    }

    public void validarAutentificación(String nombre) {
        Assertions.assertEquals( nombre, driver.findElement(StoreMainPage.lblNombreUsuario).getText());
        screenShot();
    }
}
