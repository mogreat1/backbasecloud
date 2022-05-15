package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewArticlePage extends BasePage {

    public CreateNewArticlePage(WebDriver driver) {
        super(driver, 5);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@placeholder='Article Title']")
    private WebElement articleTitleTextField;
    @FindBy(xpath = "//*[@formcontrolname='description']")
    private WebElement descriptionTextField;
    @FindBy(xpath = "//*[@formcontrolname='body']")
    private WebElement contentTextField;
    @FindBy(xpath = "//*[@placeholder='Enter tags']")
    private WebElement tagsTextField;
    @FindBy(xpath = "//*[contains(text(),'Publish Article')]")
    private WebElement publishArticleButton;

    public CreateNewArticlePage sendTextInArticleTitleTextField(String text) {
        sendText(articleTitleTextField, text);
        return this;
    }

    public CreateNewArticlePage sendTextInDescriptionTextField(String text) {
        sendText(descriptionTextField, text);
        return this;
    }

    public CreateNewArticlePage sendTextInContentTextField(String text) {
        sendText(contentTextField, text);
        return this;
    }

    public CreateNewArticlePage sendTagsTextField(String text) {
        sendText(tagsTextField, text);
        return this;
    }

    public ArticlePage clickPublishArticleButton() {
        clickElement(publishArticleButton);
        return new ArticlePage(driver);
    }
}
