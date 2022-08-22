package dev.omedia.service;

import dev.omedia.dto.User;
import dev.omedia.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceEM {

    @PersistenceContext
    private final EntityManager em;


    @Autowired
    public UserServiceEM(EntityManager em) {
        this.em = em;
    }


    // select name from Users where id > 1;
    public Object returnUsers() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Customer> query = cb.createQuery(Customer.class);
        Root<User> from = query.from(User.class);
        CriteriaQuery<Customer> name = query.select(cb.construct(Customer.class, from.get("id"), from.get("firstName")));
        name.where(cb.greaterThan(from.get("id"), 1));

        return em.createQuery(name).getResultList();
    }


}
