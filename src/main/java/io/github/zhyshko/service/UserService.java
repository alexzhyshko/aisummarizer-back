package io.github.zhyshko.service;

import io.github.zhyshko.model.User;

import java.util.Optional;

public interface UserService {

    Optional<User> getUser(Long userId);

    User registerUser(User user);

    Optional<User> updateUser(User user);

}
