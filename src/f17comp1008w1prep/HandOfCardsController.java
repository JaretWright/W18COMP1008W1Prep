package f17comp1008w1prep;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
        
        ArrayList<VisualCard> playersHand = new ArrayList<>();
        
        for (int counter=1; counter <=5; counter++)
            playersHand.add(deck.dealTopCard());
                        
        card1.setImage(playersHand.get(0).getCardImage());
        card2.setImage(playersHand.get(1).getCardImage());
        card3.setImage(playersHand.get(2).getCardImage());
        card4.setImage(playersHand.get(3).getCardImage());
        card5.setImage(playersHand.get(4).getCardImage());
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
