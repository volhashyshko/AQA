package pageObjects;

import com.codeborne.selenide.ElementsCollection;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import com.codeborne.selenide.SelenideElement;

public class CartPage {
    private final SelenideElement productNameFirst = $(By.xpath("//a[@id='item_4_title_link']"));
    private final SelenideElement productNameSecond = $(By.xpath("//a[@id='item_5_title_link']"));
    private final SelenideElement productNameThird = $(By.xpath("//a[@id='item_3_title_link']"));
    private final SelenideElement deleteButton = $(By.xpath("//button[@class='btn btn_secondary btn_small cart_button']"));
    private final SelenideElement backButton = $(By.xpath("//button[@class='btn btn_secondary back btn_medium']"));
    private final ElementsCollection cardItemCount = $$(By.xpath("//div[@class='cart_item_label']"));
    public CartPage() {
    }

    public String getProductNameFirst() {
        return productNameFirst.getText();
    }

    public String getProductNameSecond() {
        return productNameSecond.getText();
    }

    public String getProductNameThird() {
        return productNameThird.getText();
    }
    public int getCardItemCount() {
        return cardItemCount.size();
    }
    public void verifyProductRemoval() {
        int itemCountBeforeRemoval = getCardItemCount();
        deleteProduct();
        int itemCountAfterRemoval = getCardItemCount();
        Assertions.assertEquals(itemCountBeforeRemoval - 1, itemCountAfterRemoval, "Товар не был удален из корзины");
    }
        public void deleteProduct() {
        deleteButton.click();
    }
        public void backToTheHomePage() {
        backButton.click();
    }
}
