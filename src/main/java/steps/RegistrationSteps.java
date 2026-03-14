package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.RegistrationPage;

public class RegistrationSteps {
    private WebDriver driver;
   public RegistrationSteps(WebDriver driver){
        this.driver = driver;
    }
    @Step
    public void registration(String username, String useremail, String userpassword){
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.waitRgstrLoaded();
        registrationPage.setName(username);
        registrationPage.setEmail(useremail);
        registrationPage.setPassword(userpassword);
        registrationPage.registerClick();
    }
}
