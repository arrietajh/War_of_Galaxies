/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udea.aldo.war_of_galaxies.controller;

import udea.aldo.war_of_galaxies.model.Soldier;
import udea.aldo.war_of_galaxies.model.Squad;

/**
 *
 * @author aldoc
 */
public class BattleSimulation {
    private Squad firstSquad;
    private Squad secondSquad;

    public BattleSimulation(Squad firstSquad, Squad secondSquad) {
        this.firstSquad = firstSquad;
        this.secondSquad = secondSquad;
    }

    public void startBattle() 
    {
        
        // TODO: Implement battle flow
    
    
    }

    private Soldier determineFirstAttacker(Squad squad) {
        // TODO: Implement determining the first attacker
        return null;
    }

    private String determineAttackType(Soldier soldier) {
        // TODO: Implement determining the attack type
        return null;
    }

    private void performAttack(Soldier attacker, Soldier defender, String attackType) {
        // TODO: Implement performing the attack
    }

    private boolean checkBattleEnd() {
        // TODO: Implement checking for battle end
        return false;
    }

    private Soldier getNextAliveSoldier(Squad squad) {
        // TODO: Implement getting the next alive soldier
        return null;
    }
}

