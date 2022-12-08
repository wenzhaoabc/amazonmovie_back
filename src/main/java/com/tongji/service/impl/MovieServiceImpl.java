package com.tongji.service.impl;

import com.tongji.entity.Movie;
import com.tongji.mapper.mysql.MMovieMapper;
import com.tongji.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    private MMovieMapper movieMapper;

    @Override
    public Movie getById(String id) {
        return movieMapper.selectById(id);
    }
}
