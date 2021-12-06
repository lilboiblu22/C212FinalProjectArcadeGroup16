package edu.iu.c212.places.games;

import edu.iu.c212.Arcade;
import edu.iu.c212.models.User;
import edu.iu.c212.utils.ConsoleUtils;
import edu.iu.c212.utils.FileUtils;
//import jdk.incubator.vector.VectorOperators;

import java.io.Console;
import java.util.Random;
import java.util.Scanner;
import java.util.function.Function;

public class GuessTheNumberGame extends Game {

    public GuessTheNumberGame(Arcade arcade) {
        setArcade(arcade);
        setPlaceName("Guess the Number");
        setEntryFee(10);
    }

   static Boolean between1And100(Integer guess){
        return (guess >= 0 && guess <= 100);
    }

    @Override
    public void onEnter(User user) {
        ConsoleUtils.printToConsole("Welcome to Guess The Number Game! You'll be guessing a number between 0 and 20.");
        ConsoleUtils.printToConsole("You'll get $25 if you guess the number within 5 tries. Otherwise, you get nothing.");

        Random random = new Random();
        int randomNumber = random.nextInt(20);
        // Scanner userInput = new Scanner(System.in);
        // int guess = userInput.nextInt();
        int enteredGuess = -1;
        int numberOfGuesses = 0;

        while (enteredGuess != randomNumber && numberOfGuesses <= 5) {
            enteredGuess = ConsoleUtils.readIntegerLineFromConsoleOrElseComplainAndRetry(GuessTheNumberGame::between1And100, "Please enter a number between 0 and 20.");
            if (enteredGuess == randomNumber) {
            ConsoleUtils.printToConsole("You guessed the number! You won $25!");
            user.addBalance(25.00);
            getArcade().saveUsersToFile();
            }
            else if (enteredGuess < randomNumber) {
                ConsoleUtils.printToConsole("You are too low. You have " + (5 - numberOfGuesses) + " left. ");
                numberOfGuesses++;
            }
            else if (enteredGuess > randomNumber) {
                ConsoleUtils.printToConsole("You are too high. You have " + (5 - numberOfGuesses) + " left.");
                numberOfGuesses++;
            }
                // FileUtils.writeToFile();
            }
        getArcade().saveUsersToFile();
        getArcade().transitionArcadeState("Lobby");
    }


    public void guessTheNumber(){

    }
}
