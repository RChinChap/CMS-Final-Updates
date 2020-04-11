import java.util.ArrayList;

public interface ArticleInfoModel {

    void add(ArticleInfo article);

    void save(String[] cols);

    ArrayList<ArticleInfo> getArticles(int i);
}
