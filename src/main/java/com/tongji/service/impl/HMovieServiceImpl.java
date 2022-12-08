package com.tongji.service.impl;

import com.tongji.entity.Movie;
import com.tongji.mapper.hive.HMovieMapper;
import com.tongji.service.HMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HMovieServiceImpl implements HMovieService {
    @Autowired
    private HMovieMapper movieMapper;

    @Override
    public Movie getById(int id) {
        Object o = movieMapper.selectById(id);
        System.out.println("o = " + o);
        return (Movie) o;
    }
}
