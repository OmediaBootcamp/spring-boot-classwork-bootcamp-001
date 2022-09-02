package dev.omedia.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import dev.omedia.domain.Owner;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;


@Validated
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        visible = true,
        property = "type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = PersonModel.class, name = "PERSON"),
        @JsonSubTypes.Type(value = LegalEntityModel.class, name = "LEGAL_ENTITY")
})
public abstract class OwnerModel<T extends Owner> {
    protected T owner;
    protected final OwnerType type;

    protected OwnerModel(T owner, OwnerType type) {
        this.owner = owner;
        this.type = type;
    }

    public long getId() {
        return owner.getId();
    }

    @NotBlank
    @Length(max = 128)
    public String getName() {
        return owner.getName();
    }

    public void setId(long id) {
        owner.setId(id);
    }

    public void setName(String name) {
        owner.setName(name);
    }

    public Owner toOwner() {
        return this.owner;
    }

    public enum OwnerType {
        PERSON, LEGAL_ENTITY
    }
}
