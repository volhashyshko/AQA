package pageObjects;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class ProductPage {
    private final SelenideElement sortDropdown;
    private final SelenideElement titleElement = $(".title");

    public void verifyPageTitle() {
        String actualValue = titleElement.getText();
        Assertions.assertEquals("Products", actualValue);
    }
    public ProductPage() {
        sortDropdown = $(By.xpath("//select[@class='product_sort_container']"));
    }
    public void sortByPriceLowest() {
        sortDropdown.click();
        $(By.xpath("//option[@value='az']")).click();
    }
    public void sortByPriceHighest() {
        sortDropdown.click();
        $(By.xpath("//option[@value='hilo']")).click();
    }
    public void sortByPriceFirstInEnd() {
        sortDropdown.click();
        $(By.xpath("//option[@value='za']")).click();
    }
    public String getProductNameLowest() {
        return $(By.xpath("//a[@id='item_4_title_link']")).getText();
    }
    public String getProductNameHighest() {
        return $(By.xpath("//a[@id='item_5_title_link']")).getText();
    }
    public String getProductNameFirstInEnd() {

        return $(By.xpath("//a[@id='item_3_title_link']")).getText();
    }
    public void addToCart() {

        $(By.xpath("//button[@class='btn btn_primary btn_small btn_inventory '][1]")).click();
    }
    public void goToCart() {

        $(By.xpath("//a[@class='shopping_cart_link']")).click();
    }
}