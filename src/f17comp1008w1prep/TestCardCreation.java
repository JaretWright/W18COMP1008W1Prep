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
public class TestCardCreation {
    public static void main(String[] args)
    {
        
        Card aceOfSpades = new Card("ace", "spades");
        
        System.out.printf("The face name of the card is %s%n", aceOfSpades.getFaceName());
        System.out.printf("The suit of the card is %s%n", aceOfSpades.getSuit());
        System.out.printf("The card describes itself as: %s%n", aceOfSpades);
        
        Card twoOfDiamonds = new Card("2", "diamonds");
        System.out.printf("%n%nThe face name of the card is %s%n", twoOfDiamonds.getFaceName());
        System.out.printf("The suit of the card is %s%n", twoOfDiamonds.getSuit());
        System.out.printf("The card describes itself as: %s%n", twoOfDiamonds);
        
        DeckOfCards deck = new DeckOfCards(); // this calls our constructor
        deck.printDeckToConsole(); //uses the ArrayList print function
        
        System.out.printf("%nHere is the DeckOfCards toString() method: %n%s%n", deck.toString());
        
        deck.shuffleDeck();
        
        System.out.printf("%nHere is the DeckOfCards after a shuffle: %n%s%n", deck.toString());
        
    }
                
}
