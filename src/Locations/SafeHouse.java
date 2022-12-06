package Locations;

import SuperPackage.Game;
import SuperPackage.Player;

public class SafeHouse extends NormalLoc{


    public SafeHouse(Player player) {
        super(player, "Safe House");
    }

        @Override
        public boolean getLocation() {
            if (Game.ctrl==0){
                Game.location = this.name;
                if (player.getExp() % 8 == 0) {
                    System.out.println("*** YOU ARE HEALED ***");
                    player.setCurrentHealth(player.getMaxHealth());
                } else if (player.getExp() == 1) {
                    System.out.println("*** YOU ARE HEALED ***");
                    player.setCurrentHealth(player.getMaxHealth());
                } else if (player.getExp() % 5 == 0) {
                    System.out.println("*** YOU ARE HEALED ***");
                    player.setCurrentHealth(player.getCurrentHealth() + (player.getMaxHealth() - player.getCurrentHealth()) / 2);
                } else if (player.getCurrentHealth() < 5) {
                    System.out.println("*** YOU ARE HEALED ***");
                    player.setCurrentHealth(player.getCurrentHealth() + (player.getMaxHealth() - player.getCurrentHealth()) / 4);
                } else if (player.getExp() % 3 == 0) {
                    System.out.println("*** YOU ARE HEALED ***");
                    player.setCurrentHealth(player.getCurrentHealth() + (player.getMaxHealth() - player.getCurrentHealth()) / 3);
                }
            }
            Game.ctrl++;
            System.out.println("Health = "+player.getCurrentHealth()+"/"+player.getMaxHealth());
            return true;
        }

}
