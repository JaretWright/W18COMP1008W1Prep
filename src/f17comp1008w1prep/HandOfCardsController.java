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
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author JWright
 */
public class HandOfCardsController implements Initializable {

    @FXML    private ImageView card1;
    @FXML    private ImageView card2;
    @FXML    private ImageView card3;
    @FXML    private ImageView card4;
    @FXML    private ImageView card5;
             private VisualDeckOfCards deck;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        VisualDeckOfCards deck = new VisualDeckOfCards();
        deck.shuffleDeck();
        this.deck = deck;
                
        card1.setImage(deck.dealTopCard().getCardImage());
        card2.setImage(deck.dealTopCard().getCardImage());
        card3.setImage(deck.dealTopCard().getCardImage());
        card4.setImage(deck.dealTopCard().getCardImage());
        card5.setImage(deck.dealTopCard().getCardImage());
    }    
    
     public void backButtonPushed(ActionEvent event) throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("CardView.fxml"));
        Parent tableViewParent = loader.load();
        
        CardViewController controller = loader.getController();
        controller.preloadCard(deck.dealTopCard());
        
        Scene tableViewScene = new Scene(tableViewParent);
                
        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(tableViewScene);
        window.show();
    }
    
}
