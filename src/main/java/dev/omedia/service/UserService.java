package dev.omedia.service;

import dev.omedia.dto.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;

@Service
@Transactional
public class UserService {

    @PersistenceContext
    private EntityManager manager;

    public void createUser(User user){
        manager.persist(user);
    }

    public Collection<User> getUsers(){
       return manager.createQuery("SELECT u FROM User u").getResultList();
    }

    public User updateUser(long id,User user){
        user.setId(id);
        return manager.merge(user);
    }


}
