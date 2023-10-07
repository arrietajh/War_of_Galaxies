/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udea.aldo.war_of_galaxies.controller;

import java.util.List;
import udea.aldo.war_of_galaxies.model.BattleLog;
import udea.aldo.war_of_galaxies.model.Casualty;

/**
 *
 * @author aldoc
 */
public class ReportManager {
    
    public String generateCasualtyReport(BattleSimulation battleSimulation) {
        StringBuilder reportBuilder = new StringBuilder();

        // Iterate through the collected casualties
        for (Casualty casualty : battleSimulation.getBattleCasualties()) {
            reportBuilder.append("Casualty: ")
                         .append(casualty.getSoldierName())
                         .append(", ")
                         .append(casualty.getCondition())
                         .append("\n");
        }

        // Check if there were no casualties
        if (reportBuilder.length() == 0) {
            reportBuilder.append("No casualties in this battle.\n");
        }

        return reportBuilder.toString();
    }

    public class BattleReportGenerator {

    public String generateBattleReport(List<BattleLog> battleLogs) {
        StringBuilder report = new StringBuilder("Battle Report\n\n");

        // Append each battle log entry to the report
        for (BattleLog log : battleLogs) {
            report.append(log.getLogEntry()).append("\n");
        }

        return report.toString();
    }
}

    
       
}

    
    
    
    

