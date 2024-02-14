import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class LoginFailed {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\user\\Webdriver\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("locked_out_user");
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.cssSelector("input[value='Login']")).click();

        WebElement textError = driver.findElement(By.xpath("//h3[@data-test='error']"));
        String textErrorData = textError.findElement(By.xpath("//h3[@data-test='error']")).getText();
        System.out.println(textErrorData.equals("Epic sadface: Sorry, this user has been locked out."));

        driver.findElement(By.xpath("//button[@class='error-button']")).click();

        Thread.sleep(5000);

        driver.navigate().refresh();

        driver.close();
        driver.quit();

    }
}
