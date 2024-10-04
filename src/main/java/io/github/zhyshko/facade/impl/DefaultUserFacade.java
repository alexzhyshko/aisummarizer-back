package io.github.zhyshko.facade.impl;

import io.github.zhyshko.dto.UserDto;
import io.github.zhyshko.exception.NotFoundException;
import io.github.zhyshko.facade.UserFacade;
import io.github.zhyshko.mapper.UserMapper;
import io.github.zhyshko.model.User;
import io.github.zhyshko.service.BalanceService;
import io.github.zhyshko.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DefaultUserFacade implements UserFacade {

    private UserService userService;
    private BalanceService balanceService;
    private UserMapper userMapper;

    @Override
    public UserDto getUser(Long userId) {
        return this.userService.getUser(userId)
                .map(userMapper::toDto)
                .orElseThrow(() -> new NotFoundException(String.format("User with id %s not found", userId)));

    }

    @Override
    public UserDto registerUser(UserDto userDto) {
        return this.userMapper.toDto(this.userService.registerUser(userMapper.toModel(userDto)));
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        return userService.updateUser(userMapper.toModel(userDto))
                .map(userMapper::toDto)
                .orElseThrow(() ->
                        new NotFoundException(String.format("Did not find user by username %s", userDto.getUsername())));
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setBalanceService(BalanceService balanceService) {
        this.balanceService = balanceService;
    }

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
}
