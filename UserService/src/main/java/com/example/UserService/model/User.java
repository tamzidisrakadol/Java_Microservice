package com.example.UserService.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.*;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "micro_users")
public class User {

    @Id
    private String userid;
    private String fname;
    private String username;
    private String email;
    private String address;
    private String about;
    private String password;
    private String role;

    @Transient
    private List<Rating> ratingList;
}
