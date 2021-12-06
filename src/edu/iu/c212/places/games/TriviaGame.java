package edu.iu.c212.places.games;

import edu.iu.c212.models.User;
import edu.iu.c212.utils.ConsoleUtils;
import edu.iu.c212.utils.http.HttpUtils;

public class TriviaGame extends Game {


    @Override
    public void play() {

    }

    @Override
    void onEnter(User user) {
        ConsoleUtils.printToConsole("Welcome to C2112 Trivia ! You'll get $2 for every correct a answer - there are 5 total questions in this trivia round.");
        ConsoleUtils.printToConsole("You're on question 1. Ready?");
       ConsoleUtils.printMenuToConsole(HttpUtils.getTriviaQuestions(5));
    }


}
