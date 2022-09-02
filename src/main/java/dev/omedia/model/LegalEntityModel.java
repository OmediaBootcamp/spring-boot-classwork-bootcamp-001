package dev.omedia.model;

import dev.omedia.domain.LegalEntity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class LegalEntityModel extends OwnerModel<LegalEntity> {

    public LegalEntityModel() {
        this(new LegalEntity());
    }

    public LegalEntityModel(LegalEntity owner) {
        super(owner, OwnerType.LEGAL_ENTITY);
    }

    @NotNull
    @Pattern(regexp = "[0-2]")
    public String getEntityNo() {
        return owner.getEntityNo();
    }

    public String getIndustry() {
        return owner.getIndustry();
    }

    public void setEntityNo(String entityNo) {
        owner.setEntityNo(entityNo);
    }

    public void setIndustry(String industry) {
        owner.setIndustry(industry);
    }
}
