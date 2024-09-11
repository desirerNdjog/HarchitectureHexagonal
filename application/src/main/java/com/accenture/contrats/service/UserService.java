package com.accenture.contrats.persistance.service;

import com.accenture.models.User;
import com.accenture.utils.PaginateResult;

/**
 * @Project Calculatrice
 * @Author desire.junior.ndjog
 * @Date Created 9/9/2024
 */
public interface UserService {
    PaginateResult<User> userPaginate(String search, int page, int size);
    void save(User user);
    User update(User user);
    User findById(Long id);
}
