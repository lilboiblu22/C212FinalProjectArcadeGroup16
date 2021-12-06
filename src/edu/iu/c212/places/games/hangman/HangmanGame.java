package edu.iu.c212.places.games.hangman;

import edu.iu.c212.Arcade;
import edu.iu.c212.models.User;
import edu.iu.c212.places.Lobby;
import edu.iu.c212.places.games.Game;
import edu.iu.c212.utils.ConsoleUtils;
import edu.iu.c212.utils.http.HttpUtils;

import java.io.IOException;
import java.util.*;

public class HangmanGame extends Game implements IHangmanGame {

    public HangmanGame(Arcade arcade) {
        setArcade(arcade);
        setPlaceName("Hangman");
        setEntryFee(10);
    }

    @Override
    public void onEnter(User user) throws IOException {
        user.removeBalance(5);
        System.out.println("Welcome to the Hangman Game!");
        System.out.println("Here are the rules:");
        System.out.println("You will guess different letters until you get the full mystery word.");
        System.out.println("You are allowed 6 incorrect guesses.");
        System.out.println("If you guess the word correctly you will earn $15.");
        System.out.println("If you enter an invalid character it will count as an incorrect guess.");
        System.out.println("Good luck! \n");

        String word = HttpUtils.getRandomHangmanWord();
        ArrayList<Character> wordInChars = new ArrayList<>();
        for(int i = 0; i < word.length(); i++){
            wordInChars.add(word.charAt(i));
        }

        boolean continueGame = true;
        int incorrectGuesses = 0;
        ArrayList<Character> guesses = new ArrayList<>();

        while(continueGame){
            System.out.println("You've guessed " + incorrectGuesses + " times incorrectly (" + guesses + ")");
            String blurredWord = getBlurredWord(guesses, word);
            System.out.print("The current word is: " + blurredWord);
            System.out.println(" Please enter a lowercase letter in the following lexicon to guess: " + getValidLexicon());
            String guessStr = ConsoleUtils.readLineFromConsole();
            char guess = guessStr.charAt(0);
            guess = Character.toLowerCase(guess);
            if(!getValidLexicon().contains(guess)){
                System.out.println("Error: Invalid guesses count as an incorrect guess");
                incorrectGuesses++;
            } else { guesses.add(guess); }
            if(!wordInChars.contains(guess)) {
                incorrectGuesses++;
            }
            if(incorrectGuesses == 6){
                System.out.println("You Lost!");
                continueGame = false;
            }
            if(word.equals(getBlurredWord(guesses, word))){
                System.out.println("Congratulations! You won with " + incorrectGuesses + " incorrect guesses, 15$ will be added to your balance.");
                user.addBalance(15);
                continueGame = false;
            }
        }
        // go to lobby
    }

    @Override
    public String getBlurredWord(List<Character> guesses, String word) {
        String blurredWord = "";
        word = word.toLowerCase(Locale.ROOT);
        for(int i = 0; i < word.length(); i ++ ){
            if(guesses.contains(word.charAt(i))){
                blurredWord = blurredWord + word.charAt(i);
            }
            else {
                blurredWord = blurredWord + '*';
            }
        }
        return blurredWord;
    }

    @Override
    public List<Character> getValidLexicon() {
        // lowercase letters = 97 - 122
        ArrayList<Character> validLexicon = new ArrayList<>();
        for(int i = 97; i < 123; i ++){
            validLexicon.add((char)i);
        }
        return validLexicon;
    }
}
