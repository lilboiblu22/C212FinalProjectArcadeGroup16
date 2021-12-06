package edu.iu.c212.places.games.blackjack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public abstract class BlackjackParticipant {
    protected int [] handTotals;
    static int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};
    static Random rand = new Random();
    boolean isAOne;
    boolean bust;
    int addNum;
    static boolean playerWin;

    public boolean getBust () {
        return bust;
    }

    public boolean getPlayerWin () {
        return playerWin;
    }
    public void hit() {
        int addNum = nums[rand.nextInt(nums.length)];
        // we want to add numbers to both first and second, regardless, but then add differently and show as long as second is
        if ((handTotals[0] + addNum) > 21) {
            bust = true;
        } else {

            if (addNum == 1) {
                isAOne = true;
                handTotals[0] += 1;
                handTotals[1] += 11;
            } else {
                handTotals[0] += addNum;
                handTotals[1] += addNum;
            }
            }



    }
    public int getBestTotal() {
        if (handTotals[1] >= 21) {
            return handTotals[1];
        }
        else {
            return handTotals[0];
        }

        };
}
