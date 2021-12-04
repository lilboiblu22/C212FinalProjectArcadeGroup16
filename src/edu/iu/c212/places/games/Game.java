package edu.iu.c212.places.games;

import edu.iu.c212.places.Place;

public abstract class Game extends Place {

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public boolean isGame() {
        return super.isGame();
    }

    @Override
    public String getPlaceName() {
        return super.getPlaceName();
    }

    @Override
    public String setPlaceName() {
        return super.setPlaceName();
    }

    @Override
    public double getEntryFee() {
        return super.getEntryFee();
    }

    @Override
    public double setEntryFee() {
        return super.setEntryFee();
    }

    public abstract void play();
}
