import java.util.ArrayList;

public interface ArticleInfoModelDao {

    void add(ArticleInfo article);

    ArrayList<ArticleInfo> getArticles(int i);
}
