package edu.iu.c212.places.games.hangman;

import edu.iu.c212.models.User;

import java.io.IOException;
import java.util.*;

public interface IHangmanGame {
    String getBlurredWord(List<Character> guesses, String word);
    List<Character> getValidLexicon();
    void onEnter(User user) throws IOException, InterruptedException;

}
