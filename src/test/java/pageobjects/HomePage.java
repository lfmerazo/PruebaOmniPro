package pageobjects;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageObject {
    @FindBy(id = "menu-toggle")
    public WebElementFacade menuToggle;
    @FindBy(xpath = "//a[text() = 'Login']")
    public WebElementFacade loginLink;

    @FindBy(xpath = "//a[text() = 'History']")
    public WebElementFacade historyLink;

    @FindBy(xpath = "//a[text() = 'Profile']")
    public WebElementFacade profileLink;

    @FindBy(id = "sidebar-wrapper")
    public WebElement sldMenu;

    public void irALoginPage(){
        element(menuToggle).waitUntilVisible();
        menuToggle.click();
        loginLink.click();
    }

    public void irAHistoryPage(){
        element(menuToggle).waitUntilVisible();
        menuToggle.click();
        element(historyLink).waitUntilVisible();
        historyLink.click();
    }

    public void irAProfilePage(){
        element(menuToggle).waitUntilVisible();
        menuToggle.click();
        element(profileLink).waitUntilVisible();
        profileLink.click();
    }
}
