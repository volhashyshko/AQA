package BDD;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
//import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class StepsForLogin {

    @Given("^открыта страница \"([^\"]*)\"$")
    public void  openPage(String url) {
        open("https://www.saucedemo.com/");
        System.out.println("Начальная страница открыта" + " " + url);
        }
    @Given("^выполнено заполнение поля Username \"([^\"]*)\"$")
    public void enterUsername(String username)  {
        $("#user-name").setValue(username);
        System.out.println("Введено имя пользователя: " + username);

    }
    @Given("^выполнено заполнение поля Password \"([^\"]*)\"$")
    public void enterPassword( String password) {
        $("#password").setValue(password);
        System.out.println("Введен пароль: " + password);

    }
    @When("^нажата кнопка \"([^\"]*)\"$")
    public void clickLoginButton() {
        $(By.className("input[value='Login']")).click();
        System.out.println("Осуществлен переход на главную страницу");
    }

    @Then("^осуществлен переход на страницу \"([^\"]*)\"$")
    public void  openProductPage() {
        open("https://www.saucedemo.com/inventory.html");
        Assertions.assertEquals("Products", $(".title").getText());
    }

}
