package Locations;

import Obstacles.Bear;
import Obstacles.Obstacle;
import SuperPackage.Player;

public class River extends BattleLoc{

    public River(Player player) {
        super(player, "River", new Bear());
    }
}
