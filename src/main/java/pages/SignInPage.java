package pages;

import base.BasePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage extends BasePage {

    public SignInPage(WebDriver driver) {
        super(driver, 5);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@formcontrolname='email']")
    private WebElement emailField;
    @FindBy(xpath = "//*[@formcontrolname='password']")
    private WebElement passwordField;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement signInButton;

    public SignInPage sendTextInEmailField(String email) {
        sendText(emailField, email);
        return this;
    }

    public SignInPage sendTextInPasswordField(String password) {
        sendText(passwordField, password);
        return this;
    }

    public HomePage clickSignInButton() {
        clickElement(signInButton);
        return new HomePage(driver);
    }

}

