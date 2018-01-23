package f17comp1008w1prep;

import java.io.File;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author JWright
 */
public class LaunchVisualCardViewer extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        
        VisualCard aceOfSpades = new VisualCard("ace", "spades", 14);
        
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("CardView.fxml"));
        Parent parent = loader.load();
        
        CardViewController controller = loader.getController();
        controller.preloadCard(aceOfSpades);
        
        Scene scene = new Scene(parent);
       
        stage.setTitle("Super awesome card viewer");
        stage.setScene(scene);
        stage.show();
    }
    
    public static void main(String[] args)
    {
        launch(args);
    }
    
}


