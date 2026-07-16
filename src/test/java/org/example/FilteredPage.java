package org.example;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FilteredPage {

    private final SelenideElement basketButton = $(byText("Перейти в корзину"));

    public void checkActiveFilters(String firstFilterName, String secondFilterName) {
        $x(String.format("//button[.//span[contains(text(), '%s')]]", firstFilterName)).shouldBe(visible);
        $x(String.format("//button[.//span[contains(text(), '%s')]]", secondFilterName)).shouldBe(visible);
    }

    public void buyProduct(String productName) {
        $$("[data-meta-name='ProductVerticalSnippet']").find(text(productName)).$("[data-meta-name='Snippet__cart-button']").click();
    }

    public void hoverBasketButton(){
        basketButton.hover();
    }

    public void checkDigitInBasket(String expectedValue) {
        $x(String.format("//div[@data-meta-name='NotificationCounter' and @data-meta-value='%s']", expectedValue)).shouldBe(visible);
    }

    public void clickGoToBasketButton(){
        basketButton.click();
    }
}

