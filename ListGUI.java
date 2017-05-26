import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 * ListGUI.java - DEC-07-2016 - ITEC 324: Project 4
 * This class contains the main method to display and execute the program.
 * Uses FXML to produce the visual component.
 * @author Tre Haga
 * @version 1.0
 */
public class ListGUI extends Application
{
    @Override
    /**
     * The start method starts the visual component of the program.
     */
    public void start(Stage primaryStage) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("View.fxml"));
        primaryStage.setTitle("ITEC 324: Project 4");
        primaryStage.setScene(new Scene(root, 1000, 600));
        primaryStage.show();
        primaryStage.setResizable(false);
    }
    /**
     * The main method that displays and executes the program.
     * @param args command line arguments
     */
    public static void main(String[] args)
    {
        launch(args);
    }
}
