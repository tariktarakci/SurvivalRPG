package Locations;

import Obstacles.Obstacle;
import Obstacles.Zombie;
import SuperPackage.Player;

public class Cave extends BattleLoc{

    public Cave(Player player) {
        super(player, "Cave", new Zombie());
    }
}
