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

    // Getters and Setters (if needed)

    @Override
    public String toString() {
        return "Squad{" +
                "name='" + name + '\'' +
                ", soldiers=" + soldiers +
                '}';
    }
}
