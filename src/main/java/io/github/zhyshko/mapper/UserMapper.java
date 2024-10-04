package io.github.zhyshko.mapper;

import io.github.zhyshko.dto.UserDto;
import io.github.zhyshko.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "tokenBalance", source = "tokenBalance.amount")
    @Mapping(target = "id", ignore = true)
    UserDto toDto(User user);

    @Mapping(target = "tokenBalance", ignore = true)
    @Mapping(target = "userRole", ignore = true)
    User toModel(UserDto userDto);
}
