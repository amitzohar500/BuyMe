package Pages;

import Infra.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PickBusinessPage extends BasePage {

    // assumes we are in the search results page.
    // picks a business from the list of businesses that were found and in that business's page picks a gift
  public void pickBusiness() throws InterruptedException
  {
      WebDriverWait wait = new WebDriverWait(DriverSingleton.getInstance(), Duration.ofSeconds(10));
      waitForElem2BeClickableNClick(wait, By.xpath("//span[text()[contains(.,'Claro')]]"));
      waitForElem2BeClickableNClick(wait, By.xpath("//ul[@class='grid gifts-list']/li[2]/descendant::button"));
    }

}
