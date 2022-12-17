package com.tongji.test;

import com.tongji.entity.Movie;
import com.tongji.service.MovieService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class APITest {
    @Autowired
    private MovieService movieService;

    @Test
    public void getMovie() {
        System.out.println(movieService.getById("2"));
    }


}
