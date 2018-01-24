package f17comp1008w1prep;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author JWright
 */
public class Card {
    private static String[] validFaceNames = {"2","3","4","5","6","7","8","9","10","jack","queen","king","ace"};
    private static String[] validSuits = {"spades","clubs","hearts","diamonds"};
    private String faceName, suit;
    private int faceValue;

    public Card(String faceName, String suit) {
        setFaceName(faceName);
        setSuit(suit);
        setFaceValue();
    }

    public String getFaceName() {
        return faceName;
    }

    public void setFaceName(String faceName) 
    {                  
        for (String validFaceName : validFaceNames){
            if (validFaceName.equalsIgnoreCase(faceName)){
                this.faceName = faceName;
                return;
            }                
        }
        throw new IllegalArgumentException("Invalid face name");
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        for (String validSuitName : validSuits)
        {
            if (validSuitName.equalsIgnoreCase(suit)){
                this.suit = suit;
                return;
            }            
        }
        throw new IllegalArgumentException("suit must be spades, clubs, hearts or diamonds");
    }

    public int getFaceValue() {
        return faceValue;
    }

    private void setFaceValue() {
        for (int i=0; i<validFaceNames.length; i++)
        {
            if (validFaceNames[i].equalsIgnoreCase(faceName)){
                this.faceValue=i+2;
                return;
            }                
        }
    }

    public String toString()
    {
        return faceName + " of " + suit;
    }
}
