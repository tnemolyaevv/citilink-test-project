package org.example;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class BasketPage extends SecondPage{

    private final SelenideElement product = $x("//div[@data-meta-type='Product']");
    private final SelenideElement registrationButton = $(byText("Перейти к оформлению"));

    @Override
    public void checkTitle(String expectedText){
        $(".BasketLayout_Header__Tqz6Y").shouldHave(text(expectedText));
    }

    public void verifyBasket(String productName, String productPrice){
        product.$x(".//span[contains(@class, 'ProductTitle_Name')]").shouldHave(text(productName));
        product.$("[data-meta-name='AvailableProductStatus__price']").shouldHave(partialText(productPrice));
    }

    public void checkButton(){
        registrationButton.shouldBe(enabled);
    }
}
