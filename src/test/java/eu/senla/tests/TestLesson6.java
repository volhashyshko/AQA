package eu.senla.tests;

import eu.senla.pageObjects.CartPage;
import eu.senla.pageObjects.LoginPage;
import eu.senla.pageObjects.ProductPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import utils.Driver;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestLesson6 {

    private final WebDriver driver = Driver.getChromeDriver();

    @BeforeAll
    public void logIn() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.openLoginPage();
        loginPage.enterCredentials("standard_user", "secret_sauce");
        loginPage.clickLoginButton();
        loginPage.verifyPageTitle();

        long itemCount = loginPage.getTotalItemCount();
        System.out.println("Количество товаров на странице: " + itemCount);
        }

        @AfterAll
        public void quit() {
            driver.close();
            driver.quit();
            System.out.println("Браузер закрыт");
        }
        @Test
        @DisplayName("Тест, который проверяет сценарий задания Lesson 6")
        public void e2eScenario() throws InterruptedException {
            ProductPage productsPage = new ProductPage(driver);

            System.out.println("Добавление товаров в корзину");

            productsPage.sortByPriceLowest();
            productsPage.getProductNameLowest();
            productsPage.addToCart();
            System.out.println("Товар 1 добавлен");

            productsPage.sortByPriceHighest();
            productsPage.getProductNameHighest();
            productsPage.addToCart();
            System.out.println("Товар 2 добавлен");

            productsPage.sortByPriceFirstInEnd();
            productsPage.getProductNameFirstInEnd();
            productsPage.addToCart();
            System.out.println("Товар 3 добавлен");

            productsPage.goToCart();
            System.out.println("Переход в корзину");

            CartPage cartPage = new CartPage(driver);

            long itemCount = cartPage.getCardItemCount();
            System.out.println("Количество товаров на странице: " + itemCount);

            System.out.println("Проверка соответствия товаров в корзине");

            cartPage.getProductNameFirst();
            System.out.println("Название первого товара: " + cartPage.getProductNameFirst());

            cartPage.getProductNameSecond();
            System.out.println("Название второго товара: " + cartPage.getProductNameSecond());

            cartPage.getProductNameThird();
            System.out.println("Название третьего товара: " + cartPage.getProductNameThird());

            System.out.println("Один товар удален");
            cartPage.deleteProduct();

            long itemCountAfretDelete = cartPage.getCardItemCount();
            System.out.println("Количество товаров на странице: " + itemCountAfretDelete);

            cartPage.backToTheHomePage();
            System.out.println("Осуществлен возврат на главную страницу");

            Thread.sleep(1000);
        }
}

