package dev.omedia.model.query;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UserQueryModel {

    private final Long id;
    private final Long idGreaterThan;
    private final String name;

}
