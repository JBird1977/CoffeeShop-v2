package com.JasonWestbrook.coffeeshop;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class ProductsDao
{
    @PersistenceContext
    private EntityManager em;
    
}
