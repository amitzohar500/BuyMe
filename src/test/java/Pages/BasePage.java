package Pages;

import Infra.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasePage
{
    // finds a web element by a locator and clicks it
    protected void clickElement(By locator) {

        getWebElement(locator).click();
    }

    // waits for a web element (identified by a locator) to be clickable and when so, it clicks it.
    protected void waitForElem2BeClickableNClick(WebDriverWait wait, By locator) {

        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    // finds a web element by a locator and clicks it using javascript code.
    protected void clickElemUsingJS(By locator) {

        ((JavascriptExecutor) DriverSingleton.getInstance()).
                executeScript("arguments[0].click();", getWebElement(locator));
            }

    // waits for a web element (identified by a locator) to be presented on the current web page and
    // when so, it clicks it.
    protected void waitForElem2BePresentNClick(WebDriverWait wait, By locator) {

        wait.until(ExpectedConditions.presenceOfElementLocated(locator)).click();
    }

    // waits for a web element (identified by a locator) to be presented on the current web page and
    // when so, it sends it keys.
    protected void waitForElem2BePresentNSendKeys(WebDriverWait wait, By locator, String text) {

        wait.until(ExpectedConditions.presenceOfElementLocated(locator)).sendKeys(text);
    }

    // finds a web element by a locator and sends it keys.
    protected void sendKeysToElement(By locator, String text) {

        getWebElement(locator).sendKeys(text);
    }

    // finds web elements by a locator and sends them keys.
    protected void sendKeysToElements(By locator, String text) {

        getWebElements(locator).stream().forEach(we -> we.sendKeys(text));
    }

    // finds and returns a web element by a locator
     protected WebElement getWebElement(By locator)
    {
        return DriverSingleton.getInstance().findElement(locator);
    }

    // finds and returns web elements by a locator
    protected List<WebElement> getWebElements(By locator)
    {
        return DriverSingleton.getInstance().findElements(locator);
    }

}
