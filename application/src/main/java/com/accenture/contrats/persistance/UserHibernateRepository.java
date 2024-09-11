package com.accenture.contrats.persistance;

import com.accenture.models.User;
import com.accenture.utils.PaginateResult;

/**
 * @Project Calculatrice
 * @Author desire.junior.ndjog
 * @Date Created 9/9/2024
 */

public interface UserHibernateRepository {
    PaginateResult<User> userPaginate(String search, int page, int size);
    void create(User user);
    User update(User user);
    User findById(Long id);
}
