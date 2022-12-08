package com.tongji.controller;

import com.tongji.entity.Movie;
import com.tongji.service.HMovieService;
import com.tongji.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movie")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @Autowired
    private HMovieService hMovieService;

    @GetMapping("{id}")
    public Movie oneMovie(@PathVariable String id) {
        return movieService.getById(id);
    }

    @GetMapping("/hive/{id}")
    public Movie hiveOneMovie(@PathVariable int id) {
        Movie m = hMovieService.getById(id);
        System.out.println(m.toString());
        return m;
    }
}
