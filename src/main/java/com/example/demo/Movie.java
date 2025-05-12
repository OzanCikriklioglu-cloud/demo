package com.example.demo;

import jakarta.persistence.*;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(name = "release_year")
    private int year;

    private String genre;
    private String director;
    private int runtime;
    private String country;

    public Movie() {}

    public Movie(String title, int year, String genre, String director, int runtime, String country) {
        this.title = title;
        this.year = year;
        this.genre = genre;
        this.director = director;
        this.runtime = runtime;
        this.country = country;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }

    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }

    public String getDirector() { return director; }
    public void setDirector(String director) { this.director = director; }

    public int getRuntime() { return runtime; }
    public void setRuntime(int runtime) { this.runtime = runtime; }

    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }
}