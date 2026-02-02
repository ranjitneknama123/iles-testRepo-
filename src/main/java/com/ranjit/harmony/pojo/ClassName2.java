package com.ranjit.harmony.pojo;

import com.sun.mail.util.LineInputStream;

import java.util.List;

public class ClassName2 {

    private List<AssociatedDrug> associatedDrugs;
    private List<AssociatedDrug2> associatedDrugs2;

    public ClassName2() {
    }

    public ClassName2(List<AssociatedDrug> associatedDrugs, List<AssociatedDrug2> associatedDrugs2) {
        this.associatedDrugs = associatedDrugs;
        this.associatedDrugs2 = associatedDrugs2;
    }

    public void setAssociatedDrugs(List<AssociatedDrug> associatedDrugs) {
        this.associatedDrugs = associatedDrugs;
    }

    public List<AssociatedDrug> getAssociatedDrugs() {
        return this.associatedDrugs;
    }

    public void setAssociatedDrugs2(List<AssociatedDrug2> associatedDrugs2) {
        this.associatedDrugs2 = associatedDrugs2;
    }

    public List<AssociatedDrug2> getAssociatedDrugs2() {
        return this.associatedDrugs2;
    }
}
