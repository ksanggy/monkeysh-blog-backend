package com.monkeysh.blogs.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(schema = "monkeysh-blogs", name = "USER")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String passwordHash;

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date registeredAt;

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date lastLogin;

    private String intro;

    private String profile;

    //user를 조회할때 roles도 함께 조회하도록 설정
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Role> roles = new ArrayList<>();

}
