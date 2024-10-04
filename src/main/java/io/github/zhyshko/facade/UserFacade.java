package io.github.zhyshko.facade;

import io.github.zhyshko.dto.UserDto;

public interface UserFacade {

    UserDto getUser(Long userId);

    UserDto registerUser(UserDto userDto);

    UserDto updateUser(UserDto userDto);

}
