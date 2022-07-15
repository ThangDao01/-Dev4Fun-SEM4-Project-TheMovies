package com.example.jwttoken.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto implements Serializable {
    private Integer id;

    @NotBlank(message="username not black")
    private String username;
    @NotBlank(message = "password not black")
    private String password;
    private Integer roleId;
    private RoleDto role;
}
