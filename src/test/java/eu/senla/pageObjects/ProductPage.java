package eu.senla.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {

    private final WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    // Метод для выбора сортировки по цене (самый дешевый)
    public void sortByPriceLowest() {
        driver.findElement(By.xpath("//select[@class='product_sort_container']")).click();
        driver.findElement(By.xpath("//option[@value='az']")).click();
    }

    // Метод для выбора сортировки по цене (самый дорогой)
    public void sortByPriceHighest() {
        driver.findElement(By.xpath("//select[@class='product_sort_container']")).click();
        driver.findElement(By.xpath("//option[@value='hilo']")).click();
    }

    // Метод для выбора сортировки по цене (самый дешевый)
    public void sortByPriceFirstInEnd() {
        driver.findElement(By.xpath("//select[@class='product_sort_container']")).click();
        driver.findElement(By.xpath("//option[@value='za']")).click();
    }

    public String getProductNameLowest() {
        return driver.findElement(By.xpath("//a[@id='item_4_title_link']")).getText();

    }

    public String getProductNameHighest() {
        return driver.findElement(By.xpath("//a[@id='item_5_title_link']")).getText();
    }

    public String getProductNameFirstInEnd() {
        return driver.findElement(By.xpath("//a[@id='item_3_title_link']")).getText();
    }
    // Метод для добавления товара в корзину
    public void addToCart() {
        driver.findElement(By.xpath("//button[@class='btn btn_primary btn_small btn_inventory '][1]")).click();
            }

    // Метод для перехода в корзину
    public void goToCart() {
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();

    }
    /*public long getCartItemCount() {
        return  driver.findElements(By.xpath("//div[@class='cart_item_label']")).size();
    }*/

}