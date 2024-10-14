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
    }
    @AfterAll
    public void tearDown() {
        closeWebDriver();
    }
    @Test
    @DisplayName("Проверка возможности возврата на главную страницу из корзины без оформления заказа")
    public void e2eScenario() throws InterruptedException {
        ProductPage productsPage = new ProductPage();
        CartPage cartPage = new CartPage();

        productsPage.verifyPageTitle();
        productsPage.sortByPriceLowest();
        productsPage.getProductNameLowest();
        productsPage.addToCart();
        //System.out.println("Товар 1 добавлен - "+productsPage.getProductNameLowest());

        productsPage.sortByPriceHighest();
        productsPage.getProductNameHighest();
        productsPage.addToCart();
        //System.out.println("Товар 2 добавлен - "+productsPage.getProductNameHighest());

        productsPage.sortByPriceFirstInEnd();
        productsPage.getProductNameFirstInEnd();
        productsPage.addToCart();
        //System.out.println("Товар 3 добавлен - "+productsPage.getProductNameFirstInEnd());

        productsPage.goToCart();
        //System.out.println("Переход в корзину");

        cartPage.getCardItemCount();

        //System.out.println("Проверка соответствия товаров в корзине");
        String firstProductName =  cartPage.getProductNameFirst();
        //System.out.println("Название 1 товара - " + firstProductName);

        String secondProductName = cartPage.getProductNameSecond();
        //System.out.println("Название 2 товара - " + secondProductName);

        String thirdProductName = cartPage.getProductNameThird();
        //System.out.println("Название 3 товара - " + thirdProductName);

        //.out.println("Один товар удален");
        cartPage.deleteProduct();
        cartPage.getCardItemCount();
        cartPage.backToTheHomePage();
        productsPage.verifyPageTitle();
        System.out.println("Осуществлен возврат на главную страницу");// нет проверки в тесте

        Thread.sleep(1000);
    }
}

