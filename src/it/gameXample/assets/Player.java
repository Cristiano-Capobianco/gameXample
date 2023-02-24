package it.gameXample.assets;

public class Player {
    private String name;
    private double hp;
    private double stamina;

    public Player(String name) {
        this.name = name;
        this.hp = 100;
        this.stamina = 50;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHp() {
        return hp;
    }

    public void setHp(double hp) {
        this.hp = hp;
    }

    public double getStamina() {
        return stamina;
    }

    public void setStamina(double stamina) {
        this.stamina = stamina;
    }

    public String toString () {
        return "Nome: " + name + "\nHP: " + hp + "\nStamina " + stamina;

    }
}
