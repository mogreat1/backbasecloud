package tests;


import base.BaseTest;
import org.testng.annotations.*;
import pages.ArticlePage;
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

    @Test(dataProvider = "articleDataProvider")
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

    @Test
    public void shouldValidateNoArticleTitle() {
        //when
        articlePage = homePage
                .clickNewArticleButton()
                .clickPublishArticleButton();

        //then
        articlePage
                .assertNoArticleTitleExceptionIsDisplayed();
    }

    @Test
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
}
