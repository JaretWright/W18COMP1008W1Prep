package f17comp1008w1prep;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author JWright
 */
public class CardViewController implements Initializable {
    @FXML    private ImageView imageView;
    @FXML    private Label suitLabel;
    @FXML    private Label faceNameLabel;
    @FXML    private Label valueLabel;
             private VisualCard card;
             
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }  
    
    public void preloadCard(VisualCard card)
    {
        this.card=card;
        suitLabel.setText(card.getSuit());
        faceNameLabel.setText(card.getFaceName());
        valueLabel.setText(Integer.toString(card.getFaceValue()));
        imageView.setImage(card.getCardImage());

    }
    
    public void changeSceneseButtonPushed(ActionEvent event) throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("HandOfCards.fxml"));
        Parent tableViewParent = loader.load();
        
        Scene tableViewScene = new Scene(tableViewParent);
                
        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(tableViewScene);
        window.show();
    }
    
}
