package com.example.springbootlearn.controller;

import com.example.springbootlearn.entity.UserEntity;
import com.example.springbootlearn.jpa.UserJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserJPA userJPA;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<UserEntity> list(){  //http://127.0.0.1:8080/user/list
        return userJPA.findAll();
    }

    /**
     * add or update user
     * @param entity
     * @return
     */
    @RequestMapping(value = "/save", method = RequestMethod.GET)
    public UserEntity save(UserEntity entity){   // http://127.0.0.1:8080/user/save?name=wuhao&age=30&address=Beijing
        System.out.println("name is " + entity.getName());
        System.out.println("age is " + entity.getAge());
        System.out.println("addr is " + entity.getAddress());
        return userJPA.save(entity);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public List<UserEntity> delete(Long id){
        System.out.println("del id is " + id);
        userJPA.deleteById(id);
        return userJPA.findAll();
    }

}
