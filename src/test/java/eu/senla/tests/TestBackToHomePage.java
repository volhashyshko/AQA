package eu.senla.tests;

import org.junit.jupiter.api.*;
import pageObjects.LoginPage;
import pageObjects.ProductPage;
import pageObjects.CartPage;
import static com.codeborne.selenide.Selenide.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestBackToHomePage {
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
        String lowestPricedProductName = productsPage.getProductNameLowest();
        productsPage.addToCart();

        productsPage.sortByPriceHighest();
        productsPage.getProductNameHighest();
        String highestPricedProductName = productsPage.getProductNameHighest();
        productsPage.addToCart();

        productsPage.sortByPriceFirstInEnd();
        productsPage.getProductNameFirstInEnd();
        String firstInEndPricedProductName = productsPage.getProductNameFirstInEnd();
        productsPage.addToCart();

        productsPage.goToCart();

        String firstProductNameInCart = cartPage.getProductNameFirst();
        Assertions.assertEquals(lowestPricedProductName, firstProductNameInCart);

        String secondProductNameInCart = cartPage.getProductNameSecond();
        Assertions.assertEquals(highestPricedProductName, secondProductNameInCart);

        String thirdProductNameInCart = cartPage.getProductNameThird();
        Assertions.assertEquals(firstInEndPricedProductName, thirdProductNameInCart);

        cartPage.deleteProduct();
        cartPage.verifyProductRemoval();

        cartPage.backToTheHomePage();
        productsPage.verifyPageTitle();
    }
}

