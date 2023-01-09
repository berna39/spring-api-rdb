package com.example.springrdb.controller;

import com.example.springrdb.dto.UserQuery;
import com.example.springrdb.dto.UserRequest;
import com.example.springrdb.entity.User;
import com.example.springrdb.exception.NoFoundException;
import com.example.springrdb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Constraint;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/")
    public ResponseEntity<List<User>> findAll() {
        return  ResponseEntity.ok(service.findAll());
    }

    @PostMapping("/create")
    public ResponseEntity<User> save(@RequestBody @Valid  UserRequest userRequest) {
        return  new ResponseEntity<>(service.save(userRequest), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<User> update(@RequestBody @Valid  UserRequest userRequest) throws NoFoundException {
        return  new ResponseEntity<>(service.update(userRequest), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable int id) throws NoFoundException {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping("/findByName")
    public ResponseEntity<User> findByName(@RequestBody UserQuery userQuery) throws NoFoundException {
        return ResponseEntity.ok(service.findByName(userQuery.getName()));
    }

    @PostMapping("/findAllByName")
    public ResponseEntity<List<User>> findallByName(@RequestBody UserQuery userQuery) {
        return ResponseEntity.ok(service.findAllByName(userQuery.getName()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) throws NoFoundException {
        return ResponseEntity.ok(service.delete(id));
    }
}
