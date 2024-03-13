package tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Driver;

import java.util.List;
import java.util.concurrent.TimeUnit;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestLesson5 {

    private final WebDriver driver = Driver.getChromeDriver();

    @BeforeAll
    public void logIn(){
        System.out.println("Начальная страница открыта");
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.cssSelector("input[value='Login']")).click();
        System.out.println("Корректная страница saucedemo открыта");
        String pageTitle = driver.getTitle();
        Assertions.assertEquals("Swag Labs", pageTitle, "Открыта не Swag Labs или название страницы неверно");
        //--Нет категорий, проверим сколько всего товаров на странице
        List<WebElement> inventoryItems = driver.findElements(By.xpath("//div[@class='inventory_item']"));
        System.out.println("Количество товаров на странице: " + driver.findElements(By.xpath("//div[@class='inventory_item']")).stream().count());
    }

    @BeforeEach
    public void beforeEachTestMethod() {
        System.out.println("Некоторый код выполняется перед каждым методом - тест beforeEach");
    }
    @Test
    @DisplayName("Тест который проверяет сценарий задания Lesson 5")
    public void e2eScenario() throws InterruptedException {

        //--добавление товара 1-самый дешевый
        driver.findElement(By.xpath("//select[@class='product_sort_container']")).click();
        driver.findElement(By.xpath("//option[@value='az']")).click();

        WebElement FirstProduct = driver.findElement(By.xpath("//a[@id='item_2_title_link']"));
        String nameFirstProduct = FirstProduct.findElement(By.xpath("//a[@id='item_2_title_link']")).getText();
        System.out.println("Название первого товара: " + driver.findElement(By.xpath("//a[@id='item_2_title_link']")).getText());

        WebElement buttonAddToCardFirst = driver.findElement(By.xpath("//button[@class='btn btn_primary btn_small btn_inventory '][1]"));
        String buttonAddNameFirst = buttonAddToCardFirst.findElement(By.xpath("//button[@class='btn btn_primary btn_small btn_inventory ']")).getText();
        System.out.println("Проверка возможности добавить товар 1 в корзину");
        System.out.println(buttonAddNameFirst.equals("Add to cart"));

        driver.findElement(By.xpath("//button[@class='btn btn_primary btn_small btn_inventory '][1]")).click();
        System.out.println("Товар 1 добавлен в корзину");
        System.out.println("--------------------------");

        //--добавление товара 2-самый дорогой
        driver.findElement(By.xpath("//select[@class='product_sort_container']")).click();
        driver.findElement(By.xpath("//option[@value='hilo']")).click();

        WebElement SecondProduct = driver.findElement(By.xpath("//a[@id='item_5_title_link']"));
        String nameSecondProduct = SecondProduct.findElement(By.xpath("//a[@id='item_5_title_link']")).getText();
        System.out.println("Название второго товара: " + driver.findElement(By.xpath("//a[@id='item_5_title_link']")).getText());

        WebElement buttonAddToCardSecond = driver.findElement(By.xpath("//button[@class='btn btn_primary btn_small btn_inventory '][1]"));
        String buttonAddNameSecond = buttonAddToCardSecond.findElement(By.xpath("//button[@class='btn btn_primary btn_small btn_inventory ']")).getText();
        System.out.println("Проверка возможности добавить товар 2 в корзину");
        System.out.println(buttonAddNameSecond.equals("Add to cart"));
        driver.findElement(By.xpath("//button[@class='btn btn_primary btn_small btn_inventory '][1]")).click();
        System.out.println("Товар 2 добавлен в корзину");
        System.out.println("--------------------------");

        //--добавление товара 3- первый из обратной сортировки по алфавиту
        driver.findElement(By.xpath("//select[@class='product_sort_container']")).click();
        driver.findElement(By.xpath("//option[@value='za']")).click();

        WebElement ThirdProduct = driver.findElement(By.xpath("//a[@id='item_1_title_link']"));
        String nameThirdProduct = ThirdProduct.findElement(By.xpath("//a[@id='item_1_title_link']")).getText();
        System.out.println("Название третьего товара: " + driver.findElement(By.xpath("//a[@id='item_1_title_link']")).getText());

        WebElement buttonAddToCardThird = driver.findElement(By.xpath("//*[@id='add-to-cart-sauce-labs-bolt-t-shirt']"));
        String buttonAddNameThird = buttonAddToCardThird.findElement(By.xpath("//*[@id='add-to-cart-sauce-labs-bolt-t-shirt']")).getText();
        System.out.println("Проверка возможности добавить товар 3 в корзину");
        System.out.println(buttonAddNameThird.equals("Add to cart"));
        driver.findElement(By.xpath("//*[@id='add-to-cart-sauce-labs-bolt-t-shirt']")).click();
        System.out.println("Товар 3 добавлен в корзину");
        System.out.println("--------------------------");

        //--переход в корзину
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
        System.out.println("Переход в корзину успешен");
        //--проверим сколько всего товаров в корзине
        List<WebElement> inventoryItems = driver.findElements(By.xpath("//div[@class='cart_item_label']"));
        System.out.println("Количество товаров в корзине: " + driver.findElements(By.xpath("//div[@class='cart_item_label']")).stream().count());

        //--проверка, что именно выбранные вещи добавлены в корзину
        WebElement FirstProductToCart = driver.findElement(By.xpath("//a[@id='item_1_title_link']"));
        String nameFirstProductToCart = FirstProductToCart.findElement(By.xpath("//a[@id='item_1_title_link']")).getText();
        System.out.println(FirstProductToCart.equals("Add to cart"));
        WebElement SecondProductToCart = driver.findElement(By.xpath("//a[@id='item_1_title_link']"));
        String nameSecondProductToCart = SecondProductToCart.findElement(By.xpath("//a[@id='item_1_title_link']")).getText();
        System.out.println(SecondProductToCart.equals("Add to cart"));
        WebElement ThirdProductToCart = driver.findElement(By.xpath("//a[@id='item_1_title_link']"));
        String nameThirdProductToCart = ThirdProductToCart.findElement(By.xpath("//a[@id='item_1_title_link']")).getText();
        System.out.println(ThirdProductToCart.equals("Add to cart"));
        System.out.println("Названия товаров совпадают с выбранными в каталоге");



        driver.findElement(By.xpath("//button[@name='checkout']")).click();

        driver.findElement(By.id("first-name")).sendKeys("Ol");
        driver.findElement(By.id("last-name")).sendKeys("Shi");
        driver.findElement(By.id("postal-code")).sendKeys("00123");
        driver.findElement(By.xpath("//input[@name='continue']")).click();

        driver.findElement(By.xpath("//button[@name='finish']")).click();

        WebElement textSuccess = driver.findElement(By.xpath("//h2[@class='complete-header']"));
        String buttonName = textSuccess.findElement(By.xpath("//h2[@class='complete-header']")).getText();
        System.out.println("Проверка успешности заказа товара");
        System.out.println(buttonName.equals("Thank you for your order!"));


        driver.findElement(By.xpath("//button[@name='back-to-products']")).click();
        System.out.println("Осуществлен возврат на главную страницу");

        driver.findElement(By.id("react-burger-menu-btn")).click();

        driver.findElement(By.id("logout_sidebar_link")).click();
        System.out.println("Осуществлен выход из приложения");

        Thread.sleep(1000);
    }
    @AfterAll
    public void quit(){
        driver.quit();
        System.out.println("Браузер закрыт");

    }
}
