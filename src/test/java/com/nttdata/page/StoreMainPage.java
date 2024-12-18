package com.nttdata.page;

import org.openqa.selenium.By;

public class StoreMainPage {
    public static By lblNombreUsuario = By.xpath("//div[@id=\"_desktop_user_info\"]/div/a/span[@class=\"hidden-sm-down\"]");
    public static By btnSubcategoria = By.xpath("//*[@id=\"left-column\"]/div[1]/ul/li[2]/ul/li[1]/a");
    public static By btnPrimerProducto = By.xpath("//*[@id=\"js-product-list\"]/div[1]/div/article/div/div[1]/a/picture/img");
}
