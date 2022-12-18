package com.tongji.mapper.mysql;

import com.tongji.dto.MovieInfoDto;
import com.tongji.entity.Cooperation;
import com.tongji.entity.MMovieRes;
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

    List<String> getMovieNameByStr(String movieName);

    List<String> getDirectorNameByStr(String directorName);

    List<String> getActorNameByStr(String actorName);

    List<String> getCategoryNameByStr(String category);

    String getAllDirectorsByMovieAsin(String movieAsin);

    String getAllMainActorsByMovieAsin(String movieAsin);

    List<MMovieRes> getMoviesByMultipleCondition(MovieInfoDto movieInfoDto);

    List<Cooperation> getActorsNameByDirector(String directorName);

    List<Cooperation> getDirectorsNameByActor(String actorName);

    List<Cooperation> getActorsNameByActor(String actorName);

    List<Cooperation> getActorsName2ByActor(String actorName);
}
