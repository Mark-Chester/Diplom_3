import api.UserLoginBodyModel;
import io.qameta.allure.Description;
import org.junit.Test;
import pages.RegistrationPage;
import steps.RegistrationSteps;

import static data.TestData.*;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertTrue;
import static steps.ApiSteps.userLogin;


public class RegistrationTest extends BaseTest{
public RegistrationTest(){
    super(getBrowserFromEnv());
}

    private static String getBrowserFromEnv() {
        String browser = System.getenv("BROWSER");
        if (browser == null || browser.isEmpty()) {
            throw new IllegalArgumentException("Переменная окружения BROWSER не установлена");
        }
        return browser;
    }
@Test
    @Description("Успешная регистрация пользователя")
    public void successRegistrationTest(){
    RegistrationPage registerPage = new RegistrationPage(driver);
    RegistrationSteps registrationSteps = new RegistrationSteps(driver);
    registerPage.openPage();
    registrationSteps.registration(USERNAME,EMAIL,PASSWORD);

    UserLoginBodyModel user = new UserLoginBodyModel(EMAIL,PASSWORD);
    userLogin(user)
            .then()
            .log().all()
            .statusCode(SC_OK)
            .body("success", equalTo(true));
}
@Test
    @Description("Проверка сообщения о неправильном пароле при использовании пароля менее 6 символов")
    public void cantRegisterWithShortPasswordTest(){
    RegistrationPage registerPage = new RegistrationPage(driver);
    RegistrationSteps registrationSteps = new RegistrationSteps(driver);
    skipUserDelete = true;
    registerPage.openPage();
    registrationSteps.registration(USERNAME,EMAIL,WRONG_PASSWORD);
    assertTrue("Не появилось сообщение о некорректном пароле", registerPage.wrongPasswordTextIsVisuable());
}
}
