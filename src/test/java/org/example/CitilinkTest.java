package org.example;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

public class CitilinkTest {
    private final static String URL = "https://www.citilink.ru/?ysclid=mrkqvto8lj30904633";

    MainPage mainPage = new MainPage(URL);
    CatalogPage catalogPage = new CatalogPage();
    FilteredPage filteredPage = new FilteredPage();
    BasketPage basketPage = new BasketPage();

    @Test
    public void testCitilinkCatalog(){
        Configuration.clickViaJs = true;
        mainPage.clickCatalogButton();
        mainPage.selectCategory("Ноутбуки, ПК и мониторы", "Ноутбуки");

        catalogPage.checkTitle("Ноутбуки");
        catalogPage.brandFilter("MSI");
        catalogPage.priceFilter("708000", "710000");
        catalogPage.clickapplySelectedButton();

        filteredPage.checkActiveFilters("MSI", "Цена от 708 000 ₽");
        filteredPage.buyProduct("MSI Titan Dragon Edition");
        filteredPage.checkDigitInBasket("1");
        filteredPage.hoverBasketButton();
        filteredPage.clickGoToBasketButton();

        basketPage.checkTitle("Корзина");
        basketPage.verifyBasket("MSI Titan Dragon Edition", "709 990");
        basketPage.checkButton();

    }
}
