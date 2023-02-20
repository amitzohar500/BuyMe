package Pages;

import Infra.DriverSingleton;
import org.openqa.selenium.By;
import org.testng.Assert;

public class RegisterPage extends BasePage {

      private static final String newUserFirstName = "amit";
      private static final String newUserEmail = "amitzohar1979@gmail.com";
      private static final String newUserPassword = "12345";

    // performs registration of a new user to the buyme site.
        public void register() throws InterruptedException {
        DriverSingleton.getInstance().get("https://buyme.co.il/?modal=login");
        clickElement(By.xpath("//span[@class='text-link theme']"));

        enterCredentials();
        assertFields();
        pressRegister();
    }

    // enters the credentials of the new user.
    private void enterCredentials() throws InterruptedException {
        sendKeysToElement(By.cssSelector("input[type=text]"), newUserFirstName);
        sendKeysToElement(By.xpath("//input[@type='email']"), newUserEmail);
        sendKeysToElements(By.xpath("//input[@type='password']"), newUserPassword);
        clickElement(By.xpath("//span[@class='circle']"));
    }

    // click the registration button.
    private void pressRegister()
    {
        clickElement(By.xpath("//button[@type='submit']"));
    }

    private void assertFields()
    {
        Assert.assertEquals(getWebElement(By.cssSelector("input[type=text]")).getAttribute("value"), newUserFirstName);
        Assert.assertEquals(getWebElement(By.xpath("//input[@type='email']")).getAttribute("value"), newUserEmail);
        var passwordElems = getWebElements(By.xpath("//input[@type='password']"));
        Assert.assertEquals(passwordElems.get(0).getAttribute("value"), newUserPassword);
        Assert.assertEquals(passwordElems.get(1).getAttribute("value"), newUserPassword);
    }
}
