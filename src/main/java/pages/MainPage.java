package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static data.TestData.BASE_URL;

public class MainPage {
    // PageObject для главной страницы
    private WebDriver driver;

    //Кнопка Войти в аккаунт
    private By loginButton = By.xpath(".//button[text()='Войти в аккаунт']");
    // Кнопка Личный кабинет
    private By profileButton = By.xpath(".//a[@href='/account']");
    // Кнопка Оформить заказ
    private By createOrderButton = By.xpath(".//button[text()='Оформить заказ']");
    // раздел Булки
    private By sectionBun = By.xpath(".//span[text()='Булки']");
    // раздел Соусы
    private By sectionSauce = By.xpath(".//span[text()='Соусы']");
    // раздел Начинки
    private By sectionTopping = By.xpath(".//span[text()='Начинки']");

    public MainPage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement loginBttn() {
        return driver.findElement(loginButton);
    }
    // Нажатие на кнопку Войти в аккаунт
    @Step
    public void loginButtonClick () {
        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(loginButton));
        driver.findElement(loginButton).click();
    }


    // Нажатие на кнопку Личный кабинет
    @Step
    public void profileButtonClick () {
        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(profileButton));
        driver.findElement(profileButton).click();
    }

    // Нажатие на раздел Булки
    @Step
    public void sectionBunClick () {
        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(sectionBun));
        driver.findElement(sectionBun).click();
    }

    // Нажатие на раздел Соусы
    @Step
    public void sectionSauceClick () {
        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(sectionSauce));
        driver.findElement(sectionSauce).click();
    }

    // Нажатие на раздел Начинки
    @Step
    public void sectionToppingClick () {
        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(sectionTopping));
        driver.findElement(sectionTopping).click();
    }
    // Проверка отображения кнопки Оформить заказ
    @Step
    public boolean createOrderButtonIsDisplayed() {
        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(createOrderButton));
        try {
            return driver.findElement(createOrderButton).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    // Возвращает выбранный элемент в конструкторе
    @Step
    public String returnSelectedSection(String sectionName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.textToBe(By.xpath(".//div[contains(@class, 'current')]/span"), sectionName));
        return driver.findElement(By.xpath(".//div[contains(@class, 'current')]/span")).getText();
    }
    @Step
    public void openPage(){
        driver.get(BASE_URL);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOf(loginBttn()));
    }

}
