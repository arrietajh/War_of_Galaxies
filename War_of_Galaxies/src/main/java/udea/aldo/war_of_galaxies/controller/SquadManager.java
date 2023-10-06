/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udea.aldo.war_of_galaxies.controller;

/**
 *
 * @author aldoc
 */
import java.util.ArrayList;
import java.util.List;
import udea.aldo.war_of_galaxies.model.Squad;

public class SquadManager {
    private List<Squad> squads;

    public SquadManager() {
        this.squads = new ArrayList<>();
    }

    public void addSquad(Squad squad) {
        squads.add(squad);
    }

    public boolean isEligible(Squad squad) {
        // Check squad eligibility based on criteria
        // (number of soldiers, soldier types, etc.)
        int numSoldiers = squad.getSoldiers().size();
        return numSoldiers >= 10 && numSoldiers <= 15; //In the future, the app could allow for creating Alfi as well, we could implement a  && squad.isSameTypeOfSoldiers() method. Just a thought
    }

    public boolean isEligibleAsFirstSquad(Squad squad) {
        // Check eligibility as the first squad based on criteria
        // (no superhumans with children, no married superhumans, etc.)
        
        
        return isEligible(squad) && squad.noSuperhumanWithChildren() && squad.noMarriedSuperhuman();
    }
    
    




}
