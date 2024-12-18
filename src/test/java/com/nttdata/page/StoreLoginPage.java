package com.nttdata.page;

import org.openqa.selenium.By;

public class StoreLoginPage {
    public static By userInput = By.xpath("//input[@id=\"field-email\"]");
    public static By passwordInput = By.id("field-password");
    public static By btnIniciarSesion = By.id("submit-login");
}
