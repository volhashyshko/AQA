package pageObjects;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class ProductPage {

    public void verifyPageTitle() {
        Assertions.assertEquals("Products", $(".title").getText());
    }
    public ProductPage() {
    }
    public void sortByPriceLowest() {
        $(By.xpath("//select[@class='product_sort_container']")).click();
        $(By.xpath("//option[@value='az']")).click();
    }
    public void sortByPriceHighest() {
        $(By.xpath("//select[@class='product_sort_container']")).click();
        $(By.xpath("//option[@value='hilo']")).click();
    }
    public void sortByPriceFirstInEnd() {
        $(By.xpath("//select[@class='product_sort_container']")).click();
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