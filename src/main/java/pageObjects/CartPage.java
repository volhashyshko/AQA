package pageObjects;

import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CartPage {
    public CartPage() {
    }
    public void getCardItemCount(){
        int itemCount = $$(By.xpath("//div[@class='cart_item_label']")).size();
        System.out.println("Количество товаров в корзине: " + itemCount);
    }
    public String getProductNameFirst() {
        return $(By.xpath("//a[@id='item_4_title_link']")).getText();
    }
    public String getProductNameSecond() {
        return $(By.xpath("//a[@id='item_5_title_link']")).getText();
    }
    public String getProductNameThird() {
        return $(By.xpath("//a[@id='item_3_title_link']")).getText();
    }
    public void deleteProduct(){
        $(By.xpath("//button[@class='btn btn_secondary btn_small cart_button']")).click();
    }
    public void backToTheHomePage(){
        $(By.xpath("//button[@class='btn btn_secondary back btn_medium']")).click();
    }
}
