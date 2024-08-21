package pageObjects;

import org.openqa.selenium.WebDriver;

public class CloseBrowser {

    private final WebDriver driver;

    public CloseBrowser(WebDriver driver) {
        this.driver = driver;
    }

    public void quit() {
        driver.close();
        driver.quit();
        System.out.println("Браузер закрыт");
    }
}
