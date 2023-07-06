package pageobjects;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HistoryPage extends PageObject {
    @FindBy(id = "menu-toggle")
    public WebElementFacade menuToggle;

    @FindBy(xpath = "//h2[normalize-space()='History']")
    private WebElement titleHistoryPage;

    @FindBy(xpath = "//a[text() = 'History']")
    public WebElementFacade historyLink;

    @FindBy(xpath = "//body/section[@id='history']/div[@class='container']/div[2]")
    private List<WebElementFacade> historyList;

    //div[@class='panel-heading']

    public void desplegarMenu(){
        element(menuToggle).waitUntilVisible();
        menuToggle.click();
    }

    public void irAHistoryPage(){
        element(menuToggle).waitUntilVisible();
        historyLink.click();
    }

    public boolean validarCitaEnHistorial(String option) {
        element(titleHistoryPage).waitUntilVisible();
        for (WebElement element:historyList){
            if(element.getText().contentEquals(option)){
                return true;
            }
        }
        return false;
    }
}