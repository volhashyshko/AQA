package pageObjects;

import static com.codeborne.selenide.Selenide.*;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;

public class LoginPage {
    private final SelenideElement userNameField = $("#user-name");
    private final SelenideElement passwordField = $("#password");
    public LoginPage() {
        Configuration.browser = "chrome";
        Configuration.headless = false;
        Configuration.browserSize = "1920x1080";
    }
    public void openLoginPage() {
        open("https://www.saucedemo.com/");
        enterCredentials("standard_user", "secret_sauce");
        clickLoginButton();
    }
    public void enterCredentials(String username, String password) {
        userNameField.setValue(username);
        passwordField.setValue(password);
    }
    public void clickLoginButton() {
        $("input[value='Login']").click();
    }
}


