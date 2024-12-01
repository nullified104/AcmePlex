package com.acmeplex.backend.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "movie")
public class Movie {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "movie_seq")
    @SequenceGenerator(name = "movie_seq", sequenceName = "movie_seq", allocationSize = 1)
    private Integer id;
    
    private String title;
    private String genre;
    private Integer duration;

    @Lob  // Indicates a large object, ideal for large text
    @Column(columnDefinition = "TEXT")  // Ensures it is stored as TEXT in the database
    private String description;

    public Movie() {
    }

    public Movie(String title, String genre, Integer duration, String description) {
        this.title = title;
        this.genre = genre;
        this.duration = duration;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
