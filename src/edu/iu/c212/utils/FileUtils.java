package edu.iu.c212.utils;

import edu.iu.c212.models.Item;
import edu.iu.c212.models.User;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileUtils {
    private static final File file = new File("TextFiles/SaveData.txt");

    // line format:
    // user_name|balance|item1,item2,item3
    // user name not allowed to contain pipe

    /**
     * Write user data to the file you provided above.
     *
     * @param users The total list of all users
     */
    public static void writeUserDataToFile(List<User> users) throws IOException {
       try {
           PrintWriter out = new PrintWriter(file);
           for (User user : users) {
               out.println(user.getUsername() +
                       "|" + user.getBalance() +
                       "|" + user.getInventory().toString());
           }
       }
       catch (IOException e) {
           System.out.println("Error writing to file");
       }
    }

    /**
     * Read user data from the file you provided above. Return a list of Users
     */
    public static List<User> getUserDataFromFile() throws IOException {
      try {
        List<User> users = new ArrayList<User>();
        Scanner in = new Scanner(file);
        while (in.hasNextLine()) {
            // line format:
            // user_name|balance|item1,item2,item3
            // (1) break up the line into name, balance, items
            String[] line = in.nextLine().split("\\|");
            User user = new User();
            user.setUsername(line[0]);
            user.setBalance(Double.parseDouble(line[1]));
            // items are stored like Name0: Price0, Name1: Price1, etc...
            // (2) break item information up into name and price
            String[] items = line[2].split(",");
            List<Item> listOfItems = new ArrayList<Item>();
            for (String s : items) {
                // each s will look like...
                // name1: 2.0
                // name2: 3.0
                // etc...
                String[] item = s.split(":");
                // name1
                // 2.0
                // just need the name...
                Item enumItem = switch (item[0]) {
                    case "name1" -> Item.ITEM_ONE;
                    case "name2" -> Item.ITEM_TWO;
                    case "name3" -> Item.ITEM_THREE;
                    case "name4" -> Item.ITEM_FOUR;
                    case "name5" -> Item.ITEM_FIVE;
                    case "name6" -> Item.ITEM_SIX;
                    case "name7" -> Item.ITEM_SEVEN;
                    case "name8" -> Item.ITEM_EIGHT;
                    case "name9" -> Item.ITEM_NINE;
                    case "name10" -> Item.ITEM_TEN;
                    default -> null;
                };
                listOfItems.add(enumItem);
            }
            user.setInventory(listOfItems);
        }
        return users;
    }
    catch (IOException e) {
        System.out.println("Error reading from file");
         }
        return null;
    }
}