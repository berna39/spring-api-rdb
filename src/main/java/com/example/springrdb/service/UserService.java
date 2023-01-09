package com.example.springrdb.service;

import com.example.springrdb.dto.UserRequest;
import com.example.springrdb.entity.User;
import com.example.springrdb.exception.NoFoundException;
import com.example.springrdb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User save(UserRequest userRequest) {
        User user = User.build(0, userRequest.getName(), userRequest.getEmail(), userRequest.getPhone(), userRequest.getGender(), userRequest.getAge(), userRequest.getNationality());
        return repository.save(user);
    }

    public User findById(int id) throws NoFoundException{
        Optional<User> user = repository.findById(id);
        if(!user.isEmpty()) {
            return user.get();
        } else {
            throw new NoFoundException("User not found");
        }
    }

    public User findByName(String name) throws NoFoundException{
        Optional<User> user = repository.findByName(name);
        if(!user.isEmpty()) {
            return user.get();
        } else {
            throw new NoFoundException("User not found");
        }
    }

    public List<User> findAllByName(String name) {
        return repository.findAllByName(name);
    }

    public User update(UserRequest userRequest) throws NoFoundException {
        Optional<User> oldUser = repository.findById(userRequest.getId());
        User user = new User();

        if(!oldUser.isEmpty()) {
            user.setId(oldUser.get().getId());
            user.setName(userRequest.getName());
            user.setEmail(userRequest.getEmail());
            user.setPhone(userRequest.getPhone());
            user.setGender(userRequest.getGender());
            user.setAge(userRequest.getAge());
            user.setNationality(userRequest.getNationality());
        } else {
            throw new NoFoundException("User not found");
        }

        return repository.save(user);
    }

    public String delete(int id) throws NoFoundException{
        Optional<User> user = repository.findById(id);
        if(!user.isEmpty()) {
            repository.delete(user.get());
            return "deleted successfully";
        } else {
            throw new NoFoundException("User not found");
        }
    }
}
