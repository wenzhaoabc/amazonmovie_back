package com.tongji.mapper.hive;

import com.tongji.entity.Movie;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HMovieMapper {
    public Movie selectById(int id);

}
