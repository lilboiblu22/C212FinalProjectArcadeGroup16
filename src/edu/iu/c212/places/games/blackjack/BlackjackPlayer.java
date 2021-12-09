package edu.iu.c212.places.games.blackjack;

import java.util.Arrays;

public class BlackjackPlayer extends BlackjackParticipant {
    public boolean playerBust;
    protected int []handTotals = new int[10];
    public boolean getBust() {
        return playerBust;
    }
    public BlackjackPlayer() {
        hit();
        hit();
    }
    @Override
    public int getBestTotal() {
        if (handTotals[1] <= 21) {
            return handTotals[1];
        }
        else {
            return handTotals[0];
        }

    }


    @Override
    public void hit() {
        int addNum = nums.get(rand.nextInt(nums.size()));
        nums.remove(addNum);
        if ((handTotals[0] + addNum) > 21) {
            playerBust = true;
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
    }

