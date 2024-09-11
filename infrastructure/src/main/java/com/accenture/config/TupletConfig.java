package com.accenture.config;

import com.accenture.utils.Tuplet;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

/**
 * @Project Calculatrice
 * @Author desire.junior.ndjog
 * @Date Created 9/9/2024
 */

public class TupletConfig {

    private TupletConfig(){

    }

    /**
     * @param em
     * @param kclass
     * @return
     * @param <T>
     */

    public static  <T> Tuplet<CriteriaQuery<T>, CriteriaBuilder, Root<T>> persistanceContext(EntityManager em,Class<T> kclass){
            CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
            CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(kclass);
            Root<T> root = criteriaQuery.from(kclass);
        return new Tuplet<>(criteriaQuery, criteriaBuilder, root);
    }
}
