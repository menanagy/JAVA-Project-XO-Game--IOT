package LoginScene;

import RMI.Rmi;
import java.io.File;
import xogameserver.interfaces.LoginInterface;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import xogameserver.interfaces.SignUp;

/**
 *
 * @author fegoo
 */
public class Main extends Application {

    public static Stage myStage;
    public static Parent root;
    public static boolean connected;
    String path = "src/Song1.mp3";
    //Media media = new Media (new File (path).toURI().toString());
    // MediaPlayer mediaplayer = new MediaPlayer(media);
    @Override
    public void start(Stage primaryStage) throws Exception {
        myStage = primaryStage;
        System.out.println("First line");
        // new Thread(()->{
        //}).start();
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("/GameOnline/GameScene.fxml"));
        Scene scene = new Scene(root, 909, 509);
        primaryStage.setTitle("TicTacToe");
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static Stage getMyStage() {
        return myStage;
    }

    @Override
    public void stop() throws Exception {
        if (UserData.getSimpleUser() != null) {
            Rmi.getStubLogin().setUserLogoutStatus(UserData.getSimpleUser().getId());
        }
        super.stop(); //To change body of generated methods, choose Tools | Templates.
    }

}
