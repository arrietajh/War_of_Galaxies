/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udea.aldo.war_of_galaxies.model;

/**
 *
 * @author aldo.camera
 */
public class Human {

    private String name;
    private int id;
    private int age;
    private int numberOfChildren;
    private String maritalStatus;
    private String address;

    public Human(int id, int age, int numberOfChildren, String name, String address, String maritalStatus) {
        this.id = id;
        this.age = age;
        this.numberOfChildren = numberOfChildren;
        this.name = name;
        this.address = address;
        this.maritalStatus = maritalStatus;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getNumberOfChildren() {
        return numberOfChildren;
    }

    public void setNumberOfChildren(int numberOfChildren) {
        this.numberOfChildren = numberOfChildren;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    @Override
    public String toString() {
        return "Human{" + "name=" + name + ", id=" + id + ", age=" + age + ", numberOfChildren=" + numberOfChildren + ", maritalStatus=" + maritalStatus + ", address=" + address + '}';
    }

}
