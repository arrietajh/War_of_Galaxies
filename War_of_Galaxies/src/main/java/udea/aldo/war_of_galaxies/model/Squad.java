/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udea.aldo.war_of_galaxies.model;
import java.util.ArrayList;
import java.util.List;

public class Squad {
    private String name;
    private List<Soldier> soldiers;

    // Constructor
    public Squad(String name) {
        this.name = name;
        this.soldiers = new ArrayList<>();
    }

    // Method to add a soldier to the squad
    public void addSoldier(Soldier soldier) {
        soldiers.add(soldier);
    }

    // Method to remove a soldier from the squad
    public void removeSoldier(Soldier soldier) {
        soldiers.remove(soldier);
    }
    
    public boolean noSuperhumanWithChildren() {
        for (Soldier soldier : soldiers) {
            Superhuman superhuman = soldier.getSuperhuman();
            if (superhuman != null && superhuman.getNumberOfChildren() > 0) {
                return false;
            }
        }
        return true;
    }

    public boolean noMarriedSuperhuman() {
        for (Soldier soldier : soldiers) {
            Human human = soldier.getSuperhuman();
            if (human != null && human.getMaritalStatus().equals("Married")) {
                return false;
            }
        }
        return true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Soldier> getSoldiers() {
        return soldiers;
    }

    public void setSoldiers(List<Soldier> soldiers) {
        this.soldiers = soldiers;
    }

    
    // Getters and Setters (if needed)

    @Override
    public String toString() {
        return "Squad{" +
                "name='" + name + '\'' +
                ", soldiers=" + soldiers +
                '}';
    }
}
