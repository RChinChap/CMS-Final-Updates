import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Scanner;

/**
 * @author brie okeefe
 * @suthor richney chin-chap
 */

public class ContentRetrieval {

    public static void main(String[] args) {

        DBConnecter db = new DBConnecter("okeefebl", "1908035");
        Scanner input = new Scanner(System.in);

        /**
         // Program Menu
         // 1: search by title, author's last name, or ID
         // 2: display all
         // 3: more options includes: 1: check status 2: set status 3: check post time 3: format an article
         */

        System.out.println("------ MAIN MENU ------"+"\n");
        System.out.println("Please make a selection: " + "\n" + "\n" + "1: Display all articles " + "\n" + "2: More options (Article ID required)");
        int userChoice = input.nextInt();
        if (userChoice == 1) {
            db.displayInfo();
        }
         else if (userChoice ==2){
            System.out.println("Please enter the ID of the Article you would like to continue with.");
            int idPublisher = input.nextInt();
            ArticleInfo newArticle = new ArticleInfo(idPublisher);
            Publishing newPublish = new Publishing();
            newPublish.publisher(newArticle);
        } else {
            System.out.println("Invalid number. Please enter a number from 1-3:");
        }

        loopBack();
    }

    /**
     * @author richney c
     */
    public static void loopBack(){
        System.out.println("Return to Main Menu? yes or no");
        Scanner input = new Scanner(System.in);
        boolean response = false;
        while (!response){
            String userResponse = input.nextLine();
            if (userResponse.equals("yes")) {
                main(null);
            }
            else{
                System.exit(0);
            }
        }
    }

}
