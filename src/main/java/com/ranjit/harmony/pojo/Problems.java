package com.ranjit.harmony.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.openqa.selenium.devtools.v136.overlay.model.LineStyle;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Problems {
    //@JsonProperty("Diabetes")
    private List<Diabetes> diabetes;
    //@JsonProperty("Asthma")
    private List<Asthma> asthmas;

    public Problems() {
    }

    public Problems(List<Diabetes> diabetes, List<Asthma> asthmas) {
        this.diabetes = diabetes;
        this.asthmas = asthmas;
    }

    public void setDiabetes(List<Diabetes> diabetes) {
        this.diabetes = diabetes;
    }

    public List<Diabetes> getDiabetes() {
        return this.diabetes;
    }

    public void setAsthmas(List<Asthma> asthmas) {
        this.asthmas = asthmas;
    }

    public List<Asthma> getAsthmas() {
        return this.asthmas;
    }

}
