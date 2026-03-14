import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.MainPage;
import pages.RegistrationPage;

public class BaseTest extends BaseApiTest{
        WebDriver driver;
        MainPage mainPage;
        RegistrationPage registrationPage;
        String browser = System.getProperty("browser","chrome");
        public BaseTest(String browser) {
            if(browser.equals("chrome")){
                startBrowserChrome();
            } else if (browser.equals("yandex")) {
                startBrowserYandex();
            }
            mainPage = new MainPage(driver);
            registrationPage = new RegistrationPage(driver);
        }
        public void startBrowserChrome(){
            driver = new ChromeDriver();
            WebDriverManager.chromedriver().setup();
        }
        public void startBrowserYandex(){
            System.setProperty("webdriver.chrome.driver", "C:/JavaProjects/yandexdriver.exe");
            driver = new ChromeDriver();
            WebDriverManager.chromedriver().setup();
        }
        @After
        public void tearDown(){
            driver.quit();
        }
}
