package aut.testcreation.testcases;

import aut.testcreation.pages.vuelos.*;
import framework.engine.selenium.DriverFactory;
import framework.engine.selenium.SeleniumTestBase;
import org.junit.jupiter.api.Test;

public class TC002_POM extends SeleniumTestBase {
    RumboHomePage rumboHomePage;
    OfertasVuelosPage ofertasVuelosPage;
    TarifaVueloPage tarifaVueloPage;
    FormularioVuelosPage formularioVuelosPage;
    ServiciosAdicionalesPage serviciosAdicionalesPage;

    @Test
    void registroVuelo() throws InterruptedException {
        rumboHomePage = new RumboHomePage(DriverFactory.getDriver());
        ofertasVuelosPage = new OfertasVuelosPage(DriverFactory.getDriver());
        tarifaVueloPage = new TarifaVueloPage(DriverFactory.getDriver());
        formularioVuelosPage = new FormularioVuelosPage(DriverFactory.getDriver());
        serviciosAdicionalesPage = new ServiciosAdicionalesPage(DriverFactory.getDriver());
        rumboHomePage.irARumboYCookies(true);
        rumboHomePage.seleccioneTipoDeVuelo(true, false,false);
        rumboHomePage.limpiarCampos(true, false);
        rumboHomePage.agregarOrigen("Santiago (SCL)");
        rumboHomePage.agregarDestino("Portland (PDX)");
        rumboHomePage.fechas();
        rumboHomePage.numPasajeros(true);
        rumboHomePage.realizarBusqueda();
        ofertasVuelosPage.cambiarPestaniaARumbo();
        ofertasVuelosPage.filtrarUnitedAirlines();
        ofertasVuelosPage.seleccionarOferta();
        tarifaVueloPage.elegirTarifa(true);
        formularioVuelosPage.datosPrincipalesContacto("Ana", "Rodriguez", "Holamundo2222@gmail.com", "9874563");
        formularioVuelosPage.preguntarSaludoAContacto(false);
        formularioVuelosPage.fechaNacimientoContacto("15", "1992");
        formularioVuelosPage.preguntarSaludoASgdoPasajero(true);
        formularioVuelosPage.datosSegundoPasajero("Gabriel", "Martinez", "15", "1991");
        formularioVuelosPage.checksFinales(true,false);
        formularioVuelosPage.bajarYPresionarEnSgte();
        if (serviciosAdicionalesPage.mensajeServiciosAdicEncontrado().equals("Servicios adicionales")) {
            System.out.println("Test completado con éxito: La ejecución del test finaliza en la pestaña 'Servicios adicionales'. \nMensaje: 'Servicios adicionales' ha sido encontrado y desplegado en pantalla.\n ");
        } else {
            System.out.println("Test sin éxito: No ha sido posible encontrar el mensaje: 'Servicios adicionales'. \n");
        }
    }
}