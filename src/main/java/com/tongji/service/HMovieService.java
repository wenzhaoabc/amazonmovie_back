package com.tongji.service;

import com.tongji.dto.MovieInfoDto;
import com.tongji.entity.Movie;

public interface HMovieService {
    public Movie getById(int id);

    public String getMoviesByMultipleCondition(MovieInfoDto movieInfoDto);
}
