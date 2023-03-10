package Tests;

import Infra.DriverSingleton;
import Pages.BuyGiftPage;
import Pages.PickBusinessPage;
import Pages.SearchGiftsPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class Tester {

    // a function that tests the flow of buying a gift card on the site buyme.co.il.
    @Test
    public void BuyMe() throws InterruptedException{

        // uncomment to test registration or/and login
//        var registerPage = new RegisterPage();
//        registerPage.register();
//        var loginPage = new LoginPage();
//        loginPage.login();

        DriverSingleton.getInstance().get("https://buyme.co.il");
        var searchGiftPage = new SearchGiftsPage();
        searchGiftPage.searchGifts();
        var pickBusinessPage = new PickBusinessPage();
        pickBusinessPage.pickBusiness();
        var buyGiftPage = new BuyGiftPage();
        buyGiftPage.buyGift();
    }

    // closes the google chrome web browser after tests are done.
    @AfterClass public void afterClass() throws Exception
    {
        Thread.sleep(3000);
        DriverSingleton.getInstance().quit();
    }
}

