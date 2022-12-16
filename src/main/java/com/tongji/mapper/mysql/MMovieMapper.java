package com.tongji.mapper.mysql;

import com.tongji.entity.Movie;
import com.tongji.entity.Origin;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component
@Repository
@Mapper
public interface MMovieMapper {
    public Movie selectById(String id);

    List<Origin> getOrigin(String title);
}
