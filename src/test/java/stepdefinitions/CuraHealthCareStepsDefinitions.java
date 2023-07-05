package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import pageobjects.*;

public class CuraHealthCareStepsDefinitions {
    @Steps
    HomePage homePage;
    @Steps
    LoginPage loginPage;

    @Steps
    AppointmentPage appointment;

    @Given("^que el usuario ingresa a la web CURA Healthcare Service$")
    public void queElUsuarioIngresaALaWebCURAHealthcareService(){
        homePage.open();
        homePage.irALoginPage();
    }

    // Escenario Login-exitoso
    @When("^ingreso el usuario (.*) y contrasenia (.*) correctos$")
    public void ingresoElUsuarioYContraseniaCorrectos(String username, String password) {
        loginPage.ingresarCredenciales(username,password);
    }

    @Then("^inicia sesion de manera exitosa$")
    public void iniciaSesionDeManeraExitosa() {
        loginPage.validarLoginExitoso();
    }

    // Escenario Login-no-exitoso

    @When("^ingreso el usuario (.*) y contrasenia (.*) incorrectos$")
    public void ingresoElUsuarioYContraseniaIncorrectos(String username, String password) {
        loginPage.ingresarCredenciales(username,password);
    }

    @Then("^el sistema no inicia sesion$")
    public void elSistemaNoIniciaSesion() throws InterruptedException {
        loginPage.validarLoginNoExitoso();
    }

    // Escenario cita-exitosa

    @And("^diligencio la solicitud de cita (.*), (.*), (.*), (.*) y (.*)$")
    public void diligencioLaSolicitudDeCita(String facility, String readmission, String programHealthcare, String visitDate, String comment) throws InterruptedException {
        appointment.diligenciarFormCita(facility, readmission, programHealthcare, visitDate, comment);
    }

    @Then("^se agenda la cita de manera exitosa con los datos registrados (.*), (.*), (.*), (.*) y (.*)$")
    public void seAgendaLaCitaDeManeraExitosaConLosDatosRegistrados(String facility, String readmission, String programHealthcare, String visitDate, String comment) throws InterruptedException {
        appointment.validarappointmentExitoso(facility, readmission, programHealthcare, visitDate, comment);
    }

}
