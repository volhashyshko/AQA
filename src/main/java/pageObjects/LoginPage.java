package pageObjects;

import static com.codeborne.selenide.Selenide.*;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;

public class LoginPage {
    public LoginPage(){
    }
    public void openLoginPage() {
        System.out.println("Начальная страница открыта");
        Configuration.browser = "chrome";
        Configuration.headless = false;
        Configuration.browserSize = String.valueOf(true);
        open("https://www.saucedemo.com/");
    }
    public void enterCredentials(String username, String password) {
        $("#user-name").setValue("standard_user");
        $("#password").setValue("secret_sauce");
    }
    public void clickLoginButton() {
        $(By.cssSelector("input[value='Login']")).click();
        System.out.println("Осуществлен переход на главную страницу");
    }
    public void verifyPageTitle() {
        Assertions.assertEquals("Products", $(".title").getText());
       // String expectedTitle = "Swag Labs";
        //String actualTitle = driver.getTitle();
        //Assertions.assertEquals(expectedTitle, actualTitle, "Открыта не Swag Labs или название страницы неверно");
    }
    public long getTotalItemCount() {
        int count = $$(".inventory_item").size();
        System.out.println("Количество товаров на странице: " + count);
        return 0;
    }
}

