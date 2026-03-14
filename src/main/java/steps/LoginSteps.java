package steps;

import org.openqa.selenium.WebDriver;
import pages.LoginPage;


public class LoginSteps {
    private WebDriver driver;
public LoginSteps(WebDriver driver){
    this.driver = driver;
}
    public void loginUser(String useremail,String userpassword){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.waitBtnLoaded();
        loginPage.setEmail(useremail);
        loginPage.setPassword(userpassword);
        loginPage.loginBtnClck();

    }
}
