package com.accenture.implementation;

import com.accenture.contrats.persistance.UserHibernateRepository;
import com.accenture.contrats.persistance.service.UserService;
import com.accenture.models.User;
import com.accenture.utils.PaginateResult;

/**
 * @Project Calculatrice
 * @Author desire.junior.ndjog
 * @Date Created 9/9/2024
 */


public class UserServiceImpl implements UserService {
    private UserHibernateRepository userHibernateRepository;

    public UserServiceImpl(UserHibernateRepository repository){
        this.userHibernateRepository = repository;
    }

    @Override
    public PaginateResult<User> userPaginate(String search, int page, int size) {
        return userHibernateRepository.userPaginate(search, page, size);
    }

    @Override
    public void save(User user) {
        //logic de traiment des objet
        userHibernateRepository.create(user);
    }

    @Override
    public User update(User user) {
        //logic de traiment des objet
        return userHibernateRepository.update(user);
    }

    @Override
    public User findById(Long id) {
        //logic de traiment des objet
        return userHibernateRepository.findById(id);
    }
}
