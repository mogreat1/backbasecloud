package tests;

import base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ArticlePage;
import pages.HomePage;

import static utils.Utils.createName;

public class DeleteArticleTest extends BaseTest {
    private HomePage homePage;


    @BeforeMethod
    public void setUp() {
        //given
        homePage = signInAccount();
    }

    @Test(description = "Should Delete Article")
    public void shouldDeleteArticle() {
        //given
        String articleTitle = createName("Title");

        ArticlePage articlePage = homePage
                .clickNewArticleButton()
                .sendTextInArticleTitleTextField(articleTitle)
                .sendTextInContentTextField(createName("Content"))
                .clickPublishArticleButton();

        //when
        homePage = articlePage
                .clickDeleteArticleButton();

        //then
        homePage
                .assertYourFeedTabIsDisplayed()
                .assertArticleIsNotDisplayed(articleTitle);
    }
}
