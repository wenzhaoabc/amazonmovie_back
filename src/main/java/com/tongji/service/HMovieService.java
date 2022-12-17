package com.tongji.service;

import com.tongji.dto.CooperateNum;
import com.tongji.dto.MovieInfoDto;

import java.util.List;

public interface HMovieService {

    public String getMoviesByMultipleCondition(MovieInfoDto movieInfoDto);

    // 获取与该导演合作次数最多的演员前10
    public String getWorkMostActorByDirector(String directorName);

    // 获取与演员合作次数最多的演员前10
    public String getWorkMostActorByActor(String actorName);

    // 获取与该演员合作次数最多的导演前10
    public String getWorkMostDirectorByActor(String actorName);
}
