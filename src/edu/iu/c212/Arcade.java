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

import edu.iu.c212.utils.ConsoleUtils;
import edu.iu.c212.utils.FileUtils;

import java.io.IOException;
import java.sql.SQLOutput;

//import edu.iu.c212.utils.FileUtils;

//import java.io.IOException;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

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
    public Arcade() throws IOException, InterruptedException {
        allUsers = getUserSaveDataFromFile();
        // call getUserOnArcadeEntry and set currentUser.
        currentUser = getUserOnArcadeEntry();
        // instantiate the place list
        allPlaces = new ArrayList<>();
        // all places should take the arcade as an argument...
        allPlaces.add(new Lobby(this));
        allPlaces.add(new GuessTheNumberGame(this));
        allPlaces.add(new BlackjackGame(this));
        allPlaces.add(new HangmanGame(this));
        allPlaces.add(new TriviaGame(this));
        allPlaces.add(new Inventory(this));
        allPlaces.add(new Store(this));
        // transition the Arcade state to the Lobby
           transitionArcadeState(allPlaces.get(0).getPlaceName());
    }

    @Override
    public List<User> getUserSaveDataFromFile() {
        try {
            return FileUtils.getUserDataFromFile();
        }
        catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
            return null;
        }

    //public List<User> getUserSaveDataFromFile() throws IOException {
        // TODO
        //return FileUtils.getUserDataFromFile();
    }

    @Override
    public void saveUsersToFile() {
        try {
            FileUtils.writeUserDataToFile(allUsers);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void transitionArcadeState(String newPlaceNameToGoTo) throws IOException, InterruptedException {
        // TO SEND THE USER TO THE PLACE, YOU HAVE
        // TO CALL THE onEnter() METHOD OF THE PLACE...

        // USE A SWITCH STATEMENT.
        // e.g. switch ("Lobby") should trigger the Lobby object's onEnter()
        // and so on... :-)
        switch (newPlaceNameToGoTo) {
            case "Lobby": {
                // must cast type from interface to class in order to access onEnter()
                Lobby lobby = (Lobby) allPlaces.get(0);
                // lobby has no entrance fee but this is what the
                // general structure of the rest of the
                // switch block should look like.
                if (lobby.getEntryFee() > currentUser.getBalance()) {
                    System.out.println("You don't have enough money to enter. ");
                    lobby.onEnter(currentUser);
                }
                else {
                    currentUser.removeBalance(lobby.getEntryFee());
                    saveUsersToFile();
                    lobby.onEnter(currentUser);
                }
                break;
            }
            case "Guess the Number": {
                GuessTheNumberGame guessTheNumberGame = (GuessTheNumberGame) allPlaces.get(1);
                if (guessTheNumberGame.getEntryFee() > currentUser.getBalance()) {
                    System.out.println("You don't have enough money to enter. ");
                    Lobby lobby = (Lobby) allPlaces.get(0);
                    lobby.onEnter(currentUser);
                }
                else {
                    currentUser.removeBalance(guessTheNumberGame.getEntryFee());
                    saveUsersToFile();
                    guessTheNumberGame.onEnter(currentUser);
                }
                break;
            }
            case "Blackjack": {
                BlackjackGame blackjackGame = (BlackjackGame) allPlaces.get(2);
                if (blackjackGame.getEntryFee() > currentUser.getBalance()) {
                    System.out.println("You don't have enough money to enter. ");
                    Lobby lobby = (Lobby) allPlaces.get(0);
                    lobby.onEnter(currentUser);
                }
                else {
                    currentUser.removeBalance(blackjackGame.getEntryFee());
                    saveUsersToFile();
                    blackjackGame.onEnter(currentUser);
                }
                break;
            }
            case "Hangman": {
                HangmanGame hangmanGame = (HangmanGame) allPlaces.get(3);
                if (hangmanGame.getEntryFee() > currentUser.getBalance()) {
                    System.out.println("You don't have enough money to enter. ");
                    Lobby lobby = (Lobby) allPlaces.get(0);
                    lobby.onEnter(currentUser);
                }
                else {
                    currentUser.removeBalance(hangmanGame.getEntryFee());
                    saveUsersToFile();
                    hangmanGame.onEnter(currentUser);
                }
                break;
            }
            case "Trivia": {
                TriviaGame triviaGame = (TriviaGame) allPlaces.get(4);
                if (triviaGame.getEntryFee() > currentUser.getBalance()) {
                    System.out.println("You don't have enough money to enter. ");
                    Lobby lobby = (Lobby) allPlaces.get(0);
                    lobby.onEnter(currentUser);
                }
                else {
                    currentUser.removeBalance(triviaGame.getEntryFee());
                    saveUsersToFile();
                    triviaGame.onEnter(currentUser);
                }
                break;
            }
            case "Inventory": {
                Inventory inventory = (Inventory) allPlaces.get(5);
                if (inventory.getEntryFee() > currentUser.getBalance()) {
                    System.out.println("You don't have enough money to enter. ");
                    Lobby lobby = (Lobby) allPlaces.get(0);
                    lobby.onEnter(currentUser);
                }
                else {
                    currentUser.removeBalance(inventory.getEntryFee());
                    saveUsersToFile();
                    inventory.onEnter(currentUser);
                }
                break;
            }
            case "Store": {
                Store store = (Store) allPlaces.get(6);
                if (store.getEntryFee() > currentUser.getBalance()) {
                    System.out.println("You don't have enough money to enter. ");
                    Lobby lobby = (Lobby) allPlaces.get(0);
                    lobby.onEnter(currentUser);
                }
                else {
                    currentUser.removeBalance(store.getEntryFee());
                    saveUsersToFile();
                    store.onEnter(currentUser);
                }
                break;
            }
        }
    }

    @Override
    public User getUserOnArcadeEntry() {
        System.out.print("Hello! Welcome to the arcade.\n" +
                "What is your username?\n" +
                "Name: ");
        String name = ConsoleUtils.readLineFromConsole();

        // first, check if the user is already in the text file
        // welcome them back if they are in the text file and return the user.
        for (User user : allUsers) {
            if (user.getUsername().equals(name)) {
                System.out.println("Welcome back, " + name);
                return user;
            }
        }
        // if they are a new user, make a new user and add it to allUsers and save users.
        // then return the user.
        User user = new User(name, 100, new ArrayList<>());
        allUsers.add(user);
        saveUsersToFile();
        return user;
    }

    @Override
    public List<Place> getAllPlaces() {
        return allPlaces;
    }

    public User getCurrentUser() {
        return currentUser;
    }
}
