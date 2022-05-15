package base;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;


public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;

    public BasePage(WebDriver driver, long timeOutInSeconds) {
        this.driver = driver;
        wait = new WebDriverWait(driver, timeOutInSeconds);
        actions = new Actions(driver);
    }

    public void clickElement(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void sendText(WebElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(text);
    }

    public boolean elementInvisible(WebElement element) {
        return wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public String getTextField(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element)).getText();
    }

    public boolean isWebElementDisplayed(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
    }

    public void openLinkInSecondTab(WebElement element) {
        actions.keyDown(element, Keys.CONTROL).click().build().perform();
    }

    public void switchToNewOpenedWindow() {
        String parentWindow = driver.getWindowHandle();
        Set<String> windows = driver.getWindowHandles();
        for (String window : windows) {
            if (!window.equals(parentWindow)) {
                driver.switchTo().window(window);
            }
        }
    }

    public void scrollIntoView(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
