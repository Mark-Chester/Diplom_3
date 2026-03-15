package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;


public class LoginSteps {
    private WebDriver driver;
public LoginSteps(WebDriver driver){
    this.driver = driver;
}
@Step("Заполнение формы входа и нажатие на кнопку Войти")
    public void loginUser(String useremail,String userpassword){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.waitBtnLoaded();
        loginPage.setEmail(useremail);
        loginPage.setPassword(userpassword);
        loginPage.loginBtnClck();

    }
}
