package org.example;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FilteredPage {

    private final SelenideElement basketButton = $(byText("Перейти в корзину"));

    @Step("Проверить, что фильтр {filterName} - активен")
    public void checkActiveFilters(String filterName) {
        $x(String.format("//button[.//span[contains(text(), '%s')]]", filterName)).shouldBe(visible);
    }

    @Step("Добавить в корзину товар {productName}")
    public void buyProduct(String productName) {
        $$("[data-meta-name='ProductVerticalSnippet']").find(text(productName)).$("[data-meta-name='Snippet__cart-button']").click();
    }

    @Step("Навести мышь на кнопку")
    public void hoverBasketButton(){
        basketButton.hover();
    }

    @Step("Проверить, что число {expectedValue} появилось на кнопке 'Корзина' после добавления товара в корзину")
    public void checkDigitInBasket(String expectedValue) {
        $x(String.format("//div[@data-meta-name='NotificationCounter' and @data-meta-value='%s']", expectedValue)).shouldBe(visible);
    }

    @Step("Нажать на кнопку 'Перейти в корзину'")
    public void clickGoToBasketButton(){
        basketButton.click();
    }
}

