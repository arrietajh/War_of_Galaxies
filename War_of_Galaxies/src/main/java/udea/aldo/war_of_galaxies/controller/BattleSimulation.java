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
    private Squad alfiSquad;
    
    public BattleSimulation(Squad firstSquad, Squad secondSquad, Squad alfiSquad) {
        this.firstSquad = firstSquad;
        this.secondSquad = secondSquad;
        this.alfiSquad = alfiSquad;
    }

    public void startBattle(Squad firstSquad, Squad secondSquad, Squad alfiSquad) 
    {
        Soldier slowSoldier;
        Soldier fastSoldier;
        
        
        fastSoldier = determineFirstAttacker(firstSquad.getSoldiers().get(0) , alfiSquad.getSoldiers().get(0));
        if (fastSoldier == firstSquad.getSoldiers().get(0))
        {
            slowSoldier = alfiSquad.getSoldiers().get(0);
        }
        else 
        {
            slowSoldier = firstSquad.getSoldiers().get(0);
        }
        // TODO: Implement battle flow
        
        String attackTypeFast = determineAttackType(fastSoldier);//Determine Attack Type for fast soldier
        String attackTypeSlow= determineAttackType(slowSoldier);//Determine Attack Type for slow soldier
        
        
        while(fastSoldier.getHealth()>0 && slowSoldier.getHealth()> 0) //while soldier health != 0
        {
            performAttack(fastSoldier, slowSoldier, attackTypeFast);//fast soldier attacks
            if(slowSoldier.getHealth() <= 0)
            {
                break;
            } //Did slow soldier die? If yes, break If not:
            performAttack(slowSoldier, fastSoldier, attackTypeSlow);//slow soldier attacks
            
        }
            
        
        //When any soldier dies, the cycle ends
    
    
    }

    /*private boolean fasterThan(Soldier soldier1, Soldier soldier2)
    {
        return soldier1.getSpeed() >= soldier2.getSpeed();
    } */ // This the method for comparing two soldiers, might be scrapped
    
    private Soldier determineFirstAttacker(Soldier soldier1, Soldier soldier2) {
        
        //If soldier 1's speed is higher than or equal to soldier 2's, return soldier 1, otherwise, return soldier 2
        if(soldier1.getSpeed() >= soldier2.getSpeed())
        {
            return soldier1;
        }
        else
        {
            return soldier2;
        }
        
    }

    private String determineAttackType(Soldier soldier) 
    {
        int attackStat = soldier.getAttack();
        int specialAttackStat = soldier.getSpecialAttack();
        int wisdomStat = soldier.getWisdom();

        if (attackStat >= specialAttackStat && attackStat >= wisdomStat) {
            return "Normal Attack";
    }   else if (specialAttackStat >= attackStat && specialAttackStat >= wisdomStat) {
            return "Special Attack";
    }   else {
            return "Wisdom Attack";
    }
          
    }

    private void performAttack(Soldier attacker, Soldier target, String attackType) {
    int damage;
    int minDamage = 1;  // Minimum damage to ensure at least 1 damage

    switch (attackType) {
        case "Normal Attack":
            damage = Math.max(attacker.getAttack() - target.getDefense(), minDamage);
            target.setHealth(target.getHealth() - damage);
            break;
        case "Special Attack":
            damage = Math.max(attacker.getSpecialAttack() - target.getSpecialDefense(), minDamage);
            target.setHealth(target.getHealth() - damage);
            break;
        case "Wisdom Attack":
            damage = Math.max(attacker.getWisdom(), minDamage);
            target.setWisdom(target.getWisdom() - damage);
            break;
        default:
            // Handle any additional attack types
            break;
    }
}


    private boolean checkBattleEnd() {
        // TODO: Implement checking for battle end
        return false;
    }

    private Soldier getNextAliveSoldier(Squad squad) {
        // TODO: Implement getting the next alive soldier
        return null;
    }

    public Squad getFirstSquad() {
        return firstSquad;
    }

    public void setFirstSquad(Squad firstSquad) {
        this.firstSquad = firstSquad;
    }

    public Squad getSecondSquad() {
        return secondSquad;
    }

    public void setSecondSquad(Squad secondSquad) {
        this.secondSquad = secondSquad;
    }

    public Squad getAlfiSquad() {
        return alfiSquad;
    }

    public void setAlfiSquad(Squad alfiSquad) {
        this.alfiSquad = alfiSquad;
    }
    
    

}

