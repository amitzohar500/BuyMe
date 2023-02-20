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
    protected void clickElement(By locator) {

        getWebElement(locator).click();
    }

    protected void waitForElem2BeClickableNClick(WebDriverWait wait, By locator) {

        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    protected void clickElemUsingJS(By locator) {

        ((JavascriptExecutor) DriverSingleton.getInstance()).
                executeScript("arguments[0].click();", getWebElement(locator));
            }

    protected void waitForElem2BePresentNClick(WebDriverWait wait, By locator) {

        wait.until(ExpectedConditions.presenceOfElementLocated(locator)).click();
    }

    protected void waitForElem2BePresentNSendKeys(WebDriverWait wait, By locator, String text) {

        wait.until(ExpectedConditions.presenceOfElementLocated(locator)).sendKeys(text);
    }

    protected void sendKeysToElement(By locator, String text) {

        getWebElement(locator).sendKeys(text);
    }

    protected void sendKeysToElements(By locator, String text) {

        getWebElements(locator).stream().forEach(we -> we.sendKeys(text));
    }

     protected WebElement getWebElement(By locator)
    {
        return DriverSingleton.getInstance().findElement(locator);
    }

    protected List<WebElement> getWebElements(By locator)
    {
        return DriverSingleton.getInstance().findElements(locator);
    }

}
