package io.github.zhyshko.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {

    private Long id;
    private String username;
    private String firstName;
    private String lastName;
    private String languageCode;
    private String userRole;
    private Long tokenBalance;

}
