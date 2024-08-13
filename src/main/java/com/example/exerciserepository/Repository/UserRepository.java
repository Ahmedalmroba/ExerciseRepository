package com.example.exerciserepository.Repository;

import com.example.exerciserepository.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findUserById(Integer id);

    List<User> findByUsernameAndPassword(String username, int password);
    User findByEmail(String email);
    List<User> findByRole(String role);
    List<User> findUserByAgeGreaterThanEqual(int age);

}
