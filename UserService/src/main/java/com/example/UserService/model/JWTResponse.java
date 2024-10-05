package com.example.UserService.model;


import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JWTResponse {
    private String jwtToken;
    private String username;
}
