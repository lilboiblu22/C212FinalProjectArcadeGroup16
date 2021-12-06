package edu.iu.c212.places;

import edu.iu.c212.Arcade;
import edu.iu.c212.models.User;

import java.io.IOException;

public abstract class Place {
    /**
     * Name of the Place
     */
     String placeName;
    /**
     * Reference to the Arcade the Place resides in
     */
    Arcade arcade;
    /**
     * Cost for entering the Place
     */
     double entryFee;

    /**
     * What is invoked when the place is entered.
     * @param user the current User.
     */
    public abstract void onEnter(User user) throws IOException, InterruptedException;

    /**
     * Should return the place name, the entry fee,
     * and whether the place is a Game or not.
     * @return String formatted, name
     */

     @Override
     public String toString(){
         return getPlaceName() + ": " + entryFee; }

    public String getPlaceName() {
         return placeName;
     }

     public void setPlaceName(String placeName) {
         this.placeName = placeName;
     }

     public double getEntryFee() {
         return entryFee;
     }

     public void setEntryFee(double amount) {
         this.entryFee = amount;
     }

    public void setArcade(Arcade arcade) {
        this.arcade = arcade;
    }

    public Arcade getArcade() {
        return arcade;
    }
}
