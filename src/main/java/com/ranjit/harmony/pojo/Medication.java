package com.ranjit.harmony.pojo;

import java.util.List;

public class Medication {
    private List<MedicationsClasses> medicationsClasses;

    public Medication() {
    }

    public Medication(List<MedicationsClasses> medicationsClasses) {
        this.medicationsClasses = medicationsClasses;
    }

    public void setMedicationsClasses(List<MedicationsClasses> medicationsClasses) {
        this.medicationsClasses = medicationsClasses;
    }

    public List<MedicationsClasses> getMedicationsClasses() {
        return medicationsClasses;
    }

}
