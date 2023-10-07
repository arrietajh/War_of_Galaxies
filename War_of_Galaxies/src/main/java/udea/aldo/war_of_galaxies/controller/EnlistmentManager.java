package udea.aldo.war_of_galaxies.controller;
import udea.aldo.war_of_galaxies.model.Superhuman;
import udea.aldo.war_of_galaxies.model.Human;
import java.util.ArrayList;
import java.util.List;
import udea.aldo.war_of_galaxies.model.Soldier;

public class EnlistmentManager {
    private List<Soldier> enlistedSoldiers;
    private List<Human> rejectedHumans;
    private List<Human> highEvilSuperhumans;
    private List<Human> allSuperhumans;

    public EnlistmentManager() {
        this.enlistedSoldiers = new ArrayList<>();
        this.rejectedHumans = new ArrayList<>();
        this.highEvilSuperhumans = new ArrayList<>();
        this.allSuperhumans = new ArrayList<>();
    }

    public void enlistHuman(Human human) {
        if (isEligible(human)) {
            Superhuman superhuman = (Superhuman) human;
            Soldier soldier = turnIntoSoldier(superhuman);
            enlistedSoldiers.add(soldier);
        } else {
            rejectedHumans.add(human);
            
        }

        if (human instanceof Superhuman) {
            Superhuman superhuman = (Superhuman) human;
            allSuperhumans.add(superhuman);

            if (superhuman.getEvilScore() > 2) {
                highEvilSuperhumans.add(superhuman);
            }
        }
    }

    private boolean isEligible(Human human) {
        return (human instanceof Superhuman) && (((Superhuman) human).getEvilScore() <= 2); //&& !((Superhuman) human).isEnemySpy()      hay que añadir este metodo mas tarde
    }
    
    public Soldier turnIntoSoldier(Superhuman superhuman) {
        // Get the base stats for Superhumans
        int baseHealth = 150;
        int baseAttack = 25; 
        int baseDefense = 25;
        int baseSpecialAttack = 25;
        int baseSpecialDefense = 25;
        int baseSpeed = 25;
        int baseWisdom = 20;

        // Initialize a Soldier using the base stats
        Soldier soldier = new Soldier(superhuman, baseHealth, baseAttack, baseDefense, baseSpecialAttack, baseSpecialDefense, baseSpeed, baseWisdom);

        // Iterate through the superpowers and modify the stats accordingly
        List<String> superpowers = superhuman.getSuperpowers();
        for (String superpower : superpowers) {
            switch (superpower) {
                case "Flight":
                    soldier.setSpeed(soldier.getSpeed()+ 15);
                    break;
                case "Super Strength":
                    soldier.setAttack(soldier.getAttack() + 20);
                    break;
                case "Enhanced Durability":
                    soldier.setDefense(soldier.getDefense() + 18);
                    break;
                case "Energy Projection":
                    soldier.setSpecialAttack(soldier.getSpecialAttack() + 20);
                    break;
                case "Telekinesis":
                    soldier.setSpecialAttack(soldier.getSpecialAttack() + 18);
                    soldier.setDefense(soldier.getDefense() + 18);
                    break;
                case "Invisibility":
                    soldier.setSpeed(soldier.getSpeed() + 12);
                    soldier.setSpecialDefense(soldier.getSpecialDefense() + 12);
                    break;
                case "Teleportation":
                    soldier.setSpeed(soldier.getSpeed() + 12);
                    soldier.setDefense(soldier.getDefense() + 15);
                    break;
                case "Regeneration":
                    soldier.setDefense(soldier.getDefense() + 10);
                    soldier.setSpecialDefense(soldier.getSpecialDefense() + 10);
                    break;
                case "Mental Manipulation":
                    soldier.setSpecialAttack(soldier.getSpecialAttack() + 18);
                    soldier.setWisdom(soldier.getWisdom() + 15);
                    break;
                case "Elemental Control":
                    soldier.setSpecialAttack(soldier.getSpecialAttack() + 22);
                    // Adjust based on the element controlled
                    break;
                case "Shapeshifting":
                    soldier.setSpecialDefense(soldier.getSpecialDefense() + 15);
                    soldier.setWisdom(soldier.getWisdom() + 12);
                    break;
                // Add cases for other superpowers and their effects on stats
                // ...
                default:
                    // Handle unknown superpowers, if needed
                    break;
            }
        }

        return soldier;
    }

    public List<Soldier> getEnlistedSoldiers() {
        return enlistedSoldiers;
    }

    public List<Human> getRejectedHumans() {
        return rejectedHumans;
    }

    public List<Human> getHighEvilSuperhumans() {
        return highEvilSuperhumans;
    }

    public List<Human> getAllSuperhumans() {
        return allSuperhumans;
    }
    
    
}
