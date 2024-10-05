package com.example.UserService.model;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AuthRequest {
   private String userName;
   private String password;
}
