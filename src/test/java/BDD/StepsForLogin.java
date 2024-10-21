package BDD;

import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.*;

public class StepsForLogin {
    private final SelenideElement backButton = $(By.xpath("//button[@class='btn btn_secondary back btn_medium']"));
    private final SelenideElement userNameField = $("#user-name");
    private final SelenideElement passwordField = $("#password");
    private final SelenideElement loginButton = $("input[value='Login']");
    @Given("^открыта страница \"([^\"]*)\"$")
    public void  openPage(String url) {
        open(url);
        }
    @Given("^в поле Username введено \"([^\"]*)\"$")
    public void enterUsername(String username)  {
        userNameField.setValue(username);
    }
    @Given("^в поле Password введено \"([^\"]*)\"$")
    public void enterPassword( String password) {
        passwordField.setValue(password);
    }
    @Given("^нажата кнопка \"([^\"]*)\"$")
    public void clickLoginButton(String button) {
        if (button.equals("Login")) {
            loginButton.click();
        }
    }
    @Then("^осуществлен переход на страницу \"([^\"]*)\"$")
    public void  openProductPage(String url) {
        String currentUrl = webdriver().driver().url();
        Assertions.assertEquals("Products", $(".title").getText());
        Assertions.assertEquals(url, currentUrl, "Неправильный переход на страницу");
    }
}
