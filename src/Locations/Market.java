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
        System.out.println("1. Silahlar");
        System.out.println("2. Zirhlar");
        System.out.println("3. Cikis");
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
        System.out.println("1. Hafif zirh  ==>    Hasar engelleme: 2      Fiyat: 15"); // 7.5
        System.out.println("2. Orta zirh   ==>    Hasar engelleme: 4      Fiyat: 25"); // 6.25
        System.out.println("3. Agir zirh   ==>    Hasar engelleme: 7      Fiyat: 40"); // 5.7
        System.out.println("4. Marketteki diger esyalara bak");
        int selArmID = sc.nextInt();
        return selArmID;
    }
    private void buyArmor(int selArmID) {
        switch (selArmID){
            case 1:
                if (player.getMoney()>=15){
                    player.setMaxHealth(player.getMaxHealth()+2);
                    player.setCurrentHealth(player.getCurrentHealth()+2);
                    player.getInv().armors.add("Hafif zirh");
                    player.setMoney(player.getMoney()-15);
                    System.out.println("Kese: "+player.getMoney());
                    System.out.println("Hafif zirh envanterine eklendi");
                }else
                    System.out.println("Paran yetersiz");

                break;
            case 2:
                if (player.getMoney()>=25){
                    player.setMaxHealth(player.getMaxHealth()+4);
                    player.setCurrentHealth(player.getCurrentHealth()+4);
                    player.getInv().armors.add("Orta zirh");
                    player.setMoney(player.getMoney()-25);
                    System.out.println("Kese: "+player.getMoney());
                    System.out.println("Orta zirh envanterine eklendi");
                }else
                    System.out.println("Paran yetersiz");
                break;
            case 3:
                if (player.getMoney()>=40){
                    player.setMaxHealth(player.getMaxHealth()+8);
                    player.setCurrentHealth(player.getCurrentHealth()+8);
                    player.getInv().armors.add("Agir zirh");
                    player.setMoney(player.getMoney()-40);
                    System.out.println("Kese: "+player.getMoney());
                    System.out.println("Agir zirh envanterine eklendi");
                }else
                    System.out.println("Paran yetersiz");
                break;
            default:
                getLocation();
        }
    }


    private int weaponMenu() {
        System.out.println("1. Tabanca  ==>    Hasar: +2      Fiyat: 25");
        System.out.println("2. Kilic    ==>    Hasar: +3      Fiyat: 35");
        System.out.println("3. Tufek    ==>    Hasar: +7      Fiyat: 45");
        System.out.println("4. Marketteki diger esyalara bak");
        int selWepo = sc.nextInt();
        return selWepo;
    }

    private void buyWeapon(int selItemID) {
        switch (selItemID){
            case 1:
                if (player.getMoney()>=25){
                    player.setDamage(player.getDamage()+2);
                    player.getInv().weapons.add("Tabanca");
                    player.setMoney(player.getMoney()-25);
                    System.out.println("Kese: "+player.getMoney());
                    System.out.println("Tabanca envanterine eklendi");
                }else
                    System.out.println("Paran yetersiz");
                break;
            case 2:
                if (player.getMoney()>=35){
                    player.setDamage(player.getDamage()+3);
                    player.getInv().weapons.add("Kilic");
                    player.setMoney(player.getMoney()-35);
                    System.out.println("Kese: "+player.getMoney());
                    System.out.println("Kilic envanterine eklendi");
                }else
                    System.out.println("Paran yetersiz");

                break;
            case 3:
                if (player.getMoney()>=45){
                    player.setDamage(player.getDamage()+7);
                    player.getInv().weapons.add("Tufek");
                    player.setMoney(player.getMoney()-45);
                    System.out.println("Kese: "+player.getMoney());
                    System.out.println("Tufek envanterine eklendi");
                }else
                    System.out.println("Paran yetersiz");

                break;
            default:
                getLocation();

        }
    }

}
