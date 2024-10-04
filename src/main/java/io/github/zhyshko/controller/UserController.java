package io.github.zhyshko.controller;

import io.github.zhyshko.dto.UserDto;
import io.github.zhyshko.facade.UserFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController extends BaseController{

    private UserFacade userFacade;

    @GetMapping(value = "/{userId}", produces = "application/json")
    public UserDto getUser(@PathVariable Long userId) {
        return userFacade.getUser(userId);
    }

    @PostMapping(consumes = "application/json")
    public UserDto registerUser(@RequestBody UserDto user) {
        return userFacade.registerUser(user);
    }

    @PutMapping(consumes = "application/json")
    public UserDto updateUser(@RequestBody UserDto user) {
        return userFacade.updateUser(user);
    }

    @Autowired
    public void setUserFacade(UserFacade userFacade) {
        this.userFacade = userFacade;
    }
}
