package com.tongji.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tongji.entity.Movie;
import com.tongji.entity.Origin;
import com.tongji.service.HMovieService;
import com.tongji.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api/movie")
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

    @CrossOrigin
    @RequestMapping(value = "/mysql/getOrigin", method = RequestMethod.GET)
    public Object getOrigin(HttpServletRequest request) {
        String title = request.getParameter("searchingTitle").toString();
        List<Origin> movies = movieService.getOrigin(title);
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        jsonArray.addAll(movies);
        jsonObject.put("movies", jsonArray);
        return jsonObject;
    }
}
