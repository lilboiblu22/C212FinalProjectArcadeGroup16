package edu.iu.c212;

import edu.iu.c212.models.User;
import edu.iu.c212.places.Place;

import java.io.IOException;
import java.util.List;

public interface IArcade {
    /**
     * This will call FileUtils.getUserDataFromFile, and use
     * System.exit() to exit the program if an exception is thrown.
     * @return a List of Users.
     */
    List<User> getUserSaveDataFromFile() throws IOException;

    /**
     * This should call FileUtils.writeUserDataFromFile to write all users to the txt file.
     */
    void saveUsersToFile() throws IOException;


    /**
     * Attempt to transition the currentUser to the new place.
     * @param newPlaceNameToGoTo a Place that the user wants to go.
     */
    void transitionArcadeState(String newPlaceNameToGoTo);

    /**
     * Ask for User's name on entry to the Arcade.
     * @return a User.
     */
    User getCurrentUserOnArcadeEntry();

    /**
     * Return a List of all the Places in the Arcade.
     * @return a List of Places.
     */
    List<Place> getAllPlaces();
}
