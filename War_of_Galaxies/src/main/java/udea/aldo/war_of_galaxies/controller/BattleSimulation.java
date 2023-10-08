/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udea.aldo.war_of_galaxies.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import udea.aldo.war_of_galaxies.model.BattleLog;
import udea.aldo.war_of_galaxies.model.Casualty;
import udea.aldo.war_of_galaxies.model.Soldier;
import udea.aldo.war_of_galaxies.model.Squad;

/**
 *
 * @author aldoc
 */
public class BattleSimulation {

    private List<Casualty> casualties;  // list to store casualties
    private List<BattleLog> battleLogs; // list to store battleLogs

    public BattleSimulation() {
        casualties = new ArrayList<>();
        battleLogs = new ArrayList<>();

    }

    public List<Casualty> getBattleCasualties() {
        return casualties;
    }

    public List<BattleLog> getBattleLogs() {
        return battleLogs;
    }

    public Squad simulateGalacticWar(Squad firstSquad, Squad secondSquad, Squad alfiSquad) {

        if (simulateAutoSquadBattle(firstSquad, alfiSquad) == firstSquad) //Checks if the first human squad won
        {
            battleLogs.add(new BattleLog("\n El primer escuadrón ha ganado, la humanidad ha triunfado."));
            return firstSquad;
        } else if (simulateAutoSquadBattle(secondSquad, alfiSquad) == secondSquad) //Checks if the second human squad won
        {
            battleLogs.add(new BattleLog("\n El segundo escuadrón ha ganado, la humanidad ha triungado."));
            return secondSquad;
        } else { //If neither of them won... then that means the humans lost and the alfiSquad has won the war
            battleLogs.add(new BattleLog("\n Ambos escuadrones superhumanos han sido erradicados. La humanidad será exterminada"));
            return alfiSquad;
        }

    }

    public Squad simulateAutoSquadBattle(Squad humanSquad, Squad alfiSquad) {
        Soldier slowSoldier;
        Soldier fastSoldier;

        Iterator<Soldier> humanIterator = humanSquad.getSoldiers().iterator();
        Iterator<Soldier> alfiIterator = alfiSquad.getSoldiers().iterator();

        //While both squads have remaining soldiers...
        while (humanIterator.hasNext() && alfiIterator.hasNext()) {
            //PREPARATION PHASE. We determine who te faster soldier is~
            fastSoldier = determineFirstAttacker(humanSquad.getSoldiers().get(0), alfiSquad.getSoldiers().get(0));
            slowSoldier = determineSecondAttacker(humanSquad.getSoldiers().get(0), alfiSquad.getSoldiers().get(0));

            battleLogs.add(new BattleLog(fastSoldier.getName() + " va a luchar contra: " + slowSoldier.getName() + " " + fastSoldier.getName() + " toma la delantera \n"));
//We determine which kind of attack is best for each of our soldiers
            String attackTypeFast = determineAttackType(fastSoldier);//Determine Attack Type for fast soldier
            battleLogs.add(new BattleLog(fastSoldier.getName() + " se especializa en: " + attackTypeFast));
            String attackTypeSlow = determineAttackType(slowSoldier);//Determine Attack Type for slow soldier
            battleLogs.add(new BattleLog(slowSoldier.getName() + " se especializa en: " + attackTypeSlow + "\n"));

            //ATTACK PHASE. Soldiers will attack each other until one loses
            while (checkAttackPhaseEnd(fastSoldier, slowSoldier) == true) {
                performAttack(fastSoldier, slowSoldier, attackTypeFast);//fast soldier attacks

                battleLogs.add(new BattleLog(fastSoldier.getName() + " ha usado " + attackTypeFast + " en " + slowSoldier.getName()));
                if (slowSoldier.getHealth() <= 0 || slowSoldier.getWisdom() <= 0) //Did slow soldier lose? This is to prevent slowSoldier from attacking while they are dead
                {
                    break;
                }
                performAttack(slowSoldier, fastSoldier, attackTypeSlow);//slow soldier attacks
                battleLogs.add(new BattleLog(slowSoldier.getName() + "ha usado" + attackTypeSlow + " en " + fastSoldier.getName()));
            }

            //POST ATTACK PHASE. Check which squad lost a soldier. That soldier is removed from the Squad
            if (humanSquad.getSoldiers().get(0).getHealth() <= 0 || humanSquad.getSoldiers().get(0).getWisdom() <= 0) {
                casualties.add(new Casualty(humanSquad.getSoldiers().get(0).getName(), "Defeated"));
                battleLogs.add(new BattleLog("\n" + humanSquad.getSoldiers().get(0).getName() + "no puede continuar"));
                humanSquad.getSoldiers().remove(0);
            } else if (alfiSquad.getSoldiers().get(0).getHealth() <= 0 || alfiSquad.getSoldiers().get(0).getWisdom() <= 0) {
                casualties.add(new Casualty(alfiSquad.getSoldiers().get(0).getName(), "Defeated"));

                battleLogs.add(new BattleLog("\n" + alfiSquad.getSoldiers().get(0).getName() + " no puede continuar"));
                alfiSquad.getSoldiers().remove(0);
            }
            //This continues until one squad runs out of soldiers
        }

        if (humanSquad.getSoldiers().isEmpty() == true) {
            battleLogs.add(new BattleLog(" The Alfi have won this encounter"));
            return alfiSquad;
        } else {
            battleLogs.add(new BattleLog(" The humans have won this encounter"));

            return humanSquad;
        }
    }

    private Soldier determineFirstAttacker(Soldier soldier1, Soldier soldier2) {

        //If soldier 1's speed is higher than or equal to soldier 2's, return soldier 1, otherwise, return soldier 2
        if (soldier1.getSpeed() >= soldier2.getSpeed()) {
            return soldier1;
        } else {
            return soldier2;
        }

    }

    private Soldier determineSecondAttacker(Soldier soldier1, Soldier soldier2) {

        //If soldier 1's speed is higher than or equal to soldier 2's, return soldier 2, otherwise, return soldier 1
        if (soldier1.getSpeed() >= soldier2.getSpeed()) {
            return soldier2;
        } else {
            return soldier1;
        }

    }

    private String determineAttackType(Soldier soldier) {
        int attackStat = soldier.getAttack();
        int specialAttackStat = soldier.getSpecialAttack();
        int wisdomStat = soldier.getWisdom();

        if (attackStat >= specialAttackStat && attackStat >= wisdomStat) {
            return "Normal Attack";
        } else if (specialAttackStat >= attackStat && specialAttackStat >= wisdomStat) {
            return "Special Attack";
        } else {
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

    private boolean checkAttackPhaseEnd(Soldier soldier1, Soldier soldier2) {

        return soldier1.getHealth() > 0 && soldier2.getHealth() > 0 && soldier1.getWisdom() > 0 && soldier2.getWisdom() > 0;
    }

}
