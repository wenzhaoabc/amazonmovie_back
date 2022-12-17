package com.tongji.service.impl;

import com.alibaba.fastjson.JSON;
import com.tongji.dto.MovieInfoDto;
import com.tongji.entity.HMovieRes;
import com.tongji.entity.Movie;
import com.tongji.mapper.hive.HMovieMapper;
import com.tongji.service.HMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class HMovieServiceImpl implements HMovieService {
    @Autowired
    private HMovieMapper movieMapper;


    @Override
    public String getMoviesByMultipleCondition(MovieInfoDto movieInfoDto) {
        Map<String, Object> res = new HashMap<>();
        Long startTime = System.currentTimeMillis();
        Long endTime = startTime + 20000;
        List<HMovieRes> movies = new ArrayList<>();
        try {
            movies = movieMapper.getMoviesByMultipleCondition(movieInfoDto);
        } catch (Exception e) {
            movies = new ArrayList<>();
        }
        endTime = System.currentTimeMillis();
        res.put("movies", movies);
        res.put("time", (endTime - startTime) / 1000 / 60);
        res.put("movieNum", movies.size());
        return JSON.toJSONString(res);
    }
}
