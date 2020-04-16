import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class FormatArticlesTest {

    private FormatArticles sampleArticle = new FormatArticles();
    private ArticleInfo article1;

    @BeforeEach
    void setUp() {
        //Creates a list of articles
        ArrayList<ArticleInfo> articleList = new ArrayList<ArticleInfo>(){{add(article1);}};
        TestArticleInfoDao testArticle = new TestArticleInfoDao(articleList);

        //fills headers and paragraphs
        int numTestHeadersParas = 10;
        String[] testHeaders = new String[numTestHeadersParas];
        String[] testParagraphs = new String[numTestHeadersParas];
        for (int i = 0; i < numTestHeadersParas; i++)
        {
            testHeaders[i] = "header" + i ;
            testParagraphs[i] = "paragraph" + i + "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod " +
                    "tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation " +
                    "ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in " +
                    "voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat " +
                    "non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";
        }

        //sets test data for article
        article1 = new ArticleInfo(1017,"Coronavirus cases in the US","Tina","Turner","\thttps://www.oif.ala.org/oif/wp-content/uploads/2019/12/Chillicothe-Prison-Lib-wm.jpg ",Timestamp.valueOf(String.valueOf("2020-04-10 12:00:00")),1, testParagraphs,testHeaders );

        testArticle.add(article1);
    }

    @Test
    void formatArticleAsHTML() {
    }


    @Test
    void formatHeadAsHTML() {
    }

    //need to make the assertEquals expect an html doc
    @Test
    void formatHeaderAsHTML() {
        assertEquals(article1.getHeadings(), sampleArticle.formatHeaderAsHTML(article1));
    }

    @Test
    void formatBodyAsHTML() {
    }
}