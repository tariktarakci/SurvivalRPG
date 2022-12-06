package Locations;

import SuperPackage.Game;
import SuperPackage.Player;

import java.util.Scanner;

public class Market extends NormalLoc{

    Scanner sc = new Scanner(System.in);

    public Market(Player player) {
        super(player, "Market");
    }

    @Override
    public boolean getLocation() {

        Game.location=this.name;
        System.out.println("Kese: "+player.getMoney());
        System.out.println("1. Weaponary");
        System.out.println("2. Armors");
        System.out.println("3. Exit");
        int selTool = sc.nextInt();
        int selItemID;
        int selArmID;
        switch (selTool){
            case 1:
                selItemID=weaponMenu();
                buyWeapon(selItemID);
                break;
            case 2:
                selArmID=armorMenu();
                buyArmor(selArmID);
            default:

        }
        return true;
    }

    private int armorMenu() {                                                          // birim engelleme başı fiyat
        System.out.println("1. Light Armor  ==>    Blocking: 2      Price: 15"); // 7.5
        System.out.println("2. Mediocre Armor   ==>    Blocking: 4      Price: 25"); // 6.25
        System.out.println("3. Heavy Armor   ==>    Blocking: 7      Price: 40"); // 5.7
        System.out.println("4. Look other items");
        int selArmID = sc.nextInt();
        return selArmID;
    }
    private void buyArmor(int selArmID) {
        switch (selArmID){
            case 1:
                if (player.getMoney()>=15){
                    player.setMaxHealth(player.getMaxHealth()+2);
                    player.setCurrentHealth(player.getCurrentHealth()+2);
                    player.getInv().armors.add("Light Armor");
                    player.setMoney(player.getMoney()-15);
                    System.out.println("Pouch: "+player.getMoney());
                    System.out.println("Light Armor was added to the inventory");
                }else
                    System.out.println("You don't have enough gold");

                break;
            case 2:
                if (player.getMoney()>=25){
                    player.setMaxHealth(player.getMaxHealth()+4);
                    player.setCurrentHealth(player.getCurrentHealth()+4);
                    player.getInv().armors.add("Mediocre Armor");
                    player.setMoney(player.getMoney()-25);
                    System.out.println("Pouch: "+player.getMoney());
                    System.out.println("Mediocre Armor was added to the inventory");
                }else
                    System.out.println("You don't have enough gold");
                break;
            case 3:
                if (player.getMoney()>=40){
                    player.setMaxHealth(player.getMaxHealth()+8);
                    player.setCurrentHealth(player.getCurrentHealth()+8);
                    player.getInv().armors.add("Heavy Armor");
                    player.setMoney(player.getMoney()-40);
                    System.out.println("Pouch: "+player.getMoney());
                    System.out.println("Heavy Armor was added to the inventory");
                }else
                    System.out.println("You don't have enough gold");
                break;
            default:
                getLocation();
        }
    }


    private int weaponMenu() {
        System.out.println("1. Dagger  ==>    Damage: +2      Price: 25");
        System.out.println("2. Battle Axe    ==>    Damage: +3      Price: 35");
        System.out.println("3. Lance    ==>    Damage: +7      Price: 45");
        System.out.println("4. Look other items");
        int selWepo = sc.nextInt();
        return selWepo;
    }

    private void buyWeapon(int selItemID) {
        switch (selItemID){
            case 1:
                if (player.getMoney()>=25){
                    player.setDamage(player.getDamage()+2);
                    player.getInv().weapons.add("Dagger");
                    player.setMoney(player.getMoney()-25);
                    System.out.println("Pouch: "+player.getMoney());
                    System.out.println("Dagger was added to the inventory");
                }else
                    System.out.println("You don't have enough gold");
                break;
            case 2:
                if (player.getMoney()>=35){
                    player.setDamage(player.getDamage()+3);
                    player.getInv().weapons.add("Battle Axe");
                    player.setMoney(player.getMoney()-35);
                    System.out.println("Pouch: "+player.getMoney());
                    System.out.println("Battle Axe was added to the inventory");
                }else
                    System.out.println("You don't have enough gold");

                break;
            case 3:
                if (player.getMoney()>=45){
                    player.setDamage(player.getDamage()+7);
                    player.getInv().weapons.add("Lance");
                    player.setMoney(player.getMoney()-45);
                    System.out.println("Pouch: "+player.getMoney());
                    System.out.println("Lance was added to the inventory");
                }else
                    System.out.println("You don't have enough gold");

                break;
            default:
                getLocation();

        }
    }

}
