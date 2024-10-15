package BDD;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class StepsForLogin {

    @Given("^открыта страница \"([^\"]*)\"$")
    public void  openPage(String url) {
        open(url);
        }
    @Given("^в поле Username введено \"([^\"]*)\"$")
    public void enterUsername(String username)  {
        $("#user-name").setValue(username);
    }
    @Given("^в поле Password введено \"([^\"]*)\"$")
    public void enterPassword( String password) {
        $("#password").setValue(password);
    }
    @Given("^нажата кнопка \"([^\"]*)\"$")
    public void clickLoginButton(String button) {
        if (button.equals("Login")) {
        $("#login-button").click();
        }
    }
    @Then("^осуществлен переход на страницу \"([^\"]*)\"$")
    public void  openProductPage() {
        //open("https://www.saucedemo.com/inventory.html");
        Assertions.assertEquals("Products", $(".title").getText());
        System.out.println("Проверка прошла");
    }
}
