/*
package eu.senla.tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Driver;
import java.time.Duration;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestLogUser {
        private final WebDriver driver = Driver.getChromeDriver();
    @Test
    @Order(1)
    @DisplayName("Проверка блокировки пользователя")
    public void logInLocked() throws InterruptedException {
        System.out.println("Начальная страница открыта");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(4));
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("locked_out_user");
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.cssSelector("input[value='Login']")).click();

        System.out.println("Проверка текста сообщения об ошибке");
        WebElement textErrorLog = driver.findElement(By.xpath("//h3[@data-test='error']"));
        String textErrorDataLog = textErrorLog.findElement(By.xpath("//h3[@data-test='error']")).getText();
        System.out.println(textErrorDataLog.equals("Epic sadface: Sorry, this user has been locked out."));
        Assertions.assertEquals("Epic sadface: Sorry, this user has been locked out.", textErrorDataLog, "Сообщение об ошибке отсутсвует или не соответсвует ТЗ");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@class='error-button']")).click();
        driver.navigate().refresh();
    }

    @Test
    @Order(2)
    @Disabled ("Тест, который проигнорирован при запуске")
    @DisplayName("Проверка успешного входа пользователя- забагованная версия")
    public void logIn() throws InterruptedException {
        System.out.println("Начальная страница открыта");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(4));
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("problem_user");
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.cssSelector("input[value='Login']")).click();

        System.out.println("Осуществлен переход на главную страницу");
        String pageTitle = driver.getTitle();
        Assertions.assertEquals("Swag Labs", pageTitle, "Открыта не Swag Labs или название страницы неверно");

        Thread.sleep(1000);
    }
    @AfterAll
    public void quit(){
        driver.close();
        driver.quit();
        System.out.println("Браузер закрыт");
    }
}


*/
