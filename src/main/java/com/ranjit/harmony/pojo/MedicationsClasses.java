package com.ranjit.harmony.pojo;

import java.util.List;

public class MedicationsClasses {

    private List<ClassName> className;
    private List<ClassName2> className2;

    public MedicationsClasses() {
    }

    public MedicationsClasses(List<ClassName> className, List<ClassName2> className2) {
        this.className = className;
        this.className2 = className2;
    }

    public void setClassName(List<ClassName> className) {
        this.className = className;
    }

    public List<ClassName> getClassName() {
        return className;
    }

    public void setClassName2(List<ClassName2> className2) {
        this.className2 = className2;
    }

    public List<ClassName2> getClassName2() {
        return className2;
    }
}
