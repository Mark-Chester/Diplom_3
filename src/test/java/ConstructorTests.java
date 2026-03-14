import io.qameta.allure.Description;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pages.MainPage;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ConstructorTests extends BaseTest{
    private final String browser;
    public ConstructorTests(String browser){
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
    public void skipDeletions(){
        skipUserDelete = true;
    }
    @Test
    @Description("Проверка возможности перехода к разделу Начинки на главной странице")
    public void SwitchingToSectionTopping() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openPage();
        mainPage.sectionToppingClick();

        String expectedText = "Начинки";
        String actualText = mainPage.returnSelectedSection(expectedText);
        assertEquals("Не произошел переход к нужному разделу", expectedText, actualText);
    }

    @Test

    @Description("Проверка возможности перехода к разделу Соусы на главной странице")
    public void SwitchingToSectionSauce() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openPage();
        mainPage.sectionToppingClick();
        mainPage.sectionSauceClick();

        String expectedText = "Соусы";
        String actualText = mainPage.returnSelectedSection(expectedText);
        assertEquals("Не произошел переход к нужному разделу", expectedText, actualText);
    }

    @Test
    @Description("Проверка возможности перехода к разделу Булки на главной странице")
    public void SwitchingToSectionBun() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openPage();
        mainPage.sectionToppingClick();
        mainPage.sectionBunClick();

        String expectedText = "Булки";
        String actualText = mainPage.returnSelectedSection(expectedText);
        assertEquals("Не произошел переход к нужному разделу", expectedText, actualText);
    }

}
