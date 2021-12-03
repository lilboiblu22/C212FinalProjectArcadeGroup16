package edu.iu.c212.utils;

import edu.iu.c212.models.*;

import java.io.*;
import java.util.*;

public class FileUtils {
    private static File file = new File("/src/edu.iu.c212/userInfo.txt");

    // line format:
    // user_name|balance|item1,item2,item3
    // user name not allowed to contain pipe

    /**
     * Write user data to the file you provided above.
     *
     * @param users The total list of all users
     */
    public static void writeUserDataToFile(List<User> users) throws IOException {
        FileWriter writeUserInfo = new FileWriter("/src/edu.iu.c212/userInfo.txt", true);
        for (User user : users) {
            writeUserInfo.write(String.valueOf(user));
            //this probably need more work
        }
    }

    /**
     * Read user data from the file you provided above. Return a list of Users
     */
    public static List<User> getUserDataFromFile() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("/src/edu.iu.c212/userInfo.txt"));
        String line = reader.readLine();
        List<String> stringVersion = new ArrayList<>();
        List<User> users = new ArrayList<>();
        while(line != null){
            stringVersion.add(line);
            String[] temp = line.split("\\|");
            User newUser = new User();
            newUser.setUsername(temp[0]);
            newUser.setBalance(Double.parseDouble(temp[1]));
            String[] items = temp[2].split("\\|");
            for(String item : items){
                newUser.addItem(Item.valueOf(item));
                //Item.ITEM_ONE.name(); ???
            }
            users.add(newUser);
            line = reader.readLine();
        }
        return users;
    }
}
