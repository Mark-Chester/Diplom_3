import api.UserCreationModel;
import io.qameta.allure.Description;
import org.junit.Before;
import org.junit.Test;
import pages.ForgottenPassword;
import pages.MainPage;
import pages.RegistrationPage;
import steps.LoginSteps;

import static data.TestData.*;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertTrue;
import static steps.ApiSteps.userCreationResponse;


public class LoginTests extends BaseTest{
    public LoginTests(){
        super(getBrowserFromEnv());
    }

    private static String getBrowserFromEnv() {
        String browser = System.getenv("BROWSER");
        if (browser == null || browser.isEmpty()) {
            throw new IllegalArgumentException("Переменная окружения BROWSER не установлена");
        }
        return browser;
    }
    @Before
    public void userCreation(){
        UserCreationModel user = new UserCreationModel(EMAIL,PASSWORD,USERNAME);
        userCreationResponse(user)
                .then()
                .log().all()
                .statusCode(SC_OK)
                .body("success",equalTo(true));
    }
@Test
@Description("Логин через кнопку Войти в аккаунт на главной странице")
public void successLoginBtnTest(){
    MainPage mainPage = new MainPage(driver);
    LoginSteps loginSteps = new LoginSteps(driver);
    mainPage.openPage();
    mainPage.loginButtonClick();
    loginSteps.loginUser(EMAIL,PASSWORD);
    assertTrue("Авторизация не произошла", mainPage.createOrderButtonIsDisplayed());
}
@Test
    @Description("Вход через кнопку Личный кабинет")
    public void successCabinetLoginTest(){
    MainPage mainPage = new MainPage(driver);
    LoginSteps loginSteps = new LoginSteps(driver);
    mainPage.openPage();
    mainPage.profileButtonClick();
    loginSteps.loginUser(EMAIL,PASSWORD);
    assertTrue("Авторизация не произошла", mainPage.createOrderButtonIsDisplayed());
}
@Test
    @Description("Вход через кнопку войти на странице регистрации")
    public void successLoginRegisterFormBtnTest(){
    RegistrationPage registerPage = new RegistrationPage(driver);
    LoginSteps loginSteps = new LoginSteps(driver);
    registerPage.openPage();
    registerPage.loginButtonClick();
    loginSteps.loginUser(EMAIL,PASSWORD);
    assertTrue("Авторизация не произошла", mainPage.createOrderButtonIsDisplayed());
}
@Test
    @Description("Вход через кнопку войти на странице восстановления пароля")
    public void successLoginForgottenPasswordPageBtnTest(){
    ForgottenPassword forgottenPassword = new ForgottenPassword(driver);
    LoginSteps loginSteps = new LoginSteps(driver);
    forgottenPassword.openPage();
    forgottenPassword.loginButtonClick();
    loginSteps.loginUser(EMAIL,PASSWORD);
    assertTrue("Авторизация не произошла", mainPage.createOrderButtonIsDisplayed());
}
}
