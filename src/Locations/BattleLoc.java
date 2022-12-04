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
        System.out.println(obsCount+" tane "+obstacle.getName()+" gorunuyor");
        System.out.println("1. Yakinlarina git\n2. Uzaklas");
        int selCase = sc.nextInt();
        if (selCase==1){
            if (combat(obsCount)){
                System.out.println(this.name+" bolgesindeki "+obsCount+" tane "+obstacle.getName()+" olduruldu");
                //award, health
            }
        }
        return true;
    }

    public boolean combat(int obsCount){
        Game.ctrl=0;
        for (int i = 0; i <obsCount ; i++) {
            while (player.getCurrentHealth()>0 && obstacle.getHealth()>0){
                System.out.println(obstacle.getName()+"\nHasari:"+ obstacle.getDamage()+"\nCani:"+obstacle.getHealth()+"\n");
                System.out.println(player.getPlayerName()+"\nHasarin: "+player.getDamage()+"\nCanin: "
                                  +player.getCurrentHealth()+"/"+player.getMaxHealth()+"\n");
                System.out.println("1. Saldir\n2.Geri cekil");
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
                    System.out.println("4 altin kazandin");
                    player.setExp(player.getExp()+1);
                    obstacle = new Zombie();
                } else if (obstacle.getName().equals("Bear")) {
                    player.setMoney(player.getMoney()+12);
                    System.out.println("12 altin kazandin");
                    player.setExp(player.getExp()+1);
                    obstacle = new Bear();
                } else if (obstacle.getName().equals("Vampire")) {
                    player.setMoney(player.getMoney()+7);
                    System.out.println("7 altin kazandin");
                    player.setExp(player.getExp()+1);
                    obstacle = new Vampire();
                }else System.out.println("OBSTACLE URETME HATASI!!!");
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
