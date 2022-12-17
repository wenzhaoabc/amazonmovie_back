package com.tongji.service;

import com.tongji.dto.MovieInfoDto;
import com.tongji.entity.Movie;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author : 王晨
 * @Date : Created in 18:58 2022/12/10
 */
public interface NMovieService {
    public Movie getMovieById(int id) ;

    public HashMap<String,Object> getMoviesByMultipleCondition(MovieInfoDto condition);

    public HashMap<String,Object> findMostCooperateActors(String actorName);

    public HashMap<String,Object> findMostCooperateActorAndDirector(String actorName);

    public HashMap<String,Object> findMostCooperateDirectorAndActor(String directorName);
}
