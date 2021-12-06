package edu.iu.c212.places;

import edu.iu.c212.Arcade;
import edu.iu.c212.models.User;
import edu.iu.c212.utils.ConsoleUtils;

/**
 * This represents the Lobby, which you will enter at the beginning
 * of the arcade and after exiting any other places.
 * It should have a $0 entry fee.
 */
public class Lobby extends Place {

    /**
     * Lobby constructor.
     */
    public Lobby(Arcade arcade) {
        this.arcade = arcade;
        this.placeName = "Lobby";
        this.entryFee = 0.0;
    }

    /**
     * This should use ConsoleUtils.printMenuToConsole to print a menu that
     * 1) welcomes you to the arcade
     * 2) lets you know your balance
     * 3) asks you to select a place to go to
     *    from the list of all places in the arcade
     *    using arcade.getAllPlaces()
     *
     * It should then go to the selected place.
     * @param user the User who has entered the lobby.
     */
    @Override
    public void onEnter(User user) {
        // the menu
        Place place = ConsoleUtils.printMenuToConsole(
                "Welcome to the Lobby, " + user.getUsername() + ". \n"
                + "Your balance: " + user.getBalance() + "\n"
                + "Select a place to go: \n", arcade.getAllPlaces(), true);
        // transfer user to the selected place
        arcade.transitionArcadeState(place.toString());

        /*System.out.println("Welcome to the Lobby " + user.getUsername() + "!" + "\n"
                + "You are currently in the Lobby. Your Balance is: " + user.getBalance());
        System.out.println(Arcade.getAllPlaces());*/
    }
}
