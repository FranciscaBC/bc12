package aut.testcreation.pages.vuelos;

import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import static org.openqa.selenium.Keys.DOWN;
import static org.openqa.selenium.Keys.ENTER;

public class OfertasVuelosPage extends SeleniumWrapper {
    public OfertasVuelosPage(WebDriver driver) {
        super(driver);
    }
    By locatorElegirVuelo = By.xpath("//div[@class='FullTripCard__PaymentContainer-sc-z8znd4-3 juamvE']");
    By locatorOfertas = By.xpath("//div[@class='FullJourneySummary__JourneySummary-sc-1yzjt4d-0 iwxxyr']");
    By locatorModificarVuelo = By.xpath("//span[contains(text(), 'Modificar')]");
    By locatorSoloIda = By.xpath("//div[@class='css-1s1pmhl']");
    By btnLimpiar = By.xpath("//button[@aria-label='Clear']");
    By locatorOrigen = By.xpath("//input[@aria-label='Origen']");
    By locatorDestino = By.xpath("//input[@aria-label='Destino']");
    By btnBuscarOtraVez = By.xpath("//button[@aria-label='Buscar']");
    By locatorElegirLatam = By.xpath("//input[@id='id-LATAM Airlines Group']");
    By locatorElegirUnited = By.xpath("//input[@id='id-United Airlines']");
    By btnVerMas = By.xpath("//button[@class='Link__StyledLink-sc-y3byev-0 kXjsgw Link__BaseLinkButton-sc-y3byev-1 jzRcNR'][contains(text(),'Ver más')]");


    public void cambiarPestaniaARumbo() throws InterruptedException {
        Thread.sleep(4000);
        switchToTabByTitleContains("Rumbo");
    }

    public void seleccionarOferta() throws InterruptedException {
        findElement(locatorElegirVuelo);
        Thread.sleep(2500);
        click(locatorElegirVuelo);
        Thread.sleep(2000);
    }

    public void contarNumOfertas() {
        List<WebElement> ofertas = findElements(locatorOfertas);
        int num_ofertas = ofertas.size();
        if (num_ofertas == 15) {
            System.out.println("Test completado con éxito: Han sido desplegadas y detectadas las 15 ofertas esperadas.");
        } else {
            System.out.println("Test sin éxito: No se han desplegado las 15 ofertas como se esperaba.");
        }
    }

    public void modificarVuelo(boolean deseaCambiarOrigen, boolean deseaCambiarDestino, String nuevoOrigenVuelo, String nuevoDestinoVuelo) throws InterruptedException {
        click(locatorModificarVuelo);
        click(locatorSoloIda);
        List<WebElement> limpiar = findElements(btnLimpiar);
        if(deseaCambiarOrigen){
            limpiar.get(0).click();
            click(locatorOrigen);
            write(nuevoOrigenVuelo, locatorOrigen);
            Thread.sleep(1500);
            sendKeys(DOWN, locatorOrigen);
            Thread.sleep(1500);
            sendKeys(ENTER, locatorOrigen);
            Thread.sleep(1500);
        }
        if(deseaCambiarDestino){
            limpiar.get(1).click();
            click(locatorDestino);
            write(nuevoDestinoVuelo, locatorDestino);
            Thread.sleep(1500);
            sendKeys(DOWN, locatorDestino);
            Thread.sleep(1500);
            sendKeys(ENTER, locatorDestino);
            Thread.sleep(1500);
        }
        click(btnBuscarOtraVez);
        Thread.sleep(3000);
    }

    public void filtrarLATAM() throws InterruptedException {
        if(isDisplayed(btnVerMas)){
            scrolling(btnVerMas);
            click(btnVerMas);
            Thread.sleep(2000);
            click(locatorElegirLatam);
            Thread.sleep(4000);
        }else {
            scrolling(locatorElegirLatam);
            Thread.sleep(1500);
            click(locatorElegirLatam);
            Thread.sleep(4000);
        }

    }

    public void filtrarUnitedAirlines() throws InterruptedException {

        if(isDisplayed(btnVerMas)){
            scrolling(btnVerMas);
            Thread.sleep(1000);
            click(btnVerMas);
            Thread.sleep(2000);
            click(locatorElegirUnited);
            Thread.sleep(4000);
        }else {
            scrolling(locatorElegirUnited);
            Thread.sleep(1500);
            click(locatorElegirUnited);
            Thread.sleep(4000);
        }
    }
}
