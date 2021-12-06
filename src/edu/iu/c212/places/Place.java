package edu.iu.c212.places;

import edu.iu.c212.Arcade;
import edu.iu.c212.models.User;

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
     * @param user
     */
     abstract void onEnter(User user);

    /**
     * Should return the place name, the entry fee,
     * and whether the place is a Game or not.
     * @return String formatted, name
     */
     @Override
     public String toString(){
         return getPlaceName() + ": " + entryFee + " " + isGame();
     }

    public boolean isGame(){
        return true;
    }

    public String getPlaceName() {
         return placeName;
     }

     public String setPlaceName() {
         return placeName;
     }

     public double getEntryFee() {
         return entryFee;
     }

     public double setEntryFee() {
         return entryFee;
     }

}
