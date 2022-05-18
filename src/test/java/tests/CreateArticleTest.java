package tests;


import base.BaseTest;
import org.testng.annotations.*;
import pages.ArticlePage;
import pages.CreateNewArticlePage;
import pages.HomePage;

import static utils.Utils.createName;
import static org.apache.commons.lang.StringUtils.EMPTY;


public class CreateArticleTest extends BaseTest {
    private HomePage homePage;
    private ArticlePage articlePage;

    @BeforeMethod
    public void setUp() {
        //given
        homePage = signInAccount();
    }

    @Test(dataProvider = "articleDataProvider", description = "Should Create Article")
    public void shouldCreateArticle(String title, String description, String body, String tags) {
        //when
        articlePage = homePage
                .clickNewArticleButton()
                .sendTextInArticleTitleTextField(title)
                .sendTextInDescriptionTextField(description)
                .sendTextInContentTextField(body)
                .sendTagsTextField(tags)
                .clickPublishArticleButton();

        //then
        articlePage
                .assertArticleTitleIsDisplayed()
                .assertArticleTitleEqualsTo(title)
                .assertArticleContentIsDisplayed()
                .assertArticleContentEqualsTo(body);
    }

    @DataProvider(name = "articleDataProvider")
    public Object[][] articleDataProvider() {
        return new Object[][]{
                {createName("Title"), createName("Desc"), createName("Body"), createName("Tag")},
                {createName("Title"), createName("Desc"), createName("Body"), EMPTY},
                {createName("Title"), EMPTY, createName("Body"), EMPTY}
        };
    }

    @Test(description = "Should validate no Article Title")
    public void shouldValidateNoArticleTitle() {
        //when
        articlePage = homePage
                .clickNewArticleButton()
                .clickPublishArticleButton();

        //then
        articlePage
                .assertNoArticleTitleExceptionIsDisplayed();
    }

    @Test(description = "Should validate no Article Content")
    public void shouldValidateNoArticleContent() {
        //when
        articlePage = homePage
                .clickNewArticleButton()
                .sendTextInArticleTitleTextField(createName("Title"))
                .clickPublishArticleButton();

        //then
        articlePage
                .assertNoArticleContentExceptionIsDisplayed();
    }

    @Test(description = "Should validate unique Article Title")
    public void shouldValidateUniqueArticleValue() {
        //given
        String articleTitle = createName("Title");

        CreateNewArticlePage createNewArticlePage = homePage
                .clickNewArticleButton()
                .sendTextInArticleTitleTextField(articleTitle)
                .sendTextInContentTextField(createName("Content"))
                .clickPublishArticleButton()
                .clickNewArticleButton();

        //when
        articlePage = createNewArticlePage
                .sendTextInArticleTitleTextField(articleTitle)
                .sendTextInContentTextField(createName("Content"))
                .clickPublishArticleButton();

        //then
        articlePage
                .assertNotUniqueArticleTitleExceptionIsDisplayed();
    }
}
