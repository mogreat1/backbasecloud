package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver, 5);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[contains(text(),'Sign in')]")
    private WebElement signInButton;
    @FindBy(xpath = "//*[contains(text(),'New Article')]")
    private WebElement newArticleButton;

    public SignInPage clickSignInButton(){
        clickElement(signInButton);
        return new SignInPage(driver);
    }

    public CreateNewArticlePage clickNewArticleButton(){
        clickElement(newArticleButton);
        return new CreateNewArticlePage(driver);
    }
}
