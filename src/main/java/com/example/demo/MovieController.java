package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/movies")
public class MovieController {
    private final MovieRepository movieRepository;

    public MovieController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @GetMapping
    public String listMovies(Model model) {
        model.addAttribute("movies", movieRepository.findAll());
        return "movies/list";
    }

    @GetMapping("/{id}")
    public String viewMovie(@PathVariable Long id, Model model) {
        movieRepository.findById(id).ifPresent(movie -> model.addAttribute("movie", movie));
        return "movies/view";
    }

    @GetMapping("/edit/{id}")
    public String editMovieForm(@PathVariable Long id, Model model) {
        movieRepository.findById(id).ifPresent(movie -> model.addAttribute("movie", movie));
        return "movies/form";
    }

    @GetMapping("/new")
    public String newMovieForm(Model model) {
        model.addAttribute("movie", new Movie());
        return "movies/form";
    }

    @PostMapping("/save")
    public String saveMovie(@ModelAttribute Movie movie) {
        movieRepository.save(movie);
        return "redirect:/movies";
    }

    @PostMapping("/delete/{id}")
    public String deleteMovie(@PathVariable Long id) {
        movieRepository.deleteById(id);
        return "redirect:/movies";
    }
}