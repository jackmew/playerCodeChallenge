package com.zestlifia.testdatastructure;

public class PlayerModel {
    private int id;
    private String name;

    public PlayerModel(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("%d: %s", id, name);
    }
}
