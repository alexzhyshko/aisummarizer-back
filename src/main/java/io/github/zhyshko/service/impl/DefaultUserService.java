package io.github.zhyshko.service.impl;

import io.github.zhyshko.exception.NotFoundException;
import io.github.zhyshko.model.TokenBalance;
import io.github.zhyshko.model.User;
import io.github.zhyshko.model.UserRole;
import io.github.zhyshko.repository.UserRepository;
import io.github.zhyshko.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DefaultUserService implements UserService {

    private UserRepository userRepository;

    @Override
    public Optional<User> getUser(Long userId) {
        return this.userRepository.findById(userId);
    }

    @Override
    public User registerUser(User user) {
        user.setTokenBalance(TokenBalance.builder()
                .user(user)
                .amount(1000L)
                .build());
        user.setUserRole(UserRole.USER);
        return userRepository.save(user);
    }

    @Override
    public Optional<User> updateUser(User user) {
        return userRepository.findByUsername(user.getUsername())
                .map(userFromDb -> {
                    user.setUserRole(userFromDb.getUserRole());
                    user.setId(userFromDb.getId());
                    user.setTokenBalance(userFromDb.getTokenBalance());
                    return userRepository.save(user);
                });
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
