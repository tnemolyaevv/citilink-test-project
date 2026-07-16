package org.example;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CatalogPage {
    private final SelenideElement header = $("h1");
    private final SelenideElement filterDropDown = $x("//div[@data-meta-name='FilterDropdown' and @data-meta-value='Бренд']");
    private final SelenideElement applySelectedButton = $(byText("Применить выбранное"));
    private final SelenideElement minPriceField = $x("//input[@data-meta-name='FilterRangeGroup__input-min']");
    private final SelenideElement maxPriceField = $x("//input[@data-meta-name='FilterRangeGroup__input-max']");

    public void checkTitle(String expectedText){
        header.shouldHave(text(expectedText));
    }

    public void brandFilter(String brandName){
        filterDropDown.$x(String.format(".//span[text()='%s']", brandName)).click();
    }

    public void priceFilter(String minPrice, String maxPrice){
       minPriceField.setValue(minPrice);
       maxPriceField.clear();
       maxPriceField.setValue(maxPrice);
    }

    public void clickapplySelectedButton(){
        applySelectedButton.click();;
    }
}
