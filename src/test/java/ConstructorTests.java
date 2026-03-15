import io.qameta.allure.Description;
import org.junit.Before;
import org.junit.Test;
import pages.MainPage;

import static org.junit.Assert.assertEquals;

public class ConstructorTests extends BaseTest{
public ConstructorTests() {
    // Инициализация через переменную окружения
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
