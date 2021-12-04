package edu.iu.c212.places.games;

import edu.iu.c212.models.User;
import edu.iu.c212.utils.http.HttpUtils;

public class TriviaGame extends Game {


    @Override
    void onEnter(User user) {
        HttpUtils.getTriviaQuestions();
    }
}
