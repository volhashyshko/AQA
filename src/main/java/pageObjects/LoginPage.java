package pageObjects;

import static com.codeborne.selenide.Selenide.*;
import com.codeborne.selenide.SelenideElement;

public class LoginPage {
    private final SelenideElement userNameField = $("#user-name");
    private final SelenideElement passwordField = $("#password");
    private final SelenideElement loginButton = $("input[value='Login']");
    public LoginPage() {
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
        loginButton.click();
    }
}


