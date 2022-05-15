package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {

    public WebDriver driver;
    public Properties prop;

    @BeforeMethod(alwaysRun = true)
    public void setUpAndLoginTestingEnvironment() {
        setUp();
        loginTestingEnvironment();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }

    private void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        prop = new Properties();

        FileInputStream fis;

        try {
            fis = new FileInputStream("../backbasecloud/main.properties");
            prop.load(fis);
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loginTestingEnvironment() {
        String URL = "https://" + prop.getProperty("login") + ":" + prop.getProperty("password") + "@" + prop.getProperty("uri");
        driver.get(URL);
    }

    public HomePage signInAccount() {
        return new HomePage(driver)
                .clickSignInButton()
                .sendTextInEmailField(prop.getProperty("signIn.email"))
                .sendTextInPasswordField(prop.getProperty("signIn.password"))
                .clickSignInButton();
    }
}
