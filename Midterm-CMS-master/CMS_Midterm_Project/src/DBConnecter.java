import java.sql.*;
import java.util.ArrayList;

public class DBConnecter implements ArticleInfoModel{

    /**
     * credit for creation and manipulation of the database
     * @author brie okeefe
     */

    private Connection connection;
    private ArrayList<ArticleInfo> articles;

    boolean useDb = true;

    /**
     * @author bob z
     * @author brie okeefe
     */
    DBConnecter(String user, String password) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://dany.simmons.edu:3306/33501sp20_okeefebl?useUnicode=yes&characterEncoding=UTF-8",
                    user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Constructor that accepts a list of ArticleInfo
     * @param articles
     * @author Bob Z
     * @author Richney Chin-Chap
     */
    DBConnecter(ArrayList<ArticleInfo> articles){
        this.useDb = false;
        this.articles = articles;
    }

    DBConnecter(){
        this.useDb = false;
        this.articles = new ArrayList<ArticleInfo>();
    }
    /**
     * @author richney chin-chap
     */
    public void add(ArticleInfo article) {
        articles.add(article);
    }
    /**
     * @author richney chin-chap
     */
    public void save(String[] cols) {
        try {
            Statement insertBook = connection.createStatement();
            insertBook.execute(
                    "INSERT INTO POSTINGS3 " +
                            "(TITLE, CATEGORY, AUTHOR_FIRST, AUTHOR_MIDDLE, AUTHOR_LAST, GENRE, EDITION, PAGES, COVER_TYPE)" +
                            " VALUES ('" + cols[0] + "', '" + cols[1] + "', '" + cols[2] + "', '" + cols[3] + "', '" +
                            cols[4] + "', '" + cols[5] + "', " + Integer.parseInt(cols[6]) + ", " +
                            Integer.parseInt(cols[7]) + ", '" + cols[8] + "')");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * @author richney chin-chap
     */
    public ArrayList<ArticleInfo> getArticles(int i) {
        if (useDb) {
            articles = new ArrayList<ArticleInfo>();
            try {
                Statement selectArticle = connection.createStatement();
                ResultSet rs = selectArticle.executeQuery("SELECT ID, TITLE, AUTHOR_FIRST, AUTHOR_LAST," +
                        " PHOTO, POST_AT, POSTED, H1, P1, H2, P2, H3, P3, H4, P4, H5, P5, H6, P6, H7, P7," +
                        " H8, P8, H9, P9, H10, P10 FROM POSTINGS3 WHERE ID=" + i +";");
                // Iterate over result set and print each book description.
                while (rs.next()) {
                    ArticleInfo article = new ArticleInfo();
                    article.setId(rs.getInt(1)); // ID
                    article.setTitle(rs.getString(2)); // Title
                    article.setAFirst(rs.getString(3)); //AuthorFirst
                    article.setALast(rs.getString(4)); // AuthorLast
                    article.setPhoto(rs.getString(5));// Photo path
                    article.setPostAt(rs.getTimestamp(6)); // time published
                    article.setStatus(rs.getInt(7), rs.getInt(8)); //published or not

                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return this.articles;
    }

    /**
     * @author brie okeefe
     */
    public void displayInfo(){
        try {
            Statement selectArticle = connection.createStatement();
            ResultSet rs = selectArticle.executeQuery("SELECT TITLE, AUTHOR_FIRST, AUTHOR_LAST, ID," +
                    " POSTED FROM POSTINGS3");
            while (rs.next()) {
                System.out.println("ID: " + rs.getString(4)); // ID
                System.out.println("Title: " + rs.getString(1)); // Title
                System.out.println("Author: " + rs.getString(2) + " " + rs.getString(3)); // Author
                System.out.println("Published: " + rs.getString(5));
                System.out.println("\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public Connection getConnection(){
        return connection;
    }
}
