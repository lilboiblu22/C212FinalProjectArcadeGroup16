package edu.iu.c212.places;

import edu.iu.c212.models.Item;
import edu.iu.c212.models.User;
import edu.iu.c212.utils.ConsoleUtils;

import java.util.List;

public class Inventory extends Place{

    @Override
    void onEnter(User user) {
        ConsoleUtils.printToConsole("Hello, " + user.getUsername() + "! You are in the inventory. Here is what you have:");
        ConsoleUtils.printToConsole(user.getInventory().toString());

    }



}
