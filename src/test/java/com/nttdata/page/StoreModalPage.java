package com.nttdata.page;

import org.openqa.selenium.By;

public class StoreModalPage {
    public static By lblTituloModal = By.cssSelector("h4.modal-title");
    public static By lblMontoTotal = By.xpath("//p[contains(@class, 'product-total')]//span[contains(@class, 'value')]");
    public static By btnFinalizarCompra = By.xpath("//a[@class='btn btn-primary' and contains(text(),'Finalizar compra')]");
}
