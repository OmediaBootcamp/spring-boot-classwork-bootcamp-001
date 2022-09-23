package dev.omedia.repository;

import dev.omedia.domain.Audit;
import dev.omedia.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditRepository extends CrudRepository<Audit, Integer > {
}
