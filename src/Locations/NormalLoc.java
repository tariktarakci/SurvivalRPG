package Locations;

import SuperPackage.Player;

import java.util.Scanner;

public abstract class NormalLoc extends Location{

    NormalLoc(Player player,String name) {
        super(player);
        this.name=name;
    }

    public boolean getLocation(){
        return true;
    }

}
