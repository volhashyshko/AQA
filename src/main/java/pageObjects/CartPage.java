package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    private final WebDriver driver;

    public CartPage(WebDriver driver) {

        this.driver = driver;
    }

    public long getCardItemCount(){
        return driver.findElements(By.xpath("//div[@class='cart_item_label']")).size();
    }

    // Метод для получения названия товаров
    public String getProductNameFirst() {
        return driver.findElement(By.xpath("//a[@id='item_4_title_link']")).getText();
    }

    public String getProductNameSecond() {
        return driver.findElement(By.xpath("//a[@id='item_5_title_link']")).getText();
    }

    public String getProductNameThird() {
        return driver.findElement(By.xpath("//a[@id='item_3_title_link']")).getText();
    }

    public void deleteProduct(){
        driver.findElement(By.xpath("//button[@class='btn btn_secondary btn_small cart_button']")).click();
    }

    public void backToTheHomePage(){
        driver.findElement(By.xpath("//button[@class='btn btn_secondary back btn_medium']")).click();
    }
}
