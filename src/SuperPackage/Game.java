package SuperPackage;

import Locations.*;

import java.util.Scanner;

public class Game {

    Player player;

    Location loc ;
    public static String location ="Safe House";
    public static int ctrl=0;   // Bu variable player'ın eve üst üste gitmesi veya bekleyerek canını yenileyememesi için kontrol amaçlı konulmuştur
                                // Eve girildiğinde ctrl arttırılır eğer battleloc'a girilirse tekrar 0 olur.
    String[] locs={"Safe House","Cave","Forest","River","Market"};  // Location la ilgili şeyler Location class'ı kullanılarak halledilmeli
                                                                    // bu şekilde array üzerinde çalışmak saçma


    public void login() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n\nWelcome to the Island");
        System.out.println("Please enter your name before struggle");
        String playerName = sc.nextLine();
        player = new Player(playerName);
        player.selectCha();
        start();

    }

    public void start(){

        System.out.print("\n========================WATER, WOOD AND FOOD==========================\n");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        System.out.print("============================EVEN THE STRONGEST ONE==============================\n");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        System.out.print("================================CAN NOT LIVE WITHOUT THEM========================\n");
        System.out.println();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        loc = new StartPoint(player);
        goWhere();

    }

    public void goWhere(){
        if (player.getCurrentHealth()>0) {  // If character is alive
            Scanner sc = new Scanner(System.in);

            System.out.println("You are at " + location);
            System.out.println("1. Go\n2. Wait");
            int fxc = sc.nextInt();

            switch (fxc) {
                case 1:
                    for (int i = 0; i < locs.length ; i++) {
                        if (!(locs[i].equals(location)))
                            System.out.println((i+1) + ". Go to " + locs[i]);
                    }
                    int plagtym = sc.nextInt();
                    locChoosen(plagtym);  // seçilen konumu locChoosen methoduna gönderir
                    break;
                case 2:
                    for (int i = 0; i < locs.length; i++) {
                        if (locs[i].equals(location)) {
                            locChoosen(i+1);// mevcut konumu locChoosen methoduna gönderir
                        }
                    }
                    break;
                default:
                    System.out.println("Please enter a valid number (1,2)");
                    goWhere();
            }
        } else  // eğer karakter hayatta değilse
            System.out.println("~~U D13D~~");
    }
    private void locChoosen(int plagtym){

        loadingS();

        switch (plagtym){
            case 1:
                loc = new SafeHouse(player);
                break;
            case 2:
                loc = new Cave(player);
                location="Cave";
                break;
            case 3:
                loc = new Forest(player);
                location="Forest";
                break;
            case 4:
                loc = new River(player);
                location="River";
                break;
            case 5:
                loc = new Market(player);
                break;
            default:
                System.out.println("LOCATİON ERROR (Game.108)");
        }
        loc.getLocation();
        goWhere();
    }

    public void loadingS(){
        for (int i = 0; i <6 ; i++) {
            System.out.print("~~~|~~~");
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
            }
        }
        System.out.println("\n");
    }

}
