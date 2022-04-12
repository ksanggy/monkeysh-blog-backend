package com.monkeysh.blogs.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(schema = "monkeysh-blogs", name = "ROLE")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
}
