package org.example;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

public class CitilinkTest {
    MainPage mainPage = new MainPage();
    SecondPage secondPage = new SecondPage();
    FilteredPage filteredPage = new FilteredPage();
    BasketPage basketPage = new BasketPage();

    @Test
    public void testCitilinkCatalog(){
        Configuration.clickViaJs = true;
        mainPage.openMainPage();
        mainPage.clickCatalogButton();
        mainPage.selectCategory("Ноутбуки, ПК и мониторы", "Ноутбуки");

        secondPage.checkTitle("Ноутбуки");
        secondPage.brandFilter("MSI");
        secondPage.priceFilter("708000", "710000");
        secondPage.clickapplySelectedButton();

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
