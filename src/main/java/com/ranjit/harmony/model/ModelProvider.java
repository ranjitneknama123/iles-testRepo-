package com.ranjit.harmony.model;

import com.ranjit.harmony.pojo.*;
import org.instancio.Instancio;
import org.instancio.Model;

import static org.instancio.Select.field;

public class ModelProvider {

    public static Model<AssociatedDrug> associateDrugModelProvider() {

        return Instancio.of(AssociatedDrug.class)
                .generate(field(AssociatedDrug::getName), gen -> gen.string().prefix("DRUG-").length(10))
                .generate(field(AssociatedDrug::getDose), gen -> gen.string().prefix("DOSE-").length(10))
                .generate(field(AssociatedDrug::getStrength), gen -> gen.string().prefix("STRENGTH-").length(10))
                .toModel();
    }

    public static Model<AssociatedDrug2> associateDrug2ModelProvider() {

        return Instancio.of(AssociatedDrug2.class)
                .generate(field(AssociatedDrug2::getName), gen -> gen.string().prefix("DRUG-").length(10))
                .generate(field(AssociatedDrug2::getDose), gen -> gen.string().prefix("DOSE-").length(10))
                .generate(field(AssociatedDrug2::getStrength), gen -> gen.string().prefix("STRENGTH-").length(10))
                .toModel();
    }
}
