package dev.omedia.repository;

import dev.omedia.domain.Owner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface CustomOwnerRepository<T extends Owner> extends CrudRepository<T, Long> {
}
