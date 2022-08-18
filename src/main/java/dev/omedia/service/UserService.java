package dev.omedia.service;

import dev.omedia.dto.User;
import org.hibernate.criterion.CriteriaQuery;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {

    @PersistenceContext
    private EntityManager em;

    public void createUser(User user) {
        em.persist(user);
    }

    public Optional<User> getUserById(long id) {
        TypedQuery<User> query = em.createQuery("select u from User u where u.id=:id", User.class);
        List<User> resultList = query
                .setParameter("id", id)
                .getResultList();
        return resultList.isEmpty() ? Optional.empty() : Optional.ofNullable(resultList.iterator().next());
    }

    public Collection<User> getUsers() {
        return em.createQuery("FROM User u ", User.class).getResultList();
    }

    public User updateUser(long id, User user) {
        user.setId(id);
        return em.merge(user);
    }

}
