package com.JasonWestbrook.coffeeshop;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class UserDao
{
    @PersistenceContext
    private EntityManager em;
    
    public List<User> findAll()
    {
        return em.createQuery("FROM Users", User.class).getResultList();
    }
    
    public User findByUserName(String name)
    {
        try
        {
            return em.createQuery("FROM User WHERE userName = :username", User.class)
                     .setParameter("username", name)
                     .getSingleResult(); 
        } catch (NoResultException ex)
        {
            return null;
        }
    
    }
    
    public void update(User user)
    {
        System.out.println(user.lastName);
        em.merge(user);
    }
    

}
