package com.example.springsqlapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Integer id;

    @Column
    @NonNull
    private String name;

    @Column
    @NonNull
    private long price;

    @Column
    @NonNull
    private double rating;

    @Column
    @NonNull
    private MovieGenre genre;
}
