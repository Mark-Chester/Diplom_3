package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static data.TestData.*;


public class RegistrationPage {
    //поле Имя
private By name = By.xpath("(//label[text()='Имя']/following::input)");
    //поле имейл
    private By email = By.xpath("(//label[text()='Email']/following::input)");
    //поле пароль
    private By password = By.xpath(".//input[@type='password']");
    // кнопка Зарегистрироваться
    private By register = By.xpath(".//button[text()='Зарегистрироваться']");
    //кнопка Войти
    private By enter = By.xpath(".//a[@href='/login']");
    //сообщени об ошибке пароля
    private By errorMsg = By.xpath(".//p[text()='Некорректный пароль']");
    private WebDriver driver;
    public RegistrationPage(WebDriver driver){
        this.driver = driver;
    }
    public WebElement registerBttn() {
        return driver.findElement(register);
    }

@Step("Заполнение поля Name")
public void setName(String username){
    driver.findElement(name).sendKeys(username);
}
@Step("Заполнение поля Email")
public void setEmail(String useremail){
        driver.findElement(email).sendKeys(useremail);
    }
@Step("Заполнение поля Password")
    public void setPassword(String userpassword){
    driver.findElement(password).sendKeys(userpassword);
    }
    @Step("Нажатие кнопки Зарегистрироваться")
    public void registerClick(){
        driver.findElement(register).click();
    }
    @Step("Ожидание прогрузки кнопки Зарегистрироваться")
    public void waitRgstrLoaded(){
        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(register));
    }

@Step("Проверка видимости сообщения о неверном пароле")
public boolean wrongPasswordTextIsVisuable(){
        new WebDriverWait(driver,Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(errorMsg));
        try{return driver.findElement(errorMsg).isDisplayed();}catch (NoSuchElementException e){return false;}
}
@Step("Нажатие на кнопку Войти")
public void loginButtonClick(){
        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(enter));
        driver.findElement(enter).click();
}
@Step("Открытие страницы регистрации")
    public void openPage(){
        driver.get(REGISTRATION_URL);
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
    wait.until(ExpectedConditions.visibilityOf(registerBttn()));
    }
}
