package edu.iu.c212.places.games.blackjack;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class BlackjackParticipant {
    private static ArrayList<Integer> cards = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9,10,10,10,10));
    protected int [] handTotals;
    public void hit() {


    }
    public abstract int getBestTotal();
}
