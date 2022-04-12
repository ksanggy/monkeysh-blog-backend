package com.monkeysh.blogs.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class UserDto {
    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private String profile;
    private String intro;
}
