package edu.iu.c212;

import edu.iu.c212.models.User;
import edu.iu.c212.places.Inventory;
import edu.iu.c212.places.Lobby;
import edu.iu.c212.places.Place;
import edu.iu.c212.places.Store;
import edu.iu.c212.places.games.GuessTheNumberGame;
import edu.iu.c212.places.games.TriviaGame;
import edu.iu.c212.places.games.blackjack.BlackjackGame;
import edu.iu.c212.places.games.hangman.HangmanGame;

import java.util.ArrayList;
import java.util.List;

public class Arcade implements IArcade {

    User currentUser;

    /**
     * As read by getUserSaveDataFromFile().
     * Should contain currentUser.
     */
    List<User> allUsers;

    /**
     * All places in the Arcade.
     * Includes: Lobby, Guess the Number, Blackjack,
     *           Hangman, Trivia, Inventory, and Store
     */
    List<Place> allPlaces;

    /**
     * Arcade Constructor
     */
    public Arcade() {
        // call getUserOnArcadeEntry and set currentUser.
        getCurrentUserOnArcadeEntry();
        // instantiate the place list
        allPlaces = new ArrayList<>();
        allPlaces.add(new Lobby());
        allPlaces.add(new GuessTheNumberGame());
        allPlaces.add(new BlackjackGame());
        allPlaces.add(new HangmanGame());
        allPlaces.add(new TriviaGame());
        allPlaces.add(new Inventory());
        allPlaces.add(new Store());
        // transition the Arcade state to the Lobby
        // TODO
        // transitionArcadeState(the_lobby);
    }

    /**
     * This will call FileUtils.getUserDataFromFile, and use
     * System.exit() to exit the program if an exception is thrown.
     * @return a List of Users.
     */
    @Override
    public List<User> getUserSaveDataFromFile() {
        // TODO
        return null;
    }

    /**
     * Call FileUtils.writeUserDataFromFile to write all users to the txt file.
     */
    @Override
    public void saveUserDataToFile() {
        // TODO
    }

    /**
     * Attempt to transition the currentUser to the new place.
     * @param newPlaceNameToGoTo a Place that the user wants to go.
     */
    @Override
    public void transitionArcadeState(String newPlaceNameToGoTo) {
        // TODO
        // If the user doesn't have enough money to go the Place,
        // print a warning to the user and transition to the lobby.

        // If the user has enough money to go to the Place,
        // subtract the entry fee from the player, save to file,
        // and enter the Place.
    }

    /**
     * Ask for User's name on entry to the Arcade.
     * @return a User.
     */
    @Override
    public User getCurrentUserOnArcadeEntry() {
        // TODO
        // If the username is not contained in the users as read
        // from users.txt, a welcome message should be printed.

        // If the username already exists,
        // a welcome back message should be printed.
        return null;
    }

    /**
     * Return a List of all the Places in the Arcade.
     * @return a List of Places.
     */
    @Override
    public List<Place> getAllPlaces() {
        return allPlaces;
    }


}
