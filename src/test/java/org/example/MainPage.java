package org.example;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    public MainPage(String url){
        Selenide.open(url);
    }
    private final SelenideElement catalogBtn = $(byText("Каталог товаров"));
    private final SelenideElement popup = $x("//div[@data-meta-name='Popup']");

    public void clickCatalogButton(){
        catalogBtn.click();
    }
    public void selectCategory(String category, String subCategory){
        popup.$x(String.format(".//span[text()='%s']", category)).hover();
        popup.$x(String.format(".//span[text()='%s']", subCategory)).click();
    }
}
