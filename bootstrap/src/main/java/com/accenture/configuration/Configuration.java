package com.accenture.configuration;

import com.accenture.contrats.persistance.UserHibernateRepository;
import com.accenture.implementation.UserServiceImpl;
import com.accenture.contrats.persistance.service.UserService;
import com.accenture.spi.persistance.hibernate.implementation.HibernateRepository;
import com.accenture.spi.persistance.hibernate.mapper.user.UserHToUser;
import com.accenture.spi.persistance.hibernate.mapper.user.UserToUserH;
import jakarta.persistence.EntityManager;
import org.springframework.context.annotation.Bean;

/**
 * @Project Calculatrice
 * @Author desire.junior.ndjog
 * @Date Created 9/9/2024
 */

@org.springframework.context.annotation.Configuration
public class Configuration {
    private EntityManager em;
    private UserToUserH userToUserH;
    private UserHToUser userHToUser;

    public Configuration(EntityManager entityManager, UserToUserH user, UserHToUser userHToUser){
        this.em = entityManager;
        this.userToUserH = user;
        this.userHToUser = userHToUser;
    }

    @Bean
    public UserHibernateRepository userHibernateRepository(){
        return new HibernateRepository(em, userToUserH, userHToUser);
    }

    @Bean
    public UserService userService(){
        return new UserServiceImpl(userHibernateRepository());
    }
}
