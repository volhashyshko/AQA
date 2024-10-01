package eu.senla.tests;

import org.junit.jupiter.api.*;
import pageObjects.LoginPage;
import pageObjects.ProductPage;
import pageObjects.CartPage;
import static com.codeborne.selenide.Selenide.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestLesson7 {
    @BeforeAll
    public void logIn() {
        LoginPage loginPage = new LoginPage();

        loginPage.openLoginPage();
        loginPage.enterCredentials("standard_user", "secret_sauce");
        loginPage.clickLoginButton();
        loginPage.getTotalItemCount();
       }
    @AfterAll
    public void tearDown() {

        closeWebDriver();
    }

    @Test
    @DisplayName("Тест, который проверяет сценарий задания Lesson 6")
    public void e2eScenario() throws InterruptedException {
        ProductPage productsPage = new ProductPage();

        productsPage.verifyPageTitle();
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

        CartPage cartPage = new CartPage();
        cartPage.getCardItemCount();

        System.out.println("Проверка соответствия товаров в корзине");
        cartPage.getProductNameFirst();
        System.out.println("Название 1 товара - " + cartPage.getProductNameFirst());

        cartPage.getProductNameSecond();
        System.out.println("Название 2 товара - " + cartPage.getProductNameSecond());

        cartPage.getProductNameThird();
        System.out.println("Название 3 товара - " + cartPage.getProductNameThird());

        System.out.println("Один товар удален");
        cartPage.deleteProduct();
        cartPage.getCardItemCount();
        cartPage.backToTheHomePage();
        System.out.println("Осуществлен возврат на главную страницу");
        Thread.sleep(1000);
    }
}

