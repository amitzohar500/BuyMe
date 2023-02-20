
package Pages;

import Infra.DriverSingleton;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {

      private static final String email = "amitzohar1979@gmail.com";
      private static final String password = "m1Jwcrph4FbM5056$";
        public void login() throws InterruptedException {
            DriverSingleton.getInstance().get("https://buyme.co.il/?modal=login");
            sendKeysToElement(By.xpath("//input[@type='email']"), email);
            sendKeysToElements(By.xpath("//input[@type='password']"), password);
            clickElement(By.xpath("//button[@type='submit']"));
        }


}
