package Pages;

import Infra.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class SearchGiftsPage extends BasePage {


    private static final String searchBudgetId="1";
    private static final String searchRegionId="11";
    private static final String searchCategoryId="438";
    WebDriverWait wait;

    // search for gifts by a search criteria.
  public void searchGifts() throws InterruptedException {
       wait = new WebDriverWait(DriverSingleton.getInstance(), Duration.ofSeconds(10));
        enterSearchCriteria();
        pressSearchButton();
        assertFields();
    }

    // enter the desired gifts' search criteria (price point, region and category).
    private void enterSearchCriteria() throws InterruptedException {

        clickElemUsingJS(By.xpath("//span[@title='סכום']"));
        waitForElem2BeClickableNClick(wait, By.xpath("//li[@value='" + searchBudgetId + "']/span"));
        clickElemUsingJS(By.xpath("//span[@title='אזור']"));
        waitForElem2BeClickableNClick(wait, By.xpath("//li[@value='" + searchRegionId +"']/span"));
        clickElemUsingJS(By.xpath("//span[@title='קטגוריה']"));
        waitForElem2BeClickableNClick(wait, By.xpath("//li[@value='" + searchCategoryId + "']/span"));
    }

    // press on the gift search button.
    private void pressSearchButton()
    {
        clickElemUsingJS(By.xpath("//a[contains(@href, 'search')]"));
    }

    // assert that the actual search was made using the entered desired gifts' search criteria.
    private void assertFields()
    {
        String expectedSearchURL = "https://buyme.co.il/search?budget=" +
                searchBudgetId + "&category=" +searchCategoryId + "&region=" + searchRegionId;
        Assert.assertEquals(DriverSingleton.getInstance().getCurrentUrl(),expectedSearchURL);
    }
}
