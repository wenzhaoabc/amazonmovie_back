package com.tongji.mapper.hive;

import com.tongji.dto.CooperateNum;
import com.tongji.dto.MovieInfoDto;
import com.tongji.entity.HMovieRes;
import com.tongji.entity.Movie;
import org.apache.ibatis.annotations.Mapper;

import java.security.PublicKey;
import java.util.List;

/**
 * Hive相关的查询操作
 *
 * @author 赵帅涛
 * @since 2022年12月17日
 */
@Mapper
public interface HMovieMapper {
    public Movie selectById(int id);

    public List<HMovieRes> getMoviesByMultipleCondition(MovieInfoDto movieInfoDto);

    // 获取与该导演合作次数最多的演员前10
    public List<CooperateNum> getWorkMostActorByDirector(String directorName);

    // 获取与演员合作次数最多的演员前10
    public List<CooperateNum> getWorkMostActorByActor(String actorName);

    // 获取与该演员合作次数最多的导演前10
    public List<CooperateNum> getWorkMostDirectorByActor(String actorName);
}
