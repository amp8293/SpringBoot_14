/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo;

import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author amp
 */
@Controller
public class HomeController {
    @Autowired
    DirectorRepository directorRepository;
    
    @RequestMapping("/")
    public String index(Model model) {
        Set<Movie> movies = new HashSet<>();
        
        Movie movie ;
        
        movie = new Movie();
        movie.setTitle("Star Movie");
        movie.setYear(2017);
        movie.setDescription("About Stars...");
        movies.add(movie);
        
        movie = new Movie();
        movie.setTitle("Deathstar Ewoks");
        movie.setYear(2011);
        movie.setDescription("About Ewoks on DeathStar...");
        movies.add(movie);
        
        Director director=new Director();
        director.setName("Stephen Bullock");
        director.setGenre("Sci Fi");
        director.setMovies(movies);
        directorRepository.save(director);
        
        model.addAttribute("directors", directorRepository.findAll());
        
        return "index";
    }
    
}
