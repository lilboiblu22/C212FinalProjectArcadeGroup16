package edu.iu.c212.places.games;

import edu.iu.c212.models.User;
import edu.iu.c212.utils.ConsoleUtils;
import edu.iu.c212.utils.FileUtils;
//import jdk.incubator.vector.VectorOperators;

import java.util.Random;
import java.util.Scanner;
import java.util.function.Function;

public class GuessTheNumberGame extends Game{

    @Override
    public void play() {

    }
   public static Boolean between1And100(Integer guess){
        return (guess >= 0 && guess <= 100);
    }

    @Override
    void onEnter(User user) {
      ConsoleUtils.printToConsole("Welcome to Guess The Number Game! You'll be guessing a number between 0 and 100.");
      ConsoleUtils.printToConsole("You'll get $10 if you guess the number within 5 tries. Otherwise, you get nothing.");
      Random random = new Random();
      int randomNumber = random.nextInt(100);
        Scanner userInput = new Scanner(System.in);
        int guess = userInput.nextInt();
        int enteredGuess = ConsoleUtils.readIntegerLineFromConsoleOrElseComplainAndRetry(GuessTheNumberGame::between1And100, "Please enter a number between 0 and 100.");
        if(guess == randomNumber){
            ConsoleUtils.printToConsole("You guessed the number! You won $10!");
            user.addBalance(10.00);
            FileUtils.writeToFile();
        }
    }


    public void guessTheNumber(){

    }
}
