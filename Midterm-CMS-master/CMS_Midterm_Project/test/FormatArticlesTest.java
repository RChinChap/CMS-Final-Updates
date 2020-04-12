import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class FormatArticlesTest {

    @BeforeEach
    void setUp() {

        ArticleInfo article1 = new ArticleInfo();
        ArrayList<ArticleInfo> articleList = new ArrayList<ArticleInfo>(){{add(article1);}};
        TestArticleInfoDao testArticle = new TestArticleInfoDao(articleList);

        int numTestHeadersParas = 10;
        String[] testHeaders = new String[numTestHeadersParas];
        String[] testParagraphs = new String[numTestHeadersParas];
        for (int i = 0; i < numTestHeadersParas; i++)
        {
            testHeaders[i] = "header" + i;
            testParagraphs[i] = "paragraph" + i;
        }

        article1.setId(1017);
        article1.setTitle("Coronavirus cases in the US");
        article1.setAFirst("NewYork");
        article1.setALast("Times");
        article1.setPostAt(Timestamp.valueOf(String.valueOf("2020-04-10 12:00:00")));
        article1.setStatus(1);
        article1.setParagraphs(testParagraphs);
        article1.setHeadings(testHeaders);

        testArticle.add(article1);
    }

    @Test
    void formatArticleAsHTML() {
    }

    @Test
    void formatHeadAsHTML() {

    }

    @Test
    void formatHeaderAsHTML() {
    }

    @Test
    void formatBodyAsHTML() {
    }
}