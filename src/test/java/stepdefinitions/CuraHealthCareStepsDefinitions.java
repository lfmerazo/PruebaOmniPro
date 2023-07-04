package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import pageobjects.HomePage;
import pageobjects.LoginPage;

public class CuraHealthCareStepsDefinitions {
    @Steps
    HomePage homePage;

    @Steps
    LoginPage loginPage;

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

}
