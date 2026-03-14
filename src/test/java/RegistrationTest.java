import apiPages.UserLoginBodyModel;
import io.qameta.allure.Description;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pages.RegistrationPage;
import steps.RegistrationSteps;

import static data.TestData.*;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertTrue;
import static steps.ApiSteps.userLogin;

@RunWith(Parameterized.class)
public class RegistrationTest extends BaseTest{
private final String browser;

public RegistrationTest(String browser){
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
