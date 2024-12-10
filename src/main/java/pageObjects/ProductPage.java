package pageObjects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class ProductPage {
    private final SelenideElement sortDropdown = $(By.xpath("//select[@class='product_sort_container']"));
    private final SelenideElement sortAz = $(By.xpath("//option[@value='az']"));
    private final SelenideElement sortHilo = $(By.xpath("//option[@value='hilo']"));
    private final SelenideElement sortZa = $(By.xpath("//option[@value='za']"));
    private final SelenideElement titleElement = $(".title");
    private final SelenideElement productNameLowest = $(By.xpath("//a[@id='item_4_title_link']"));
    private final SelenideElement productNameHighest = $(By.xpath("//a[@id='item_5_title_link']"));
    private final SelenideElement productNameFirstInEnd = $(By.xpath("//a[@id='item_3_title_link']"));
    private final SelenideElement addToCartButton = $(By.xpath("//button[@class='btn btn_primary btn_small btn_inventory '][1]"));
    private final SelenideElement cartLink = $(By.xpath("//a[@class='shopping_cart_link']"));
    public ProductPage() {
    }
    @Step("Verify Page Title")
    public void verifyPageTitle() {
        String actualValue = titleElement.getText();
        Assertions.assertEquals("Products", actualValue);
    }
    @Step("Sort By Price Lowest")
    public void sortByPriceLowest() {
        sortDropdown.click();
        sortAz.click();
    }
    @Step("Sort By Price Highest")
    public void sortByPriceHighest() {
        sortDropdown.click();
        sortHilo.click();
    }
    @Step("Sort By Price FirstInEnd")
    public void sortByPriceFirstInEnd() {
        sortDropdown.click();
        sortZa.click();
    }
    public String getProductNameLowest() {
        return productNameLowest.getText();
    }
    public String getProductNameHighest() {
        return productNameHighest.getText();
    }
    public String getProductNameFirstInEnd() {
        return productNameFirstInEnd.getText();
    }
    @Step("Add To Cart")
    public void addToCart() {
        addToCartButton.click();
    }
    @Step("Go To Cart")
    public void goToCart() {
        cartLink.click();
    }
}