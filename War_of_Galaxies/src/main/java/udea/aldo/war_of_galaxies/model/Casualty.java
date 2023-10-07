/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udea.aldo.war_of_galaxies.model;

/**
 *
 * @author aldoc
 */
public class Casualty {
    private String soldierName;
    private String condition;

    public Casualty(String soldierName, String condition) {
        this.soldierName = soldierName;
        this.condition = condition;
    }

    public String getSoldierName() {
        return soldierName;
    }

    public String getCondition() {
        return condition;
    }
}

