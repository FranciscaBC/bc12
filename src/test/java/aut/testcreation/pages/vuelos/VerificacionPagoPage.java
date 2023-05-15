package aut.testcreation.pages.vuelos;

import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class VerificacionPagoPage extends SeleniumWrapper {
    public VerificacionPagoPage(WebDriver driver) {
        super(driver);
    }
    By locatorVerificacionYPago = By.xpath("//span[contains(text(),'Verificación y pago')]");

    public String verificacionYPago(){return getText(locatorVerificacionYPago);}
}
