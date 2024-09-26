/*
package eu.senla.tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Driver;

import java.time.Duration;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestLesson5 {

    private final WebDriver driver = Driver.getChromeDriver();

    @BeforeAll
    public void logIn(){
        System.out.println("Начальная страница открыта");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(4));
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.cssSelector("input[value='Login']")).click();
        System.out.println("Осуществлен переход на главную страницу");
        String pageTitle = driver.getTitle();
        Assertions.assertEquals("Swag Labs", pageTitle, "Открыта не Swag Labs или название страницы неверно");

        //--Нет категорий, проверим сколько всего товаров на странице
        System.out.println("Количество товаров на странице: " + (long) driver.findElements(By.xpath("//div[@class='inventory_item']")).size());
    }
    @AfterAll//--- пишется сразу после BeforeAll
    public void quit(){
        driver.quit();
        System.out.println("Браузер закрыт");
    }

    @Test
    @DisplayName("Тест, который проверяет сценарий задания Lesson 5")
    public void e2eScenario() throws InterruptedException {

        //--добавление товара 1-самый дешевый
        driver.findElement(By.xpath("//select[@class='product_sort_container']")).click();
        driver.findElement(By.xpath("//option[@value='az']")).click();

        System.out.println("Название первого товара: " + driver.findElement(By.xpath("//a[@id='item_4_title_link']")).getText());

        WebElement buttonAddToCardFirst = driver.findElement(By.xpath("//button[@class='btn btn_primary btn_small btn_inventory ']"));
        String buttonAddNameFirst = buttonAddToCardFirst.findElement(By.xpath("//button[@class='btn btn_primary btn_small btn_inventory ']")).getText();
        System.out.println("Проверка возможности добавить товар 1 в корзину");
        System.out.println(buttonAddNameFirst.equals("Add to cart"));

        driver.findElement(By.xpath("//button[@class='btn btn_primary btn_small btn_inventory '][1]")).click();
        System.out.println("Товар 1 добавлен в корзину");
        System.out.println("--------------------------");

        //--добавление товара 2-самый дорогой
        driver.findElement(By.xpath("//select[@class='product_sort_container']")).click();
        driver.findElement(By.xpath("//option[@value='hilo']")).click();

        System.out.println("Название второго товара: " + driver.findElement(By.xpath("//a[@id='item_5_title_link']")).getText());

        WebElement buttonAddToCardSecond = driver.findElement(By.xpath("//button[@class='btn btn_primary btn_small btn_inventory ']"));
        String buttonAddNameSecond = buttonAddToCardSecond.findElement(By.xpath("//button[@class='btn btn_primary btn_small btn_inventory ']")).getText();
        System.out.println("Проверка возможности добавить товар 2 в корзину");
        System.out.println(buttonAddNameSecond.equals("Add to cart"));
        driver.findElement(By.xpath("//button[@class='btn btn_primary btn_small btn_inventory '][1]")).click();
        System.out.println("Товар 2 добавлен в корзину");
        System.out.println("--------------------------");

        //--добавление товара 3- первый из обратной сортировки по алфавиту
        driver.findElement(By.xpath("//select[@class='product_sort_container']")).click();
        driver.findElement(By.xpath("//option[@value='za']")).click();

        System.out.println("Название третьего товара: " + driver.findElement(By.xpath("//a[@id='item_3_title_link']")).getText());

        WebElement buttonAddToCardThird = driver.findElement(By.xpath("//button[@class='btn btn_primary btn_small btn_inventory ']"));
        String buttonAddNameThird = buttonAddToCardThird.findElement(By.xpath("//button[@class='btn btn_primary btn_small btn_inventory ']")).getText();
        System.out.println("Проверка возможности добавить товар 3 в корзину");
        System.out.println(buttonAddNameThird.equals("Add to cart"));
        driver.findElement(By.xpath("//button[@class='btn btn_primary btn_small btn_inventory ']")).click();
        System.out.println("Товар 3 добавлен в корзину");
        System.out.println("--------------------------");

        //--переход в корзину
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
        System.out.println("Переход в корзину успешен");

        //--проверим сколько всего товаров в корзине
        System.out.println("Количество товаров в корзине: " + (long) driver.findElements(By.xpath("//div[@class='cart_item_label']")).size());

        //--проверка, что именно выбранные вещи добавлены в корзину
        System.out.println("Проверка соответствия товаров в корзине");
        WebElement FirstProductToCart = driver.findElement(By.xpath("//a[@id='item_4_title_link']"));
        String nameFirstProductToCart = FirstProductToCart.findElement(By.xpath("//a[@id='item_4_title_link']")).getText();
        System.out.println(nameFirstProductToCart.equals("Sauce Labs Backpack"));
        Assertions.assertEquals("Sauce Labs Backpack", nameFirstProductToCart, "Товар в корзине не найден");

        WebElement SecondProductToCart = driver.findElement(By.xpath("//a[@id='item_5_title_link']"));
        String nameSecondProductToCart = SecondProductToCart.findElement(By.xpath("//a[@id='item_5_title_link']")).getText();
        System.out.println(nameSecondProductToCart.equals("Sauce Labs Fleece Jacket"));
        Assertions.assertEquals("Sauce Labs Fleece Jacket", nameSecondProductToCart, "Товар в корзине не найден");

        WebElement ThirdProductToCart = driver.findElement(By.xpath("//a[@id='item_3_title_link']"));
        String nameThirdProductToCart = ThirdProductToCart.findElement(By.xpath("//a[@id='item_3_title_link']")).getText();
        System.out.println(nameThirdProductToCart.equals("Test.allTheThings() T-Shirt (Red)"));
        Assertions.assertEquals("Test.allTheThings() T-Shirt (Red)", nameThirdProductToCart, "Товар в корзине не найден");

        //--удаление товара из корзины
        driver.findElement(By.xpath("//a[@id='item_4_title_link']")).getText();
        System.out.println("Название удаляемого товара: " + driver.findElement(By.xpath("//a[@id='item_4_title_link']")).getText());

        driver.findElement(By.xpath("//button[@class='btn btn_secondary btn_small cart_button']")).click();

        System.out.println("Один товар удален");
        System.out.println("Количество товаров в корзине: " + (long) driver.findElements(By.xpath("//div[@class='cart_item_label']")).size());

        driver.findElement(By.xpath("//button[@class='btn btn_secondary back btn_medium']")).click();
        System.out.println("Осуществлен возврат на главную страницу");

        System.out.println("Количество доступных к заказу товаров: " + (long) driver.findElements(By.xpath("//button[@class='btn btn_primary btn_small btn_inventory ']")).size());

        Thread.sleep(1000);
    }

}
*/
