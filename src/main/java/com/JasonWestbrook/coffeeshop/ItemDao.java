package com.JasonWestbrook.coffeeshop;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class ItemDao
{
    
    @PersistenceContext
    private EntityManager em;
    
    public List<Item> findAll()
    {
        return em.createQuery("FROM Item", Item.class).getResultList();
    }
    
    public void create(Item item)
    {
        em.persist(item);
    }
    
    public void update(Item item)
    {
        em.merge(item);
    }
    
    public void delete(long id)
    {
        Item item = em.getReference(Item.class, id);
        em.remove(item);
    }
}