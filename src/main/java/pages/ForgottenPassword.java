package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static data.TestData.FORGPASS_URL;


public class ForgottenPassword {
    private WebDriver driver;

    // Кнопка Войти
    private By loginButton = By.xpath(".//a[text()='Войти']");
    private By refindBtn = By.xpath(".//button[text()='Восстановить']");

    public ForgottenPassword(WebDriver driver){
        this.driver = driver;
    }
@Step
public WebElement refindBttn() {
    return driver.findElement(refindBtn);
}
    // Нажатие на кнопку Войти
    @Step
    public void loginButtonClick () {
        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(loginButton));
        driver.findElement(loginButton).click();
    }
    @Step
    public void openPage(){
        driver.get(FORGPASS_URL);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(refindBttn()));
    }
}
