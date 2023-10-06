package udea.aldo.war_of_galaxies.controller;
import udea.aldo.war_of_galaxies.model.Superhuman;
import udea.aldo.war_of_galaxies.model.Human;
import java.util.ArrayList;
import java.util.List;

public class EnlistmentManager {
    private List<Human> enlistedHumans;
    private List<Human> rejectedHumans;
    private List<Human> highEvilSuperhumans;
    private List<Human> allSuperhumans;

    public EnlistmentManager() {
        this.enlistedHumans = new ArrayList<>();
        this.rejectedHumans = new ArrayList<>();
        this.highEvilSuperhumans = new ArrayList<>();
        this.allSuperhumans = new ArrayList<>();
    }

    public void enlistHuman(Human human) {
        if (isEligible(human)) {
            enlistedHumans.add(human);
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
        return (human instanceof Superhuman) && (((Superhuman) human).getEvilScore() <= 2) && !((Superhuman) human).isEnemySpy();
    }

    public List<Human> getEnlistedHumans() {
        return enlistedHumans;
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
