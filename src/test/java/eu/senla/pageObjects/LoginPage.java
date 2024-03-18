package eu.senla.pageObjects;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;

public class LoginPage {
    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openLoginPage() {
        System.out.println("Начальная страница открыта");
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        driver.get("https://www.saucedemo.com/");
    }

    public void enterCredentials(String username, String password) {
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(By.cssSelector("input[value='Login']")).click();
        System.out.println("Осуществлен переход на главную страницу");
    }

    public void verifyPageTitle() {
        String expectedTitle = "Swag Labs";
        String actualTitle = driver.getTitle();
        Assertions.assertEquals(expectedTitle, actualTitle, "Открыта не Swag Labs или название страницы неверно");
    }

    public long getTotalItemCount() {
                return driver.findElements(By.xpath("//div[@class='inventory_item']")).size();
    }
}
