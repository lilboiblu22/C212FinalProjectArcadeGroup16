package edu.iu.c212.places.games.blackjack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public abstract class BlackjackParticipant {
    protected int [] handTotals = new int[10];
    static int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};
    static Random rand = new Random();
    boolean isAOne;
    boolean bust;
    int addNum;
    static boolean playerWin;

    public boolean getBust () {
        return bust;
    }

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
