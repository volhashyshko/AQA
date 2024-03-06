package tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.Driver;
import utils.Log;
import java.util.concurrent.TimeUnit;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestE2E {
        public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\user\\Webdriver\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        @BeforeAll
            public void setUp(){

    Log.info("Открываем начальную страницу");
    driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
    driver.get("https://www.saucedemo.com/");
    driver.findElement(By.id("user-name")).sendKeys("standard_user");
    driver.findElement(By.name("password")).sendKeys("secret_sauce");
    driver.findElement(By.cssSelector("input[value='Login']")).click();
    Log.info("Проверяем, что открыта корректная страница saucedemo");
    String pageTitle = driver.getTitle();
    Assertions.assertEquals("Swag Labs ", pageTitle, "Открыта не Swag Labs или название страницы неверно");
}

    //public static void main(String[] args) throws InterruptedException {
        //System.setProperty("webdriver.chrome.driver","C:\\Users\\user\\Webdriver\\chromedriver-win64\\chromedriver.exe");
        //WebDriver driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //driver.get("https://www.saucedemo.com/");
        //driver.findElement(By.id("user-name")).sendKeys("standard_user");
        //driver.findElement(By.name("password")).sendKeys("secret_sauce");
        //driver.findElement(By.cssSelector("input[value='Login']")).click();

    @BeforeEach
            Log.info("Открываем начальную страницу");
            @Test
    @DisplayName("")
        driver.findElement(By.xpath("//select[@class='product_sort_container']")).click();
        driver.findElement(By.xpath("//option[@value='lohi']")).click();
        WebElement buttonAdd = driver.findElement(By.xpath("//button[@class='btn btn_primary btn_small btn_inventory '][1]"));
        String buttonAddName = buttonAdd.findElement(By.xpath("//button[@class='btn btn_primary btn_small btn_inventory ']")).getText();
        System.out.println(buttonAddName.equals("Add to cart"));

        driver.findElement(By.xpath("//button[@class='btn btn_primary btn_small btn_inventory '][1]")).click();
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
        driver.findElement(By.xpath("//button[@name='checkout']")).click();

        driver.findElement(By.id("first-name")).sendKeys("Ol");
        driver.findElement(By.id("last-name")).sendKeys("Shi");
        driver.findElement(By.id("postal-code")).sendKeys("00123");
        driver.findElement(By.xpath("//input[@name='continue']")).click();

        driver.findElement(By.xpath("//button[@name='finish']")).click();

        WebElement textSuccess = driver.findElement(By.xpath("//h2[@class='complete-header']"));
        String buttonName = textSuccess.findElement(By.xpath("//h2[@class='complete-header']")).getText();
        System.out.println(buttonName.equals("Thank you for your order!"));

        driver.findElement(By.xpath("//button[@name='back-to-products']")).click();

        driver.findElement(By.id("react-burger-menu-btn")).click();

        driver.findElement(By.id("logout_sidebar_link")).click();

        Thread.sleep(5000);


        driver.close();
        driver.quit();

    }
}
