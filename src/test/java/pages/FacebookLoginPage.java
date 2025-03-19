package pages;

import driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FacebookLoginPage {
    public FacebookLoginPage(){
        PageFactory.initElements(DriverManager.getWebDriver(),this);
    }

    @FindBy(id = "email")
    private WebElement userNameLocation;
    @FindBy(id = "pass")
     private WebElement passwordLocation;
    @FindBy(id = "loginbutton")
    private WebElement loginButtonLocation;

    public WebElement getUserNameLocation() {
        return userNameLocation;
    }

    public WebElement getPasswordLocation() {
        return passwordLocation;
    }

    public WebElement getLoginButtonLocation() {
        return loginButtonLocation;
    }
}
