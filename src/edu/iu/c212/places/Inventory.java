package edu.iu.c212.places;

import edu.iu.c212.Arcade;
import edu.iu.c212.models.Item;
import edu.iu.c212.models.User;
import edu.iu.c212.utils.ConsoleUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Inventory extends Place {

    public Inventory(Arcade arcade) {
        setArcade(arcade);
        setPlaceName("Inventory");
        setEntryFee(0);
    }

    @Override
    public void onEnter(User user) throws IOException, InterruptedException {
        ConsoleUtils.printToConsole("Hello, " + user.getUsername() + "! You are in the inventory. Here is what you have:");
        ConsoleUtils.printToConsole("Balance: " + user.getBalance());
        ConsoleUtils.printToConsole("Stuff: " + user.getInventory().toString());

        List<String> options = new ArrayList<>();
        options.add("Go back to Lobby");

        String decision = "";

        while (!decision.equals("Go back to Lobby")) {
            decision = ConsoleUtils.printMenuToConsole("What now?", options, true);
        }

        arcade.transitionArcadeState("Lobby");

    }
}
