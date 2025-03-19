package steps.facebookSteps;

import driver.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import pages.FacebookLoginPage;

public class FacebookLoginSteps {
    FacebookLoginPage facebookLoginPage = new FacebookLoginPage();

    @Given("User navigate to the login page")
    public void user_navigate_to_the_login_page() {
        DriverManager.getWebDriver().get("https://www.facebook.com/login.php/");
        DriverManager.getWebDriver().manage().window().maximize();
    }
    @When("User enter the username {string}")
    public void user_enter_the_username(String string) {
        facebookLoginPage.getUserNameLocation().sendKeys(string);

    }
    @When("User enter the password {string}")
    public void user_enter_the_password(String string) {
        facebookLoginPage.getPasswordLocation().sendKeys(string);

    }
    @When("User click on the login button")
    public void user_click_on_the_login_button() {
        facebookLoginPage.getLoginButtonLocation().click();
    }
    @Then("User should login successfully")
    public void user_should_login_successfully() {
    }

}
