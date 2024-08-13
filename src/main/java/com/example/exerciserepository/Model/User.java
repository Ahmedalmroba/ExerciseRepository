package com.example.exerciserepository.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "name should be not Empty")
    @Column(columnDefinition = "varchar(20) not null  ")
    @Min(5)
    private String name;

    @NotEmpty(message = "name should be not Empty")
    @Column(columnDefinition = "varchar(20) not null unique ")
    @Min(5)
    private String username;
    @NotEmpty(message = "name should be not Empty")
    @Column(columnDefinition = "int not null  ")
     private int password;

    @NotEmpty(message = "must not be empty")
    @Column(columnDefinition = "varchar(10) not null unique ")
    @Email
    private String email;
    @NotEmpty(message = "must not be empty")
    @Pattern(regexp = "user|admin")
    @Column(columnDefinition ="varchar(5)check(role='admin' or role='admin')")
    private String role;
    @NotEmpty(message = "must not be empty")
    @Column(columnDefinition = "int not null  ")
    private int age;
}
