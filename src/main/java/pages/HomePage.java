package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver, 5);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[contains(text(),'Sign in')]")
    private WebElement signInButton;
    @FindBy(xpath = "//*[contains(text(),'New Article')]")
    private WebElement newArticleButton;
    @FindBy(xpath = "//*[contains(text(),'Your Feed')]")
    private WebElement yourFeedTab;
    @FindBy(xpath = "//*[@class='article-preview']/a")
    private List<WebElement> yourArticles;


    public SignInPage clickSignInButton() {
        clickElement(signInButton);
        return new SignInPage(driver);
    }

    public CreateNewArticlePage clickNewArticleButton() {
        clickElement(newArticleButton);
        return new CreateNewArticlePage(driver);
    }

    public HomePage assertYourFeedTabIsDisplayed() {
        Assert.assertTrue(isWebElementDisplayed(yourFeedTab));
        return this;
    }

    public HomePage assertArticleIsNotDisplayed(String articleTitle) {
        boolean result = true;
        if (yourArticles.size() > 0) {
            result = !yourArticles.get(0).getText().equals(articleTitle);
        }
        Assert.assertTrue(result);
        return this;
    }
}
