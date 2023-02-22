package Pages;

import Infra.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.time.Duration;

public class BuyGiftPage extends BasePage {


    WebDriverWait wait =  new WebDriverWait(DriverSingleton.getInstance(), Duration.ofSeconds(10));
    By giftReceiverBy = By.xpath("//label[@id='friendName']/input");
    String giftReceiverName = "dad";
    By giftSenderBy = By.xpath("//input[@placeholder='שם שולח המתנה']");
    String giftSenderName = "amit";

    // performs the main flow of buying a gift which includes choosing the gift sending method,
    // filling the details of the gift's receiver and sender as well as filling additional information
    // such as the gift's included pics, vids and blessing.
  public void buyGift() throws InterruptedException {

      fillGiftReceiverAndEventInfo();
      fillGiftSendInfo();
      assertFields();
      waitForElem2BeClickableNClick(wait, By.xpath("//button[@type='submit' and @gtm[contains(.,'תשלום')]]"));
    }

    // fills the gift receiver's info as well as the event's info.
    public void fillGiftReceiverAndEventInfo() throws InterruptedException
    {
        waitForElem2BeClickableNClick(wait, By.xpath("//div[@class='buttons']/div[@gtm='למישהו אחר']"));
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
    }

    // fills the gift send info (send method, sender name, etc..)
    public void fillGiftSendInfo() throws InterruptedException
    {
        waitForElem2BePresentNClick(wait, By.xpath("//div[@class='buttons']/div[@gtm='עכשיו']"));
        waitForElem2BeClickableNClick(wait, By.xpath("//div[@class[contains(.,'sending-methods')]][1]"));
        waitForElem2BePresentNSendKeys(wait, By.xpath("//input[@id='email' and @type='email']"), "abc@gmail.com");
        getWebElement(giftSenderBy).clear();
        waitForElem2BePresentNSendKeys(wait, giftSenderBy, giftSenderName);
    }


    // asserts that the actual page's sender and receiver fields' values
    // match the expected values / text (the values that were entered by the program).
    private void assertFields()
    {
        var actualGiftSenderName = getWebElement(giftSenderBy).getAttribute("value");
        Assert.assertEquals(actualGiftSenderName, giftSenderName);
        DriverSingleton.getInstance().navigate().back();
        var actualGiftReceiverName = getWebElement(giftReceiverBy).getAttribute("value");
        Assert.assertEquals(actualGiftReceiverName, giftReceiverName);
        DriverSingleton.getInstance().navigate().forward();
    }
}
