package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ArticlePage extends BasePage {

    public ArticlePage(WebDriver driver) {
        super(driver, 3);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[self::h1]")
    private WebElement articleTitle;
    @FindBy(xpath = "//*[@class='row article-content']/div/div/p")
    private WebElement articleContent;
    @FindBy(xpath = "//button[contains(text(),'Post Comment')]")
    private WebElement postCommentButton;
    @FindBy(xpath = "//noArticleTitleException")
    private WebElement noArticleTitleException;
    @FindBy(xpath = "//noArticleContentException")
    private WebElement noArticleContentException;
    @FindBy(xpath = "//notUniqueArticleTitleException")
    private WebElement notUniqueArticleTitleException;
    @FindBy(xpath = "//*[contains(text(),'New Article')]")
    private WebElement newArticleButton;
    @FindBy(xpath = "//button[contains(text(),'Delete Article')]")
    private WebElement deleteArticleButton;

    public ArticlePage assertArticleTitleIsDisplayed() {
        Assert.assertTrue(isWebElementDisplayed(articleTitle));
        return this;
    }

    public ArticlePage assertArticleContentIsDisplayed() {
        Assert.assertTrue(isWebElementDisplayed(articleContent));
        return this;
    }

    public ArticlePage assertArticleTitleEqualsTo(String text) {
        Assert.assertEquals(getTextField(articleTitle), text);
        return this;
    }

    public ArticlePage assertArticleContentEqualsTo(String text) {
        Assert.assertEquals(getTextField(articleContent), text);
        return this;
    }

    public ArticlePage assertNoArticleTitleExceptionIsDisplayed() {
        Assert.assertTrue(isWebElementDisplayed(noArticleTitleException));
        return this;
    }

    public ArticlePage assertNoArticleContentExceptionIsDisplayed() {
        Assert.assertTrue(isWebElementDisplayed(noArticleContentException));
        return this;
    }

    public ArticlePage assertNotUniqueArticleTitleExceptionIsDisplayed() {
        Assert.assertTrue(isWebElementDisplayed(notUniqueArticleTitleException));
        return this;
    }

    public CreateNewArticlePage clickNewArticleButton() {
        clickElement(newArticleButton);
        return new CreateNewArticlePage(driver);
    }

    public HomePage clickDeleteArticleButton() {
        clickElement(deleteArticleButton);
        return new HomePage(driver);
    }
}
