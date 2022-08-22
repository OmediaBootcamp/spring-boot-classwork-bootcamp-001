package dev.omedia.repository;

import dev.omedia.dto.User;
import dev.omedia.model.query.UserQueryModel;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Transactional
public class UserRepoImpl implements UserRepo {

    @PersistenceContext
    public final EntityManager em;

    public UserRepoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public User save(User entity) {
        return em.merge(entity);
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.ofNullable(em.find(User.class, id));
    }

    @Override
    public Iterable<User> findAll() {
        return getUserBy(UserQueryModel.builder().build());
    }

    @Override
    public Iterable<User> getUserByName(String name) {
        return getUserBy(UserQueryModel.builder().name(name).build());
    }

    @Override
    public Iterable<User> findByIdGreaterThan(long l) {
        return getUserBy(UserQueryModel.builder().idGreaterThan(l).build());
    }


    private Iterable<User> getUserBy(UserQueryModel model) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<User> query = cb.createQuery(User.class);
        query.where(createPredicates(cb, query.from(User.class), model));

        return em.createQuery(query).getResultList();
    }

    private Predicate[] createPredicates(CriteriaBuilder cb, Root<User> from, UserQueryModel model) {
        final List<Predicate> predicates = new ArrayList<>();

        Optional.ofNullable(model.getId()).ifPresent(id -> predicates.add(cb.equal(from.get("id"), id)));
        Optional.ofNullable(model.getIdGreaterThan()).ifPresent(id -> predicates.add(cb.greaterThan(from.get("id"), id)));
        Optional.ofNullable(model.getName()).ifPresent(name -> predicates.add(cb.equal(from.get("name"), name)));

        return predicates.toArray(new Predicate[0]);
    }

}
