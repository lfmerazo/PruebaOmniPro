package pageobjects;

import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends PageObject {
    public static String strProfile = "Profile";

    @FindBy(xpath = "//h2[normalize-space()='Profile']")
    private WebElement lblTitleProfilePage;

    public void validarTitleProfilePage(String titleProfilePage){
        element(lblTitleProfilePage).waitUntilVisible();
        Assert.assertEquals(lblTitleProfilePage.getText(), titleProfilePage);
    }

}
