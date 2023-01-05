package com.test.exceptionhandlingspringbootapp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @NotBlank(message = "Name must not be null.")
    @Column(name = "name")
    private String name;

    @Min(value = 0, message = "Age must be greater than 0.")
    @NotNull(message = "Age must not be null.")
    @Column(name = "age")
    private int age;
}
