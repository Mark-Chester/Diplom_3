import apiPages.UserLoginBodyModel;
import io.restassured.RestAssured;
import org.junit.After;
import org.junit.BeforeClass;

import static data.TestData.*;
import static steps.ApiSteps.userDeleteAfterLogin;

public class BaseApiTest {
    public boolean skipUserDelete = false;
    @BeforeClass
    public static void setUp(){
        RestAssured.baseURI = BASE_URL;
    }
    @After
    public void shtDwn(){
        UserLoginBodyModel user = new UserLoginBodyModel(EMAIL,PASSWORD);
        if (!skipUserDelete) {
            userDeleteAfterLogin(user);
        }
    }
}
