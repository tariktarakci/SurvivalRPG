package Locations;

import Obstacles.Obstacle;
import Obstacles.Vampire;
import SuperPackage.Player;

public class Forest extends BattleLoc {

    public Forest(Player player) {
        super(player,"Forest", new Vampire());
    }
}
