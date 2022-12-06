package Inventory;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    public boolean water,food,firewood;
    public List<String> weapons;
    public List<String> armors ;


    public Inventory(){
        this.water = false;
        this.food = false;
        this.firewood = false;
        this.weapons = new ArrayList<>();
        this.armors = new ArrayList<>();
    }

}
