package com.tongji.mapper.hive;

import com.tongji.dto.MovieInfoDto;
import com.tongji.entity.HMovieRes;
import com.tongji.entity.Movie;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HMovieMapper {
    public Movie selectById(int id);

    public List<HMovieRes> getMoviesByMultipleCondition(MovieInfoDto movieInfoDto);

}
