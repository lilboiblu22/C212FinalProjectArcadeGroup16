package edu.iu.c212.models;

public enum Item {
    ;
    String readableName;
    double value;
    Item(String readableName, double value) {
        this.readableName = readableName;
        this.value = value;
    }

    public String getReadableName() {
        return readableName;
    }

    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
    return readableName + ": " + value;
    }


}