package com.accenture.spi.persistance.hibernate.implementation;

import com.accenture.config.TupletConfig;
import com.accenture.contrats.persistance.UserHibernateRepository;
import com.accenture.models.User;
import com.accenture.spi.persistance.hibernate.mapper.user.UserHToUser;
import com.accenture.spi.persistance.hibernate.mapper.user.UserToUserH;
import com.accenture.spi.persistance.hibernate.models.UserH;
import com.accenture.utils.PaginateResult;
import com.accenture.utils.Tuplet;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;
import org.apache.logging.log4j.util.Strings;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


/**
 * @Project Calculatrice
 * @Author desire.junior.ndjog
 * @Date Created 9/9/2024
 */

@Repository
@Transactional
public class HibernateRepository implements UserHibernateRepository {
    private EntityManager em;
    private UserToUserH userToUserH;
    private UserHToUser userHToUser;
    private Tuplet<CriteriaQuery<UserH>, CriteriaBuilder, Root<UserH>> tuplet;

    public HibernateRepository(EntityManager entityManager, UserToUserH userToUserHibernate, UserHToUser userHToUser){
        this.em = entityManager;
        this.userToUserH = userToUserHibernate;
        this.userHToUser = userHToUser;
        this.tuplet = TupletConfig.persistanceContext(this.em, UserH.class);
    }

    @Override
    public PaginateResult<User> userPaginate(String search, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        CriteriaBuilder criteriaBuilder = tuplet.getSecond();
        CriteriaQuery<UserH> criteriaQuery = tuplet.getFirst();
        Root<UserH> root = tuplet.getThirt();
        List<Predicate> predicates = new ArrayList<>();

        if (Strings.isNotBlank(search)){
            predicates.add(
                    criteriaBuilder.like(root.<String>get("nom"), "%"+search+"%")
            );
        }

        if (Strings.isNotBlank(search)){
            predicates.add(
                    criteriaBuilder.like(root.<String>get("prenom"), "%"+search+"%")
            );
        }

        if (Strings.isNotBlank(search)){
            predicates.add(
                    criteriaBuilder.like(root.<String>get("email"), "%"+search+"%")
            );
        }

        if (Strings.isNotBlank(search)){
            criteriaQuery.where(
                    criteriaBuilder.or(
                            predicates.toArray(predicates.toArray(new Predicate[0]))
                    )
            );
        }

        long count = em.createQuery(criteriaQuery).getResultList().size();

        List<UserH> list = em.createQuery(criteriaQuery)
                .setFirstResult((int) pageable.getOffset())
                .setMaxResults(pageable.getPageSize())
                .getResultList();

        Page<UserH> result = new PageImpl<>(list, pageable, count);
        if (!result.getContent().isEmpty()){
            List<User> content = result.getContent().stream().map(userHToUser).toList();
            return new PaginateResult<>(result.getTotalElements(), result.getTotalPages(), content);
        }
        return new PaginateResult<>(result.getTotalElements(), result.getTotalPages(), null);
    }

    @Override
    public void create(User user) {
        UserH userH = userToUserH.apply(user);
        em.persist(userH);
    }

    @Override
    public User update(User user) {
        UserH userH = userToUserH.apply(user);
        return userHToUser.apply(em.merge(userH));
    }

    @Override
    public User findById(Long id) {
        CriteriaBuilder criteriaBuilder = tuplet.getSecond();
        CriteriaQuery<UserH> criteriaQuery = tuplet.getFirst();
        Root<UserH> root = tuplet.getThirt();
        try{
            criteriaQuery.where(
                    criteriaBuilder.equal(
                            root.get("id"), id
                    )
            );
            UserH userH = em.createQuery(criteriaQuery).getSingleResult();
            return userHToUser.apply(userH);
        }catch (NoResultException ex){
            return null;
        }
    }
}
