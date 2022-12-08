package com.tongji.mapper.mysql;

import com.tongji.entity.Movie;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface MMovieMapper {
    public Movie selectById(String id);
}
