package org.example;
import com.codeborne.selenide.Configuration;
import io.qameta.allure.Epic;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Epic("Магазин 'Ситилинк'")
public class CitilinkTest {
    static {
        Configuration.timeout = 30000;
    }
    private final static String URL = "https://www.citilink.ru";

    MainPage mainPage = new MainPage(URL);
    CatalogPage catalogPage = new CatalogPage();
    FilteredPage filteredPage = new FilteredPage();
    BasketPage basketPage = new BasketPage();

    @Test
    @DisplayName("Добавление ноутбука MSI в корзину на сайте 'Ситилинк'")
    public void testCitilinkCatalog(){
        Configuration.clickViaJs = true;
        mainPage.clickCatalogButton();
        mainPage.selectCategory("Ноутбуки, ПК и мониторы", "Ноутбуки");

        catalogPage.checkTitle("Ноутбуки");
        catalogPage.brandFilter("MSI");
        catalogPage.priceFilter("708000", "710000");
        catalogPage.clickapplySelectedButton();

        filteredPage.checkActiveFilters("MSI");
        filteredPage.checkActiveFilters("Цена от 708 000 ₽");
        filteredPage.buyProduct("MSI Titan Dragon Edition");
        filteredPage.checkDigitInBasket("1");
        filteredPage.hoverBasketButton();
        filteredPage.clickGoToBasketButton();

        basketPage.checkTitle("Корзина");
        basketPage.verifyBasket("MSI Titan Dragon Edition", "709 990");
        basketPage.checkButton();

    }
}
