import apiPages.UserCreationModel;
import io.qameta.allure.Description;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pages.ForgottenPassword;
import pages.MainPage;
import pages.RegistrationPage;
import steps.LoginSteps;

import static data.TestData.*;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertTrue;
import static steps.ApiSteps.userCreationResponse;

@RunWith(Parameterized.class)
public class LoginTests extends BaseTest{
    private final String browser;
    public LoginTests(String browser){
        super(browser);
        this.browser = browser;
    }
    @Parameterized.Parameters(name = "Browser {0}")
    public static Object[][] getBrowserTest(){
        return new Object[][] {
                {"chrome"},
                {"yandex"}
        };
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
