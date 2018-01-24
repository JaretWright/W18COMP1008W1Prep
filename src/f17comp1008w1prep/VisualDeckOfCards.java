package f17comp1008w1prep;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author JWright
 */
public class VisualDeckOfCards {
    private ArrayList<VisualCard> deck;
    
    public VisualDeckOfCards()
    {
        deck = new ArrayList<>();
        
        String[] faceNames = {"2","3","4","5","6","7","8","9","10","jack","queen","king","ace"};
        String[] suits = {"spades", "clubs", "hearts", "diamonds"};
        
        for (int suit = 0; suit<suits.length; suit++){
            for (int face = 0; face<faceNames.length; face++)
                deck.add(new VisualCard(faceNames[face], suits[suit], face+2));
        }            
    }
    
    public void printDeckToConsole()
    {
        System.out.println(deck);
    }
    
    public VisualCard dealTopCard()
    {
        return deck.remove(0);
    }
    
    public String toString()
    {
        String deckString = "";
        
        for (VisualCard card : deck)
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
    
    public int getNumOfCards()
    {
        return deck.size();
    }
}
