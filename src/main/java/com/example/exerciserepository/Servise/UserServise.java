package com.example.exerciserepository.Servise;

import com.example.exerciserepository.Api.ApiException;
import com.example.exerciserepository.Model.User;
import com.example.exerciserepository.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServise {
    private final UserRepository userRepository;

    public List<User> getUser(){
        return userRepository.findAll();

    }
    public void addUser(User user){
        userRepository.save(user);
    }
    public void updateUser(Integer id,User user){
        User u = userRepository.findUserById(id);
        if(u == null){
            throw new ApiException("User not found");
        }
        u.setName(user.getName());
        u.setEmail(user.getEmail());
        u.setUsername(user.getUsername());
        u.setPassword(user.getPassword());
        u.setRole(user.getRole());
        u.setAge(user.getAge());
        userRepository.save(u);
    }
    public void deleteUser(Integer id){
        User u = userRepository.findUserById(id);
        if(u == null){
            throw new ApiException("User not found");
        }
        userRepository.delete(u);
    }
    public List<User> getUserByUsernameAndPassword(String username, Integer password){
        List<User> users = userRepository.findByUsernameAndPassword(username, password);
        if(users == null){
            throw new ApiException("User not found");
        }
        return users;
    }
    public User findUserEmail(String email){
        User user = userRepository.findByEmail(email);
        if(user == null){
            throw new ApiException("User not found");
        }
        return user;
    }
    public List<User> findByRole(String role){
        List<User> users = userRepository.findByRole(role);
        if(users == null){
            throw new ApiException("User not found");
        }
        return users;
    }
    public List<User> findByAge(Integer age){
        List<User> users = userRepository.findUserByAgeGreaterThanEqual(age);
        if(users == null){
            throw new ApiException("User not found");
        }
        return users;

    }
}
