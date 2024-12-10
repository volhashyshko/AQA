package eu.senla.tests;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import pageObjects.LoginPage;
import pageObjects.ProductPage;
import pageObjects.CartPage;
import static com.codeborne.selenide.Selenide.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestBackToHomePage {
    @BeforeAll
    public void logIn() {
        Configuration.browser = "chrome";
        Configuration.headless = false;
        Configuration.browserSize = "1920x1080";
        LoginPage loginPage = new LoginPage();
        loginPage.openLoginPage();
    }
    @AfterAll
    public void tearDown() {
        closeWebDriver();
    }
    @Severity(SeverityLevel.BLOCKER)
    @Description("Добавление товара в корзину")
    @Feature("E2E сценарий")
    @Issue("789")
    @Link("https://example3")
    @Test
    @Order(1)
    @DisplayName("Проверка возможности добавления товара в корзину")
    public void addToCart() {
        ProductPage productsPage = new ProductPage();

        productsPage.verifyPageTitle();
        productsPage.sortByPriceLowest();
        productsPage.getProductNameLowest();
        productsPage.addToCart();

        productsPage.sortByPriceHighest();
        productsPage.getProductNameHighest();
        productsPage.getProductNameHighest();
        productsPage.addToCart();

        productsPage.sortByPriceFirstInEnd();
        productsPage.getProductNameFirstInEnd();
        productsPage.getProductNameFirstInEnd();
        productsPage.addToCart();

    }
    @Severity(SeverityLevel.CRITICAL)
    @Description("e2e критикал")
    @Feature("E2E сценарий")
    @Issue("456")
    @Link("https://example2")
    @Test
    @Order(3)
    @DisplayName("Проверка возможности возврата на главную страницу из корзины без оформления заказа")
    public void e2eScenario() {
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

    @Flaky
    @Severity(SeverityLevel.BLOCKER)
    @Description("Плавающий баг")
    @Feature("E2E сценарий")
    @Issue("123")
    @Link("https://example")
    @Test
    @Order(2)
    @DisplayName("Проверка возможности перехода в корзину")
    public void goToCart() {
        ProductPage productsPage = new ProductPage();

        productsPage.verifyPageTitle();
        productsPage.sortByPriceLowest();
        productsPage.getProductNameLowest();
        productsPage.addToCart();

        productsPage.sortByPriceHighest();
        productsPage.getProductNameHighest();
        productsPage.getProductNameHighest();
        productsPage.addToCart();

        productsPage.sortByPriceFirstInEnd();
        productsPage.getProductNameFirstInEnd();
        productsPage.getProductNameFirstInEnd();
        productsPage.addToCart();
        productsPage.goToCart();
    }
}

