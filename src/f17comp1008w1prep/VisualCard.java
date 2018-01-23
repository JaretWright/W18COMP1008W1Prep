package f17comp1008w1prep;

import java.util.ArrayList;
import java.util.Arrays;
import javafx.scene.image.Image;

/**
 *
 * @author JWright
 */
public class VisualCard {
    
    private String faceName, suit;
    private int faceValue;
    private Image cardImage;

    public VisualCard(String faceName, String suit, int faceValue) {
        setFaceName(faceName);
        setSuit(suit);
        setFaceValue(faceValue);
        setCardImage(new Image(getImageFileName()));
    }

    public String getImageFileName()
    {
        return String.format("file:./images/%s_of_%s.png", getFaceName(), getSuit());
    }
    
    
    
    public Image getCardImage() {
        return cardImage;
    }

    public void setCardImage(Image cardImage) {
        this.cardImage = cardImage;
    }

    public String getFaceName() {
        return faceName;
    }

    public void setFaceName(String faceName) {           
        ArrayList validFaceNames = 
                new ArrayList<String>(Arrays.asList("2","3","4","5","6","7","8","9","10","jack","queen","king","ace"));
        
        //this is a case sensitive search technique
        if (validFaceNames.contains(faceName))
            this.faceName = faceName;
        else
            throw new IllegalArgumentException("Invalid face name");
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        if (suit.equalsIgnoreCase("spades") || suit.equalsIgnoreCase("clubs") ||
            suit.equalsIgnoreCase("hearts") || suit.equalsIgnoreCase("diamonds"))
            this.suit = suit.toLowerCase();
        else
            throw new IllegalArgumentException("suit must be spades, clubs, hearts or diamonds");
    }

    public int getFaceValue() {
        return faceValue;
    }

    public void setFaceValue(int faceValue) {
        if (faceValue < 2 || faceValue > 14)
            throw new IllegalArgumentException("Card object must have a face value between 2-14 inclusive");
        else
            this.faceValue = faceValue;
    }

    public String toString()
    {
        return faceName + " of " + suit;
    }
}
