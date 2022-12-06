package Locations;

import Obstacles.Bear;
import Obstacles.Obstacle;
import Obstacles.Vampire;
import Obstacles.Zombie;
import SuperPackage.Game;
import SuperPackage.Player;

import java.util.Scanner;

public abstract class BattleLoc extends Location{

    protected Obstacle obstacle;
    Scanner sc = new Scanner(System.in);

    BattleLoc(Player player,String name,Obstacle obstacle){
        super(player);
        this.name=name;
        this.obstacle=obstacle;
    }

    @Override
    public boolean getLocation() {
        Game.location =this.name;
        int obsCount = obstacle.count(); // obsCount: oyuncunun karşısına çıkan canavar sayısı
        Game.location = this.name;
        System.out.println(obsCount+" "+obstacle.getName()+" appaered");
        System.out.println("1. Go near\n2. Walk away");
        int selCase = sc.nextInt();
        if (selCase==1){
            if (combat(obsCount)){
                if (obsCount==1) {
                    System.out.println(obsCount + " " + obstacle.getName() + " is killed at " + this.name);
                }else{
                    System.out.println(obsCount + " " + obstacle.getName() + "s are killed at " + this.name);
                }
                //award, health
            }
        }
        return true;
    }

    public boolean combat(int obsCount){
        Game.ctrl=0;
        for (int i = 0; i <obsCount ; i++) {
            while (player.getCurrentHealth()>0 && obstacle.getHealth()>0){
                System.out.println(obstacle.getName()+"\nAttack Damage:"+ obstacle.getDamage()+"\nIt's Health:"+obstacle.getHealth()+"\n");
                System.out.println(player.getPlayerName()+"\nYour Attack Damage: "+player.getDamage()+"\nYour Health: "
                                  +player.getCurrentHealth()+"/"+player.getMaxHealth()+"\n");
                System.out.println("1. Attack\n2. Back off");
                int didAttack=sc.nextInt();
                if (didAttack==1){
                    obstacle.setHealth(obstacle.getHealth()-player.getDamage());
                    if (obstacle.getHealth()>0){
                        player.setCurrentHealth(player.getCurrentHealth()-obstacle.getDamage());
                    }
                } else if (didAttack==2) {
                    break;
                } else combat(obsCount);
            }
            if (obstacle.getHealth()<=0 && player.getCurrentHealth()>0 ){
                if (obstacle.getName().equals("Zombie")){
                    player.setMoney(player.getMoney()+4);
                    System.out.println("You gain 4 gold");
                    player.setExp(player.getExp()+1);
                    obstacle = new Zombie();
                } else if (obstacle.getName().equals("Bear")) {
                    player.setMoney(player.getMoney()+12);
                    System.out.println("You gain 12 gold");
                    player.setExp(player.getExp()+1);
                    obstacle = new Bear();
                } else if (obstacle.getName().equals("Vampire")) {
                    player.setMoney(player.getMoney()+7);
                    System.out.println("You gain 7 gold");
                    player.setExp(player.getExp()+1);
                    obstacle = new Vampire();
                }else System.out.println("OBSTACLE GENERATING EXCEPTION!!!(BattleLoc.78)");
            } else {
                break;
            }


        }

        boolean isAlive;
        if (player.getCurrentHealth()>0)
            isAlive=true;
        else
            isAlive=false;
        return isAlive;
    }

}
