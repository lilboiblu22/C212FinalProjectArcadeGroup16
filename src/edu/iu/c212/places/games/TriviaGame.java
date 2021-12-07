package edu.iu.c212.places.games;

import edu.iu.c212.models.User;
import edu.iu.c212.utils.ConsoleUtils;
import edu.iu.c212.utils.http.HttpUtils;
import edu.iu.c212.utils.http.TriviaQuestion;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TriviaGame extends Game {

    @Override
    public void onEnter(User user) throws IOException, InterruptedException {
        ConsoleUtils.printToConsole("Welcome to C212 Trivia ! You'll get $2 for every correct a answer - there are 5 total questions in this trivia round.");
        List<TriviaQuestion> question = HttpUtils.getTriviaQuestions(1);
        int correctAnswerCount = 0;
        for(int i = 0; i < 5; i++){
            ConsoleUtils.printToConsole("You're on question " + (i + 1) + ". Ready?");
            Thread.sleep(1000);
            String triviaQuestion = question.get(i).getQuestion();
            String correctAnswer = question.get(i).getCorrectAnswer();
            List<String> answers = question.get(i).getIncorrectAnswers();
            answers.add(correctAnswer);
            Collections.shuffle(answers);
            String userAnswer = ConsoleUtils.printMenuToConsole(triviaQuestion, answers, true);
            assert userAnswer != null;
            if(userAnswer.equals(correctAnswer)){
                user.addBalance(2);
                ConsoleUtils.printToConsole("You got it right! You earned $2.");
                correctAnswerCount++;
            }
            else{
                ConsoleUtils.printToConsole("You got it wrong :( The correct answer is: " + correctAnswer);
            }
            if(i == 4){
                if(correctAnswerCount >= 3){
                    ConsoleUtils.printToConsole("Nice! You got " + correctAnswerCount + " questions right.");
                }
                else{
                    ConsoleUtils.printToConsole("Aww, good try. You got " + correctAnswerCount + " questions right.");

                }
            }

        }
    }


}
