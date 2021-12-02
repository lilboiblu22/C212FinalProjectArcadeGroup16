package edu.iu.c212.places;

import edu.iu.c212.Arcade;
import edu.iu.c212.models.User;

public abstract class Place {
     String placeName;
     Arcade arcade;
     double entryFee;

     abstract void onEnter(User user);

     @Override
     public String toString(){
         return getPlaceName() + ":" + entryFee;
     }

     public String getPlaceName(){
         return placeName;
     }
     public String setPlaceName(){
         return placeName;
     }

     public double getEntryFee(){
         return entryFee;
     }

     public double setEntryFee(){
         return entryFee;
     }

}
