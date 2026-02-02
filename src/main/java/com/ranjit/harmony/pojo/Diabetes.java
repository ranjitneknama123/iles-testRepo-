package com.ranjit.harmony.pojo;

import java.util.List;

public class Diabetes {
    private List<Medication> medication;

    public Diabetes() {

    }

    public Diabetes(List<Medication> medication) {
        this.medication = medication;
    }

    public void setMedication(List<Medication> medication) {
        this.medication = medication;
    }

    public List<Medication> getMedication() {
        return this.medication;
    }

}
