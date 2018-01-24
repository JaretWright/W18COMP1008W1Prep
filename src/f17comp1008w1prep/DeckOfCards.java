package f17comp1008w1prep;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author JWright
 */
public class DeckOfCards {
    ArrayList<Card> deck;
    
    public DeckOfCards()
    {
        deck = new ArrayList<>();
        
        String[] faceNames = {"2","3","4","5","6","7","8","9","10","jack","queen","king","ace"};
        String[] suits = {"spades", "clubs", "hearts", "diamonds"};
        
        for (int suit = 0; suit<suits.length; suit++){
            for (int face = 0; face<faceNames.length; face++)
                deck.add(new Card(faceNames[face], suits[suit]));
        }            
    }
    
    public void printDeckToConsole()
    {
        System.out.println(deck);
    }
    
    public String toString()
    {
        String deckString = "";
        
        for (Card card : deck)
            deckString = deckString + card.toString() + "\n";
        
        return deckString;                
    }
    
    public void shuffleDeck()
    {
        Collections.shuffle(deck);
        
        //or to make it more random, add a salt
        SecureRandom rng = new SecureRandom();
        Collections.shuffle(deck, rng);
        
    }
}
