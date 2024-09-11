package com.accenture.spi.persistance.hibernate.mapper.user;

import com.accenture.models.User;
import com.accenture.spi.persistance.hibernate.models.UserH;
import org.springframework.stereotype.Service;

import java.util.function.Function;

/**
 * @Project Calculatrice
 * @Author desire.junior.ndjog
 * @Date Created 9/9/2024
 */

@Service
public class UserToUserH implements Function<User, UserH> {
    @Override
    public UserH apply(User user) {
        return new UserH(
                user.getNom(),
                user.getPrenom(),
                user.getEmail(),
                user.getSexe()
        );
    }
}
