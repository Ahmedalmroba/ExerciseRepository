package com.example.exerciserepository.Controller;

import com.example.exerciserepository.Model.User;
import com.example.exerciserepository.Servise.UserServise;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {
private final UserServise userServise;
@GetMapping("/get")
public ResponseEntity getAllUsers() {
    return ResponseEntity.status(200).body(userServise.getUser());
}

@PostMapping("/add")
    public ResponseEntity addUser(@Valid@RequestBody User user, Errors errors) {
    if (errors.hasErrors()) {
        String message = errors.getFieldError().getDefaultMessage();
        return ResponseEntity.status(400).body(message);
    }
    userServise.addUser(user);
    return ResponseEntity.status(200).body(user);
}
@PostMapping("/update/{id}")
    public ResponseEntity updateUser(@PathVariable Integer id,@Valid@RequestBody User user, Errors errors) {
    if (errors.hasErrors()) {
        String message = errors.getFieldError().getDefaultMessage();
        return ResponseEntity.status(400).body(message);
    }
    userServise.updateUser(id,user);
    return ResponseEntity.status(200).body(user);

}
@DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id) {
    userServise.deleteUser(id);
    return ResponseEntity.status(200).body("is deleted");
}
@GetMapping("/get/{username}{password}")
public ResponseEntity findUsernameAndPassword(@PathVariable String username, @PathVariable int password) {
    List<User> users = userServise.getUserByUsernameAndPassword(username,password);
    if (users.isEmpty()) {
        return ResponseEntity.status(400).body("User not found");
    }
    return ResponseEntity.status(200).body(users);
}
    @GetMapping("/get/{email}")
    public ResponseEntity getUserByEmail(@PathVariable String email) {
    User user = userServise.findUserEmail(email);
    if (user == null) {
        return ResponseEntity.status(400).body("User not found");
    }
    return ResponseEntity.status(200).body(user);
    }
    @GetMapping("/get/{role}")
    public ResponseEntity getUserByRole(@PathVariable String role) {
        List<User> users = userServise.findByRole(role);
        if (users.isEmpty()) {
            return ResponseEntity.status(400).body("User not found");
        }
        return ResponseEntity.status(200).body(users);
    }

    @GetMapping("/get/{age}")
    public ResponseEntity getUserByAge(@PathVariable int age) {
    List<User> users = userServise.findByAge(age);
    if (users.isEmpty()) {
        return ResponseEntity.status(400).body("User not found");
    }
    return ResponseEntity.status(200).body(users);
    }






}
