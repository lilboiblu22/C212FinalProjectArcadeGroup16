package edu.iu.c212;

import edu.iu.c212.models.User;

import java.util.List;

public interface Arcade {

    List<User>getUserSaveDataFromFile();

    void saveUserDataToFile();

    void transitionArcadeState(String newPlaceNameToGoTo);

    User getCurrentUserOnArcadeEntry();


}
