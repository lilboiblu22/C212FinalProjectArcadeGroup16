package edu.iu.c212.places.games.blackjack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public abstract class BlackjackParticipant {
    protected int []     handTotals = new int[10];
    static List<Integer> nums = new ArrayList<Integer>(Arrays.asList(1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 6, 6, 6, 6, 7, 7, 7, 7, 8, 8, 8, 8, 9, 9, 9, 9,
            10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10));
    static Random rand = new Random();
    boolean isAOne;
    boolean bust;


    public void hit() {

    }
    public int getBestTotal() {
        if (handTotals[1] <= 21) {
            return handTotals[1];
        }
        else {
            return handTotals[0];
        }

        }
}
