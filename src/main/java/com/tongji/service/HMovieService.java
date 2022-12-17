package com.tongji.service;

import com.tongji.dto.MovieInfoDto;

public interface HMovieService {

    public String getMoviesByMultipleCondition(MovieInfoDto movieInfoDto);
}
