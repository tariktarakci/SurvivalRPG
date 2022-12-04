package SuperPackage;

import Inventory.Inventory;

import java.util.Scanner;

public class Player {

    private int damage, currentHealth,money,maxHealth,exp;
    private String playerName;
    private String characterType;
    public Inventory inv;
    Scanner sc = new Scanner(System.in);

    public Player(String playerName) {
        this.playerName = playerName;
        this.inv = new Inventory();
    }

    public void selectCha(){
        switch (chaMenu()){
            case 1:
                initPlayer("Samurai",5,21,15);
                break;
            case 2:
                initPlayer("Okcu",8,16,20); // daha sonra düzenlenecek i2:20
                break;
            case 3:
                initPlayer("Sovalye",7,24,5);

                break;
            default:
                System.out.println("lUTFEN KARAKTER SECMEK ICIN 1-2-3 SAYILARINDAN BIRINI GIRIN");
                chaMenu();
        }
    }

    private void initPlayer(String charType, int i, int i1, int i2) {
        setCharacterType(charType);
        setDamage(i);
        setCurrentHealth(i1);
        setMaxHealth(i1);
        setMoney(i2);
        setExp(0);
    }

    public int chaMenu(){
        System.out.println("Lutfen bir karakter tipi secin (1,2,3)");
        System.out.println("1. Samurai\n    Hasar: 5\n    Saglik: 21\n    Para: 15 ");
        System.out.println("2. Okcu\n    Hasar: 7\n    Saglik: 18\n    Para: 20 ");
        System.out.println("3. Sovalye\n    Hasar: 8\n    Saglik: 24\n    Para: 5 ");
        int uyhguı=sc.nextInt();
        return uyhguı;
    }

    public int getExp() {return exp;}

    public void setExp(int exp) {this.exp = exp;}

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getCharacterType() {
        return characterType;
    }

    public void setCharacterType(String characterType) {
        this.characterType = characterType;
    }

    public Inventory getInv() {
        return inv;
    }

    public void setInv(Inventory inv) {
        this.inv = inv;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public String getPlayerName() {
        return playerName;
    }
}
