package it.jdk.demomicroservicesuser.service;

import it.jdk.demomicroservicesuser.VO.Department;
import it.jdk.demomicroservicesuser.VO.ResponseTemplateVO;
import it.jdk.demomicroservicesuser.entity.UserEntity;
import it.jdk.demomicroservicesuser.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public UserEntity saveUser(UserEntity user) {
        log.info("Inside saveUser of UserService");
        return userRepository.save(user);
    }

    public List<UserEntity> findAllUsers() {
        return userRepository.findAll();
    }


    public ResponseTemplateVO getUserWithDepartment(Long userId) {
        log.info("Inside getUserWithDepartment of UserService");
        ResponseTemplateVO vo = new ResponseTemplateVO();
        UserEntity user = userRepository.findByUserId(userId);

        Department department = restTemplate.getForObject("http://localhost:8080/departments/" + user.getDepartmentId()
                ,Department.class);

        vo.setUser(user);
        vo.setDepartment(department);

        return vo;

    }



}
