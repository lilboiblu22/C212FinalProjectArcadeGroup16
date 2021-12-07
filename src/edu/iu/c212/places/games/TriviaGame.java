package edu.iu.c212.places.games;

import edu.iu.c212.Arcade;
import edu.iu.c212.models.User;
import edu.iu.c212.utils.ConsoleUtils;
import edu.iu.c212.utils.http.HttpUtils;

public class TriviaGame extends Game {

    public TriviaGame(Arcade arcade) {
        setArcade(arcade);
        setPlaceName("Trivia Game");
        setEntryFee(10);
    }

    @Override
    public void onEnter(User user) {
        ConsoleUtils.printToConsole("Welcome to C2112 Trivia ! You'll get $2 for every correct a answer - there are 5 total questions in this trivia round.");

        ConsoleUtils.printToConsole("Let's get started!");
        try {
            Thread.sleep(1000);

    }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        ConsoleUtils.printToConsole(HttpUtils.getTriviaQuestions(5));
        ConsoleUtils.printToConsole(HttpUtils.getTriviaAnswers(5));


    }

}
