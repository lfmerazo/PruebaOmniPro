package pageobjects;

import actions.SelectOptions;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AppointmentPage extends PageObject {
    @FindBy(id = "combo_facility")
    public WebElementFacade facilityListD;

    @FindBy(id = "chk_hospotal_readmission")
    public WebElementFacade hospitalReadmissionCheck;

    @FindBy(xpath = "//form[@class='form-horizontal']/div[3]/div")
    public WebElementFacade healthcareProgramElement;

    @FindBy(xpath = "//label[@class='radio-inline']")
    public List<WebElementFacade> listHealthcareProgram;

    @FindBy(id = "txt_visit_date")
    public WebElementFacade visitDateTxt;

    @FindBy(id = "txt_comment")
    public WebElementFacade commentTxt;

    @FindBy(id = "btn-book-appointment")
    public WebElementFacade appointmentBtn;

    @FindBy(xpath = "//h2[text()='Appointment Confirmation']")
    public WebElementFacade appointmentConfirmationLbl;

    @FindBy(xpath = "//div[@class = 'input-group-addon']")
    public WebElementFacade calendarBtn;
    @FindBy(xpath = "//div[@class = 'datepicker-days']/table/tbody/tr/td[@class='day'][6]")
    public WebElementFacade dayCalendarBtn;

    //campos resumen cita
    @FindBy(id = "facility")
    public WebElementFacade facilityLbl;
    @FindBy(id = "hospital_readmission")
    public WebElementFacade hospitalReadmissionLbl;
    @FindBy(id = "program")
    public WebElementFacade programLbl;
    @FindBy(id = "visit_date")
    public WebElementFacade visitDateLbl;
    @FindBy(id = "comment")
    public WebElementFacade commentLbl;

    @FindBy(id = "menu-toggle")
    public WebElementFacade menuToggle;

    @FindBy(xpath = "//a[text() = 'History']")
    public WebElementFacade historyLink;


    public void diligenciarFormCita(String facility, String readmission, String programHealthcare, String visitDate, String comment) throws InterruptedException {

        element(healthcareProgramElement).waitUntilVisible();
        seleccionarFacility(facility);

        element(healthcareProgramElement).waitUntilVisible();
        SelectOptions.in(listHealthcareProgram, programHealthcare);

        if (readmission.equals("Yes")) {
            hospitalReadmissionCheck.click();
        }

        visitDateTxt.type(visitDate);

        commentTxt.type(comment);

        appointmentBtn.click();
    }

    public void diligenciarFormCita2(String facility, String readmission, String programHealthcare, String visitDate, String comment) throws InterruptedException {

        element(healthcareProgramElement).waitUntilVisible();
        seleccionarFacility(facility);

        element(healthcareProgramElement).waitUntilVisible();
        SelectOptions.in(listHealthcareProgram, programHealthcare);

        if (readmission.equals("Yes")) {
            hospitalReadmissionCheck.click();
        }

        visitDateTxt.type(visitDate);

        commentTxt.type(comment);

        appointmentBtn.click();
    }

    public void seleccionarFacility(String option) {
        element(facilityListD).waitUntilVisible();
        List<WebElement> elements = facilityListD.findElements(By.tagName("option"));
        for(WebElement element : elements){
            if(element.getText().contains(option)){
                element.click();
                break;
            }
        }
    }

    public void validarappointmentExitoso(String facility, String readmission, String programHealthcare, String visitDate, String comment) throws InterruptedException {

        element(appointmentConfirmationLbl).waitUntilVisible();

        Assert.assertEquals(facilityLbl.getText(), facility);
        Assert.assertEquals(hospitalReadmissionLbl.getText(), readmission);
        Assert.assertEquals(programLbl.getText(), programHealthcare);
        Assert.assertEquals(visitDateLbl.getText(), visitDate);
        Assert.assertEquals(commentLbl.getText(), comment);
    }
}