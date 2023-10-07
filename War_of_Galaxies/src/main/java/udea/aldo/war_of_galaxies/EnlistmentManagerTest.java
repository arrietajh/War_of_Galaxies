/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udea.aldo.war_of_galaxies;

import java.util.Arrays;
import java.util.List;
import udea.aldo.war_of_galaxies.controller.EnlistmentManager;
import udea.aldo.war_of_galaxies.model.Human;
import udea.aldo.war_of_galaxies.model.Soldier;
import udea.aldo.war_of_galaxies.model.Superhuman;


public class EnlistmentManagerTest {

    public static void main(String[] args) {
        EnlistmentManager enlistmentManager = new EnlistmentManager();

        // Creating superhuman examples
        List<String> superpowers1 = Arrays.asList("Flight", "Super Strength", "Energy Projection");
        Superhuman superhuman1 = new Superhuman(8, superpowers1, 1, 35, 0, "John Doe", "123 Main St", "Married");

        List<String> superpowers2 = Arrays.asList("Invisibility", "Teleportation", "Elemental Control");
        Superhuman superhuman2 = new Superhuman(2, superpowers2, 2, 28, 1, "Sarah Smith", "456 Elm St", "Single");

        // Creating human examples
        Human human1 = new Human(3, 42, 2, "Mike Johnson", "789 Oak St", "Divorced");
        Human human2 = new Human(4, 30, 0, "Linda Davis", "567 Pine St", "Married");

        // Enlist humans and superhumans
        enlistmentManager.enlistHuman(superhuman1);
        enlistmentManager.enlistHuman(superhuman2);
        enlistmentManager.enlistHuman(human1);
        enlistmentManager.enlistHuman(human2);

        // Display enlisted soldiers and rejected humans
        System.out.println("Enlisted Soldiers:");
        for (Soldier soldier : enlistmentManager.getEnlistedSoldiers()) {
            System.out.println(soldier);
        }

        System.out.println("\nRejected Humans:");
        for (Human human : enlistmentManager.getRejectedHumans()) {
            System.out.println(human);
        }
        
        System.out.println("\nEvil humans:");
        for (Human human : enlistmentManager.getHighEvilSuperhumans()) {
            System.out.println(human);
        }
        
        System.out.println("\nAll Superhumans:");
        for (Human human : enlistmentManager.getAllSuperhumans()) {
            System.out.println(human);
        }
        
        
    }
}
