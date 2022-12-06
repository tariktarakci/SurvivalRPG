package Locations;

import SuperPackage.Player;

import java.util.Scanner;

public abstract class Location {

    protected Player player;
    protected String name; // Name of Location

    Location(Player player){
        this.player = player;
    }

    Location(Player player, String name){
        this.player = player;
        this.name = name;
    }

    public abstract boolean getLocation();

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
