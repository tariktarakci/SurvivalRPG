package SuperPackage;

import Locations.*;

import java.util.Scanner;

public class Game {

    Player player;

    Location loc ;
    public static String location ="Safe House";
    public static int ctrl=0;
    String[] locs={"Safe House","Cave","Forest","River","Market"};

    int ilkSefer=0;

    public void login() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n\nMacera oyununa hosgeldiniz");
        System.out.println("Oyuna baslamadan once isminizi giriniz");
        String playerName = sc.nextLine();
        player = new Player(playerName);
        player.selectCha();
        start();

    }

    public void start(){

        System.out.print("\n========================SU, ODUN VE YIYECEK BULAMAZSA==========================\n");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        System.out.print("============================EN GUCLU SAVASCI BILE==============================\n");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        System.out.print("================================HAYATTA KALAMAZ================================\n");
        System.out.println();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        loc = new StartPoint(player);
        goWhere();

    }

    public void goWhere(){
        if (player.getCurrentHealth()>0) {  // eğer karakter hayattaysa
            Scanner sc = new Scanner(System.in);

            System.out.println("Su anda " + location + " konumundasin");
            System.out.println("1. Git\n2. Bekle");
            int fxc = sc.nextInt();

            switch (fxc) {
                case 1:
                    for (int i = 0; i < locs.length ; i++) {
                        if (!(locs[i].equals(location)))
                            System.out.println((i+1) + ". " + locs[i] + " konumuna git");
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
                    System.out.println("LUTFEN GECERLİ BİR SAYİ GİRİN (1,2)");
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
                System.out.println("LOKASYON HATASI");
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
