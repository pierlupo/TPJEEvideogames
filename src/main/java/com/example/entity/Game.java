package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    private String category;

    @Temporal(TemporalType.DATE)
    private Date releaseDate;

    private double price;

    private int stock;

    @OneToMany(mappedBy = "game")
    List<Comment> comments;


    @OneToMany(mappedBy = "game")
    private List<Image> images;



}
