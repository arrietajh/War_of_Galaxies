/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udea.aldo.war_of_galaxies.model;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author aldo.camera
 */
public class Superhuman extends Human
{
    
    private int evilScore;
    private List<String> superpowers;

    public Superhuman(List<String> superpowers, int id, int age, int numberOfChildren, String name, String address, String maritalStatus) {
        super(id, age, numberOfChildren, name, address, maritalStatus);
        this.superpowers = new ArrayList<>();
    }

    public Superhuman(int evilScore, List<String> superpowers, int id, int age, int numberOfChildren, String name, String address, String maritalStatus) {
        super(id, age, numberOfChildren, name, address, maritalStatus);
        this.evilScore = evilScore;
        this.superpowers = superpowers;
    }

    

    // Method to add a superpower
    public void addSuperpower(String superpower) {
        superpowers.add(superpower);
    }

    public int getEvilScore() {
        return evilScore;
    }

    public void setEvilScore(int evilScore) {
        this.evilScore = evilScore;
    }

    public List<String> getSuperpowers() {
        return superpowers;
    }

    public void setSuperpowers(List<String> superpowers) {
        this.superpowers = superpowers;
    }

    @Override
    public String toString() {
        return "Superhuman{" +
                "name='" + getName() + '\'' +
                ", age=" + getAge() +
                ", id=" + getId() +
                ", numberOfChildren=" + getNumberOfChildren() +
                ", maritalStatus='" + getMaritalStatus() + '\'' +
                ", address='" + getAddress() + '\'' +
                ", superpowers=" + superpowers +
                '}';
    }
    
}
