package com.example.entity;


import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.Entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Builder
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

    @OneToMany(mappedBy = "game", fetch = FetchType.EAGER)
    List<Comment> comments;


    @OneToMany(mappedBy = "game", fetch = FetchType.EAGER)
    private List<Image> images;

    public Game() {
    }

    public Game(String title, String category, Date releaseDate, double price, int stock, List<Comment> comments, List<Image> images) {
        this.title = title;
        this.category = category;
        this.releaseDate = releaseDate;
        this.price = price;
        this.stock = stock;
        this.comments = comments;
        this.images = images;
    }

    public Game(int id, String title, String category, Date releaseDate, double price, int stock, List<Comment> comments, List<Image> images) {
        this(title,category,releaseDate,price,stock,comments,images);
        this.id = id;
    }
}
