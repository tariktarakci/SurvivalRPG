package Inventory;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    public boolean water,food,firewood;
    public List<String> weapons;
    public List<String> armors ;
    public int damage,armor; // bunlar gerekli mi?

    public Inventory(){
        this.water = false;
        this.food = false;
        this.firewood = false;
        this.damage = 0;
        this.armor = 0;
        this.weapons = new ArrayList<>();
        this.armors = new ArrayList<>();
    }

}
