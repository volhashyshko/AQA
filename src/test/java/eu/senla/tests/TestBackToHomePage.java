package eu.senla.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ex.ElementNotFound;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import pageObjects.LoginPage;
import pageObjects.ProductPage;
import pageObjects.CartPage;
import java.io.ByteArrayInputStream;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.*;

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

    private void takeScreenshot(String stepName) {
        step(stepName, () -> {
            String screenshotPath = screenshot(stepName);
            try {
                assert screenshotPath != null;
                URI uri = new URI(screenshotPath);
                Path path = Paths.get(uri);
                Allure.addAttachment(stepName, new ByteArrayInputStream(Files.readAllBytes(path)));
            } catch (Exception e) {
                e.printStackTrace(); // Обработка исключений
            }
        });
    }

    // Обработка ошибок в тестах
    private void handleTestError(String methodName) {
        takeScreenshot("Ошибка в методе " + methodName);
        String text = "Это пример текста для прикрепления к отчету Allure.";
        Allure.addAttachment("Результат", "text/plain", text);
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
        try {
            ProductPage productsPage = new ProductPage();
            productsPage.verifyPageTitle();
            takeScreenshot("Проверка заголовка страницы");
            productsPage.sortByPriceLowest();
            productsPage.getProductNameLowest();
            productsPage.addToCart();
            //takeScreenshot("Добавление самого дешевого товара в корзину");

            productsPage.sortByPriceHighest();
            productsPage.getProductNameHighest();
            productsPage.addToCart();
            //takeScreenshot("Добавление самого дорогого товара в корзину");

            productsPage.sortByPriceFirstInEnd();
            productsPage.getProductNameFirstInEnd();
            productsPage.addToCart();
            //takeScreenshot("Добавление товара с первой позиции в корзину");

        } catch (ElementNotFound | Exception e) {
            handleTestError("addToCart");
            throw e; // Перебрасываем исключение для корректного завершения теста
        }
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
        try {
            ProductPage productsPage = new ProductPage();
            CartPage cartPage = new CartPage();

            productsPage.verifyPageTitle();
            takeScreenshot("Проверка заголовка страницы");
            productsPage.sortByPriceLowest();
            String lowestPricedProductName = productsPage.getProductNameLowest();
            productsPage.addToCart();
            //takeScreenshot("Добавление самого дешевого товара в корзину");

            productsPage.sortByPriceHighest();
            String highestPricedProductName = productsPage.getProductNameHighest();
            productsPage.addToCart();
            //takeScreenshot("Добавление самого дорогого товара в корзину");

            productsPage.sortByPriceFirstInEnd();
            String firstInEndPricedProductName = productsPage.getProductNameFirstInEnd();
            productsPage.addToCart();
            //takeScreenshot("Добавление товара с первой позиции в корзину");

            productsPage.goToCart();
            takeScreenshot("Переход в корзину");

            String firstProductNameInCart = cartPage.getProductNameFirst();
            Assertions.assertEquals(lowestPricedProductName, firstProductNameInCart);
            //takeScreenshot("Проверка первого товара в корзине");

            String secondProductNameInCart = cartPage.getProductNameSecond();
            Assertions.assertEquals(highestPricedProductName, secondProductNameInCart);
            //takeScreenshot("Проверка второго товара в корзине");

            String thirdProductNameInCart = cartPage.getProductNameThird();
            Assertions.assertEquals(firstInEndPricedProductName, thirdProductNameInCart);
            //takeScreenshot("Проверка третьего товара в корзине");

            cartPage.deleteProduct();
            cartPage.verifyProductRemoval();
            //takeScreenshot("Удаление товара из корзины");

            cartPage.backToTheHomePage();
            productsPage.verifyPageTitle();
            takeScreenshot("Возврат на главную страницу");

        } catch (ElementNotFound | Exception e) {
            handleTestError("e2eScenario");
            throw e;
        }
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
        try {
            ProductPage productsPage = new ProductPage();

            productsPage.verifyPageTitle();
            takeScreenshot("Проверка заголовка страницы");
            productsPage.sortByPriceLowest();
            productsPage.getProductNameLowest();
            productsPage.addToCart();
            //takeScreenshot("Добавление самого дешевого товара в корзину");

            productsPage.sortByPriceHighest();
            productsPage.getProductNameHighest();
            productsPage.addToCart();
            //takeScreenshot("Добавление самого дорогого товара в корзину");

            productsPage.sortByPriceFirstInEnd();
            productsPage.getProductNameFirstInEnd();
            productsPage.addToCart();
            //takeScreenshot("Добавление товара с первой позиции в корзину");
            productsPage.goToCart();
            takeScreenshot("Переход в корзину");

        } catch (ElementNotFound | Exception e) {
            handleTestError("goToCart");
            throw e;
        }
    }
}
