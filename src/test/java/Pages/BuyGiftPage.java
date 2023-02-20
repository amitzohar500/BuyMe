package Pages;

import Infra.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.time.Duration;

public class BuyGiftPage extends BasePage {

    // search for gifts by a search criteria.
  public void buyGift() throws InterruptedException {

      WebDriverWait wait = new WebDriverWait(DriverSingleton.getInstance(), Duration.ofSeconds(5));
      waitForElem2BeClickableNClick(wait, By.xpath("//div[@class='buttons']/div[@gtm='למישהו אחר']"));

      var giftReceiverBy = By.xpath("//label[@id='friendName']/input");
      var giftReceiverName = "dad";
      sendKeysToElement(giftReceiverBy, giftReceiverName);
      waitForElem2BeClickableNClick(wait, By.xpath("//label[@gtm='eventType']/div/div[@class='selected-name']"));
      waitForElem2BeClickableNClick(wait, By.xpath("//li[@value='12']/span"));
      By giftGreetingBy = By.xpath("//textarea[@data-parsley-group='voucher-greeting']");
      getWebElement(giftGreetingBy).clear();
      sendKeysToElement(giftGreetingBy, "congrats on the new born!");
      By uploadPicBtnBy = By.xpath("//label[@class='media-circle-btn ember-view bm-media-upload']/input[@type='file']");
      File giftPicFile = new File("gift.jpg");
      sendKeysToElement(uploadPicBtnBy, giftPicFile.getAbsolutePath());

      waitForElem2BeClickableNClick(wait, By.xpath("//button[@type='submit' and @gtm='המשך']"));
      waitForElem2BePresentNClick(wait, By.xpath("//div[@class='buttons']/div[@gtm='עכשיו']"));

      waitForElem2BeClickableNClick(wait, By.xpath("//div[@class[contains(.,'sending-methods')]][1]"));
      waitForElem2BePresentNSendKeys(wait, By.xpath("//input[@id='email' and @type='email']"), "abc@gmail.com");

      var giftSenderBy = By.xpath("//input[@placeholder='שם שולח המתנה']");
      getWebElement(giftSenderBy).clear();
      var giftSenderName = "amit";
      waitForElem2BePresentNSendKeys(wait, giftSenderBy, giftSenderName);

      var actualGiftSenderName = getWebElement(giftSenderBy).getAttribute("value");
      Assert.assertEquals(actualGiftSenderName, giftSenderName);
      DriverSingleton.getInstance().navigate().back();

      var actualGiftReceiverName = getWebElement(giftReceiverBy).getAttribute("value");
      Assert.assertEquals(actualGiftReceiverName, giftReceiverName);
      DriverSingleton.getInstance().navigate().forward();
      waitForElem2BeClickableNClick(wait, By.xpath("//button[@type='submit' and @gtm[contains(.,'תשלום')]]"));
    }

    // enter the desired gifts' search criteria:
    // close the disturbing pop-up, select the desired gifts' price point, region and category
    private void enterSearchCriteria() throws InterruptedException {

    }


    // assert that the search was indeed on the entered desired gifts' search criteria
    private void assertFields()
    {
    }
}
