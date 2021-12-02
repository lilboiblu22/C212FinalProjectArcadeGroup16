package edu.iu.c212.places;

import edu.iu.c212.models.User;

public class Lobby extends Place{
    @Override
    void onEnter(User user) {
        System.out.println("Welcome to the Lobby " + user.getUsername() + "!" + "\n" + "You are currently in the Lobby. Your Balance is: " + user.getBalance());
            //System.out.println(arcade.getAllPlaces());

    }
}
