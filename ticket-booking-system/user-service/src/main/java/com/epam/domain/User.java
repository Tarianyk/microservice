package com.epam.domain;

import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @NotEmpty
    @NotNull
    @Size(min = 3, max = 10, message = "Error in size")
    @Column(name = "name")
    String name;
    @NotEmpty
    @NotNull
    @Email
    @Column(name = "email")
    String email;
}
