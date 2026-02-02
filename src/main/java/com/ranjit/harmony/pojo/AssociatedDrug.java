package com.ranjit.harmony.pojo;

public class AssociatedDrug {


    private String name;
    private String dose;
    private String strength;

    public AssociatedDrug(){

    }

    public AssociatedDrug(String name, String dose, String strength) {
        this.name = name;
        this.dose = dose;
        this.strength = strength;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }

    public String getDose() {
        return this.dose;
    }

    public void setStrength(String strength) {
        this.strength = strength;
    }

    public String getStrength() {
        return this.strength;
    }

}
