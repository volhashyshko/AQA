/*
package eu.senla.tests;

import pageObjects.CartPage;
import pageObjects.CloseBrowser;
import pageObjects.LoginPage;
import pageObjects.ProductPage;
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
            CloseBrowser closeBrowser = new CloseBrowser(driver);
            closeBrowser.quit();
        }
        @Test
        @DisplayName("Тест, который проверяет сценарий задания Lesson 6")
        public void e2eScenario() throws InterruptedException {
            ProductPage productsPage = new ProductPage(driver);

            System.out.println("Добавление товаров в корзину");
            productsPage.sortByPriceLowest();
            productsPage.getProductNameLowest();
            System.out.println("Товар 1 добавлен - "+productsPage.getProductNameLowest());
            productsPage.addToCart();

            productsPage.sortByPriceHighest();
            productsPage.getProductNameHighest();
            System.out.println("Товар 2 добавлен - "+productsPage.getProductNameHighest());
            productsPage.addToCart();

            productsPage.sortByPriceFirstInEnd();
            productsPage.getProductNameFirstInEnd();
            System.out.println("Товар 3 добавлен - "+productsPage.getProductNameFirstInEnd());
            productsPage.addToCart();

            productsPage.goToCart();
            System.out.println("Переход в корзину");

            CartPage cartPage = new CartPage(driver);

            long itemCount = cartPage.getCardItemCount();
            System.out.println("Количество товаров на странице: " + itemCount);

            System.out.println("Проверка соответствия товаров в корзине");
            cartPage.getProductNameFirst();
            System.out.println("Название 1 товара - " + cartPage.getProductNameFirst());

            cartPage.getProductNameSecond();
            System.out.println("Название 2 товара - " + cartPage.getProductNameSecond());

            cartPage.getProductNameThird();
            System.out.println("Название 3 товара - " + cartPage.getProductNameThird());

            System.out.println("Один товар удален");
            cartPage.deleteProduct();

            long itemCountAfterDelete = cartPage.getCardItemCount();
            System.out.println("Количество товаров на странице: " + itemCountAfterDelete);

            cartPage.backToTheHomePage();
            System.out.println("Осуществлен возврат на главную страницу");

            Thread.sleep(1000);
        }
}
*/
