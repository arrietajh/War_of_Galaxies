/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udea.aldo.war_of_galaxies.model;

/**
 *
 * @author aldo.camera
 */
public class Soldier {

    private Superhuman superhuman;
    private Alfi alfi;
    private int health, attack, defense, specialAttack, specialDefense, speed, wisdom;

    // Constructor Superhumano
    public Soldier(Superhuman superhuman, int health, int attack, int defense, int specialAttack, int specialDefense, int speed, int wisdom) {
        this.superhuman = superhuman;
        this.health = health;
        this.attack = attack;
        this.defense = defense;
        this.specialAttack = specialAttack;
        this.specialDefense = specialDefense;
        this.speed = speed;
        this.wisdom = wisdom;
    }

    //Constructor Alfi
    public Soldier(Alfi alfi, int health, int attack, int defense, int specialAttack, int specialDefense, int speed, int wisdom) {
        this.alfi = alfi;
        this.health = health;
        this.attack = attack;
        this.defense = defense;
        this.specialAttack = specialAttack;
        this.specialDefense = specialDefense;
        this.speed = speed;
        this.wisdom = wisdom;
    }

    public Superhuman getSuperhuman() {
        return superhuman;
    }

    public void setSuperhuman(Superhuman superhuman) {
        this.superhuman = superhuman;
    }

    public Alfi getAlfi() {
        return alfi;
    }

    public void setAlfi(Alfi alfi) {
        this.alfi = alfi;
    }

    public String getName() {
        if (superhuman != null) {
            return superhuman.getName();
        } else if (alfi != null) {
            return alfi.getName();
        }
        return "Unknown Soldier";
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getSpecialAttack() {
        return specialAttack;
    }

    public void setSpecialAttack(int specialAttack) {
        this.specialAttack = specialAttack;
    }

    public int getSpecialDefense() {
        return specialDefense;
    }

    public void setSpecialDefense(int specialDefense) {
        this.specialDefense = specialDefense;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getWisdom() {
        return wisdom;
    }

    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }

    @Override
    public String toString() {
        return "Soldier{"
                + "name='" + (superhuman != null ? superhuman.getName() : alfi.getName()) + '\''
                + ", health=" + health
                + ", attack=" + attack
                + ", defense=" + defense
                + ", specialAttack=" + specialAttack
                + ", specialDefense=" + specialDefense
                + ", speed=" + speed
                + ", wisdom=" + wisdom
                + '}';
    }

}
