package org.example;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class BasketPage extends CatalogPage {

    private final SelenideElement product = $x("//div[@data-meta-type='Product']");
    private final SelenideElement registrationButton = $(byText("Перейти к оформлению"));
    private final SelenideElement title = $(".BasketLayout_Header__Tqz6Y");

    @Step("Проверить, что заголовок страницы содержит {expectedText}")
    @Override
    public void checkTitle(String expectedText){
        title.shouldHave(text(expectedText));
    }

    @Step("Проверить, что в корзине верно отображается товар {productName} с соответствующей ценой {productPrice}")
    public void verifyBasket(String productName, String productPrice){
        product.$x(".//span[contains(@class, 'ProductTitle_Name')]").shouldHave(text(productName));
        product.$("[data-meta-name='AvailableProductStatus__price']").shouldHave(partialText(productPrice));
    }

    @Step("Проверить, что кнопка 'Перейти к оформлению' - доступна для нажатия")
    public void checkButton(){
        registrationButton.shouldBe(enabled);
    }
}
