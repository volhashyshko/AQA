package eu.senla.tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Driver;
import java.time.Duration;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestLockedUser {
        private final WebDriver driver = Driver.getChromeDriver();
    @Test
    @DisplayName("Проверка блокировки пользователя")
    public void logIn() {
        System.out.println("Начальная страница открыта");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("locked_out_user");
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.cssSelector("input[value='Login']")).click();

        System.out.println("Проверка текста сообщения об ошибке");
        WebElement textErrorLog = driver.findElement(By.xpath("//h3[@data-test='error']"));
        String textErrorDataLog = textErrorLog.findElement(By.xpath("//h3[@data-test='error']")).getText();
        System.out.println(textErrorDataLog.equals("Epic sadface: Sorry, this user has been locked out."));
        Assertions.assertEquals("Epic sadface: Sorry, this user has been locked out.", textErrorDataLog, "Сообщение об ошибке отсутсвует или не соответсвует ТЗ");

        driver.findElement(By.xpath("//button[@class='error-button']")).click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        driver.navigate().refresh();
    }
    @AfterAll
    public void quit(){
        driver.quit();
        System.out.println("Браузер закрыт");
    }
}
