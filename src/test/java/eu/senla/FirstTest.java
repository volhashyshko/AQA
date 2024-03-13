package eu.senla;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class FirstTest {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\user\\Webdriver\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.cssSelector("input[value='Login']")).click();
        driver.findElement(By.xpath("//select[@class='product_sort_container']")).click();
        driver.findElement(By.xpath("//option[@value='hilo']")).click();

        WebElement jacket = driver.findElement(By.xpath("//div[@class='inventory_item_name '][1]"));
        String jaketName = jacket.findElement(By.xpath("//div[@class='inventory_item_name ']")).getText();
        //System.out.println(jaketName);
        System.out.println(jaketName.equals("12345")); //- выведет true или false

        Thread.sleep(5000);

        driver.close();
        driver.quit();

    }

    }

