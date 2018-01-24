package f17comp1008w1prep;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Interpolator;
import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.shape.ArcTo;
import javafx.scene.shape.ClosePath;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.PathElement;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;


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
    @FXML    private Label cardInDeckLabel;
             private VisualCard card;
             private VisualDeckOfCards deck;
             
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        VisualDeckOfCards deck = new VisualDeckOfCards();
        deck.shuffleDeck();
        this.deck = deck;
        cardInDeckLabel.setText(Integer.toString(deck.getNumOfCards()));
        
    }  
    
    
    /**
     * This method will load the card on the scene
     * @param card 
     */
    public void preloadCard(VisualCard card)
    {
        this.card=card;
        suitLabel.setText(card.getSuit());
        faceNameLabel.setText(card.getFaceName());
        valueLabel.setText(Integer.toString(card.getFaceValue()));
        imageView.setImage(card.getCardImage());
        
        setVisible(false);
    }
    
    /**
     * This method will make the labels either visible or invisible with 1 command
     * @param trueOrFalse 
     */
    public void setVisible(boolean trueOrFalse)
    {
        suitLabel.setVisible(trueOrFalse);
        faceNameLabel.setVisible(trueOrFalse);
        valueLabel.setVisible(trueOrFalse);
        imageView.setVisible(trueOrFalse);
    }
    
    /**
     * This will change to the hand of cards scene
     * @param event
     * @throws IOException 
     */
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
    
    
    /**
     * This will take the top card out of the deck and display it with an animation
     */
    public void spinCardButtonPushed() 
    {
       
        preloadCard(deck.dealTopCard());
        cardInDeckLabel.setText(Integer.toString(deck.getNumOfCards()));
        setVisible(true);
        
        imageView.setX(0);
        imageView.setY(0);
        
        //this creates an array of points the object should move to
        PathElement[] path = 
        {           
            new MoveTo(-100, -100),     //starting point
            new LineTo(80, 150),        //ending point
           // new ClosePath()           //This will take it back to where it started
        };
        
        //This creates a Path object
        Path pathToFollow = new Path();
        pathToFollow.getElements().addAll(path);
        
        //creating a PathTransition object.  This allows us to define the path, how long the animation will take, how many times it will happen and
        //get it to start with the play() method
        PathTransition anim = new PathTransition();
        anim.setNode(imageView);
        anim.setPath(pathToFollow);
        anim.setInterpolator(Interpolator.LINEAR);  //provides for smooth motion
        anim.setDuration(new Duration(1000));
        anim.setCycleCount(1);
        anim.play();
        
        //This rotates the object 360 degrees 3 times  It will trigger at the same time as the previous animation
        //giving the perception of a card rotating through space
        RotateTransition rotate = new RotateTransition(Duration.millis(300), imageView);
        rotate.setByAngle(360);
        rotate.setCycleCount(3);
        rotate.setAutoReverse(false);
        rotate.play();
    }
    
}
