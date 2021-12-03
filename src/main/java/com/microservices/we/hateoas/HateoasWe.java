package com.microservices.we.hateoas;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

@RestController
public class HateoasWe {

    @GetMapping("/users/{name}")
    public EntityModel<User> getUser(@PathVariable String name){

       User user = new User();
       user.setName(name);
       user.setOccupation(occupation());

       EntityModel<User> userEntityModel = EntityModel.of(user);
        WebMvcLinkBuilder webMvcLinkBuilder =  WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getallUsers());
        userEntityModel.add(webMvcLinkBuilder.withRel("_allusers"));

       return userEntityModel;


    }



    @GetMapping("/users")
    public List<User> getallUsers(){

        List userList =  new ArrayList<User>();


        User user = new User();
        user.setName(occupation());
        user.setOccupation(occupation());
        userList.add(user);
        user = new User();
        user.setName(occupation());
        user.setOccupation(occupation());
        userList.add(user);


        return userList;


    }
    private String occupation() {
        byte[] array = new byte[7]; // length is bounded by 7
        new Random().nextBytes(array);
        String generatedString = new String(array, Charset.forName("UTF-8"));

        return generatedString;
    }
}
