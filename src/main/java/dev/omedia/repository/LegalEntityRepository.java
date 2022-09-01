package dev.omedia.repository;

import dev.omedia.domain.LegalEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface LegalEntityRepository extends CustomOwnerRepository<LegalEntity> {
}
