package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    // PageObject для страницы входа
    private WebDriver driver;

    // Email
    private By emailField = By.xpath(".//label[text()='Email']/following::input");
    // Пароль
    private By passwordField = By.xpath(".//input[@type='password']");
    //Кнопка Войти
    private By loginButton = By.xpath(".//button[text()='Войти']");


    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    @Step("Заполнение поля email")
    public void setEmail(String userEmail){
        driver.findElement(emailField).sendKeys(userEmail);
    }
    @Step("Заполнение поля Password")
    public void setPassword(String userPassword){
        driver.findElement(passwordField).sendKeys(userPassword);
    }
    @Step("Нажатие на кнопку Войти")
    public void loginBtnClck(){
        driver.findElement(loginButton).click();
    }
    @Step("Ожидание появления кнопки войти")
    public void waitBtnLoaded(){
        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(loginButton));
    }

}