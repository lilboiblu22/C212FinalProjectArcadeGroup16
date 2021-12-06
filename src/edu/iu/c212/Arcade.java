package edu.iu.c212;
//Jon's dad tortures jon with his farts, call CPS.

import edu.iu.c212.models.User;
import edu.iu.c212.places.Inventory;
import edu.iu.c212.places.Lobby;
import edu.iu.c212.places.Place;
import edu.iu.c212.places.Store;
import edu.iu.c212.places.games.GuessTheNumberGame;
import edu.iu.c212.places.games.TriviaGame;
import edu.iu.c212.places.games.blackjack.BlackjackGame;
import edu.iu.c212.places.games.hangman.HangmanGame;
import edu.iu.c212.utils.FileUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Arcade implements IArcade {

    User currentUser;

    /**
     * As read by getUserSaveDataFromFile().
     * This should contain currentUser.
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
        allPlaces.add(new BlackjackGame(this));
        allPlaces.add(new HangmanGame());
        allPlaces.add(new TriviaGame());
        allPlaces.add(new Inventory());
        allPlaces.add(new Store());
        // transition the Arcade state to the Lobby
        // TODO
        // transitionArcadeState(the_lobby);
    }

    @Override
    public List<User> getUserSaveDataFromFile() throws IOException {
        // TODO
        return FileUtils.getUserDataFromFile();
    }

    @Override
    public void saveUsersToFile() {
        // TODO
    }

    @Override
    public void transitionArcadeState(String newPlaceNameToGoTo) {
        // TODO
        // If the user doesn't have enough money to go the Place,
        // print a warning to the user and transition to the lobby.

        // If the user has enough money to go to the Place,
        // subtract the entry fee from the player, save to file,
        // and enter the Place.
    }

    @Override
    public User getCurrentUserOnArcadeEntry() {
        // TODO
        // Ask for a username to be entered.

        // If the username is not contained in the users as read
        // from users.txt, a welcome message should be printed.

        // If the username already exists,
        // a welcome back message should be printed.
        return null;
    }

    @Override
    public List<Place> getAllPlaces() {
        return allPlaces;
    }

    public User getCurrentUser() {
        return currentUser;
    }
}
