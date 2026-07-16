package org.example;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    private final SelenideElement catalogBtn = $(byText("Каталог товаров"));
    private final SelenideElement popup = $x("//div[@data-meta-name='Popup']");

    public void openMainPage(){
        open("https://www.citilink.ru/?ysclid=mrkqvto8lj30904633");
    }
    public void clickCatalogButton(){
        catalogBtn.click();
    }
    public void selectCategory(String category, String subCategory){
        popup.$x(String.format(".//span[text()='%s']", category)).hover();
        popup.$x(String.format(".//span[text()='%s']", subCategory)).click();
    }
}
