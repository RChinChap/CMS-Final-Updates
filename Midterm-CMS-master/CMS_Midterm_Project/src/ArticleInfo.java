import java.sql.*;

/**
 * @author brie okeefe
 * @suthor richney chin-chap
 */

public class ArticleInfo {

    static DBConnecter db = new DBConnecter("okeefebl", "1908035");
    private Connection connection;

    private int id;
    private String title;
    private String aFirst;
    private String aLast;
    private String photo;
    private Timestamp postAt;
    private int posted;
    private String H1;
    private String P1;
    private String H2;
    private String P2;
    private String H3;
    private String P3;
    private String H4;
    private String P4;
    private String H5;
    private String P5;
    private String H6;
    private String P6;
    private String H7;
    private String P7;
    private String H8;
    private String P8;
    private String H9;
    private String P9;
    private String H10;
    private String P10;

    /**
     * @author brie okeefe
     * @suthor richney chin-chap
     */

    public ArticleInfo(int i){
        connection =  db.getConnection();
        try {
            Statement selectInfo = connection.createStatement();
            ResultSet rs = selectInfo.executeQuery("SELECT ID, TITLE, AUTHOR_FIRST, AUTHOR_LAST," +
                    " PHOTO, POST_AT, POSTED, H1, P1, H2, P2, H3, P3, H4, P4, H5, P5, H6, P6, H7, P7," +
                    " H8, P8, H9, P9, H10, P10 FROM POSTINGS3 WHERE ID=" + i +";");
            while (rs.next()) {
                id = rs.getInt(1); // ID
                title = rs.getString(2); // Title
                aFirst = rs.getString(3); //AuthorFirst
                aLast = rs.getString(4); // AuthorLast
                photo = rs.getString(5);// Photo path
                postAt = rs.getTimestamp(6); // time published
                posted = rs.getInt(7); //published or not
                H1 = rs.getString(8);
                P1 = rs.getString(9);
                H2 = rs.getString(10);
                P2 = rs.getString(11);
                H3 = rs.getString(12);
                P3 = rs.getString(13);
                H4 = rs.getString(14);
                P4 = rs.getString(15);
                H5 = rs.getString(16);
                P5 = rs.getString(17);
                H6 = rs.getString(18);
                P6 = rs.getString(19);
                H7 = rs.getString(20);
                P7 = rs.getString(21);
                H8 = rs.getString(22);
                P8 = rs.getString(23);
                H9 = rs.getString(24);
                P9 = rs.getString(25);
                H10 = rs.getString(26);
                P10 = rs.getString(27);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArticleInfo() {
    }

    /**
     * @author brie okeefe
     */
    public int getID(){
        return id;
    }

    /**
     * @author richney chin-chap
     */

    public void setId(int id) {
        this.id = id;
    }

    /**
     * @author brie okeefe
     */
    public String getIDString(){
        return Integer.toString(id);
    }

    /**
     * @author brie okeefe
     */
    public String getTitle(){
        return title;
    }
    /**
     * @author richney chin-chap
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @author brie okeefe
     */
    public String getAFirst(){
        return aFirst;
    }

    /**
     * @author richney chin-chap
     */

    public void setAFirst(String aFirst) {
        this.aFirst = aFirst;
    }

    /**
     * @author brie okeefe
     */
    public String getALast(){
        return aLast;
    }

    /**
     * @author richney chin-chap
     */
    public void setALast(String aLast) {
        this.aLast = aLast;
    }

    /**
     * @author brie okeefe
     */
    public String getPhoto(){
        return photo;
    }

    /**
     * @author richney chin-chap
     */
    public void setPhoto(String photo) {
        this.photo = photo;
    }

    /**
     * @author brie okeefe
     */
    public String[] getHeadings(){
        String [] headings = {H1, H2, H3, H4, H5, H6, H7, H8, H9, H10};
        return headings;
    }

    /**
     * @author brie okeefe
     */
    public String[] getParagraphs(){
        String[] paragraphs = {P1, P2,P3, P4, P5, P6, P7, P8, P9, P10};
        return paragraphs;
    }
    /**
     * @author kaya m
     */
    public Timestamp getPostAt(){
        return postAt;
    }

    /**
     * @author kaya m
     */
    //0000-00-00 00:00:00 time Stamp format
    // In progress
    public void setPostAt(Timestamp newPostTime){
        Timestamp ts = Timestamp.valueOf(String.valueOf(newPostTime));
        String setPostAtQuery = "UPDATE POSTINGS3 SET POST_AT = '" + ts + "' WHERE ID = " + id + ";";
        //String setPostAtQuery = "UPDATE POSTINGS3 SET POST_AT = '" + ts + "';";
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(setPostAtQuery);
            postAt = ts;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @author kaya m
     * @author brie okeefe
     */
    //Status refers to if the article has been posted or not
    //0: not posted
    //1: posted
    public int getStatus(){ return posted; }

    public void setStatus(int i, int id){
        String setStatusQuery = "UPDATE POSTINGS3 SET POSTED = " + i + " WHERE ID = " + id + ";";

        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(setStatusQuery);
            posted = i;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @author brie okeefe
     */
    /*
    //May use this later/ for final
    //public void printArticleInfo(){
    //    System.out.println("ID: " + getID());
    //    System.out.println("Title: "+getTitle());
    //    System.out.println("Name: " + getAFirst() + getALast());
    // }
    */

    /**
     * @author brie okeefe
     * @author kaya m
     */
    public String getBrowserAddress(){
        return "file:///Y:/%20" + this.getIDString() + ".html";
    }

    /**
     * @author richney chin-chap
     */
    @Override
    public String toString(){
        return "Id: " + getIDString() + ", Title: " + getTitle() + ", Author: " + getAFirst() + getALast();
    }

}

