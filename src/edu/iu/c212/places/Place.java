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
    Arcade Arcade;
    /**
     * Cost for entering the Place
     */
     double entryFee;

    // invoked when the Place is entered
     abstract void onEnter(User user);

     @Override
     public String toString(){
         return getPlaceName() + ":" + entryFee;
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
