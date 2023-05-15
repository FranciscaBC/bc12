package aut.testcreation.pages.vuelos;

import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import static framework.engine.utils.Constants.BASE_URL_AUT;
import static org.openqa.selenium.Keys.*;

public class RumboHomePage extends SeleniumWrapper {
    public RumboHomePage(WebDriver driver) {
        super(driver);
    }

    By btnAceptarCookies = By.xpath("//button[contains(text(), 'Aceptar todo')]");
    By btnRechazarCookies = By.xpath("//button[contains(text(), 'Rechazar todo')]");
    By btnVueloIdaVuelta = By.xpath("//div[contains(text(), 'Ida y vuelta')]");
    By btnVueloSoloIda = By.xpath("//div[contains(text(), 'Solo ida')]");
    By btnVueloMultidestino = By.xpath("//a[contains(text(), 'Multidestino')]");
    By btnLimpiar = By.xpath("//button[contains(@aria-label,'Clear')]");
    By locatorOrigenVuelo = By.xpath("//input[contains(@aria-label,'Origen')]");
    By locatorDestinoVuelo = By.xpath("//input[contains(@aria-label,'Destino')]");
    By locatorFechaSoloIda = By.xpath("//button[@class='d-1kuzy14'][9]");
    By locatorCalendario = By.xpath("//label[contains(text(), 'Fecha de ida')]");
    By locatorFechaIda = By.xpath("//button[@class='d-zlm2xw'][1]");
    By locatorFechaVuelta = By.xpath("//button[@class='d-1dj49va'][1]");
    By locatorNumeroPasajeros = By.xpath("//label[contains(text(),'Pasajero')]");
    By btnBuscar = By.xpath("//button[contains(@type,'sub')]");
    By errOrigenVuelo = By.xpath("//span[contains(text(),'Introduce ciudad o aeropuerto de origen')]");
    By btnAumentarPasajeros = By.xpath("//button[contains(@aria-label,'Aumentar el número de adultos')]");


    public void irARumboYCookies(boolean deseaAceptarCookies) {
        navigateTo(BASE_URL_AUT);
        if (deseaAceptarCookies) {
            click(btnAceptarCookies);
        } else {
            click(btnRechazarCookies);
        }
    }

    public void seleccioneTipoDeVuelo(boolean idaYVuelta, boolean soloIda, boolean multidestino) {
        if (idaYVuelta) {
            click(btnVueloIdaVuelta);
        } else if (soloIda) {
            click(btnVueloSoloIda);
        } else if (multidestino) {
            click(btnVueloMultidestino);
        } else{
            System.out.println("Por favor, seleccione un tipo de vuelo");
        }
    }

    public void limpiarCampos(boolean deseaBorrarOrigen, boolean deseaBorrarDestino) {
        List<WebElement> limpiar = findElements(btnLimpiar);
        if (deseaBorrarOrigen) {
            limpiar.get(0).click();
        }
        if (deseaBorrarDestino) {
            limpiar.get(1).click();
        }
    }

    public void agregarOrigen(String origenVuelo) throws InterruptedException {
        click(locatorOrigenVuelo);
        write(origenVuelo, locatorOrigenVuelo);
        Thread.sleep(1500);
        sendKeys(DOWN, locatorDestinoVuelo);
        Thread.sleep(1500);
        sendKeys(ENTER, locatorOrigenVuelo);
        click(locatorOrigenVuelo);
    }

    public void agregarDestino(String destinoVuelo) throws InterruptedException {
        click(locatorDestinoVuelo);
        write(destinoVuelo, locatorDestinoVuelo);
        Thread.sleep(1500);
        sendKeys(DOWN, locatorDestinoVuelo);
        Thread.sleep(1500);
        sendKeys(ENTER, locatorDestinoVuelo);
        Thread.sleep(1500);
        click(locatorDestinoVuelo);
    }

    public void fechas() throws InterruptedException { //Se mejorara este metodo en el siguiente sprint
        click(locatorCalendario);
        click(locatorFechaIda);
        click(locatorFechaVuelta);
        Thread.sleep(1000);
    }

    public void numPasajeros(boolean deseaAgregarUnPasajero) throws InterruptedException {
        if (deseaAgregarUnPasajero) {
            click(locatorNumeroPasajeros);
            Thread.sleep(100);
            click(locatorNumeroPasajeros);
            click(btnAumentarPasajeros);
            Thread.sleep(1000);
            click(locatorNumeroPasajeros);
        } else {
            click(locatorNumeroPasajeros);
        }
    }

    public void fechaSoloIda() throws InterruptedException {
        Thread.sleep(1000);
        click(locatorCalendario);
        click(locatorFechaSoloIda);
    }

    public String mensajeErrorOrigen() {
        return getText(errOrigenVuelo);
    }

    public void realizarBusqueda() {
        click(btnBuscar);
    }
}