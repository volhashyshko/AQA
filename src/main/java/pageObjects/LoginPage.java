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
        $("#user-name").setValue(username);
        $("#password").setValue(password);
    }
    public void clickLoginButton() {
        $(By.cssSelector("input[value='Login']")).click();
        System.out.println("Осуществлен переход на главную страницу");
    }
    public void verifyPageTitle() {
        Assertions.assertEquals("Products", $(".title").getText());
    }
    public void getTotalItemCount() {
        int count = $$(".inventory_item").size();
        System.out.println("Количество товаров на странице: " + count);
    }
}

