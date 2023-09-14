package it.jdk.demomicroservicesuser.controller;

import it.jdk.demomicroservicesuser.VO.ResponseTemplateVO;
import it.jdk.demomicroservicesuser.entity.UserEntity;
import it.jdk.demomicroservicesuser.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public UserEntity saveUser(@RequestBody UserEntity user ) {
        log.info("");
        return userService.saveUser(user);
    }

    @GetMapping("/findAll")
    public List<UserEntity> findAllUsers() {
        return userService.findAllUsers();
    }


    @GetMapping("/{id}")
    public ResponseTemplateVO getUserWithDepartment(@PathVariable("id") Long userId) {
        log.info("Inside getUserWithDepartment of UserController");
        return userService.getUserWithDepartment(userId);
    }

}
