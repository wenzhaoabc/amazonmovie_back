package com.tongji.service;

import com.tongji.dto.MovieInfoDto;

import java.util.HashMap;
import java.util.List;

public interface MMovieService {

    public List<String> getMovieNameByStr(String movieName);
    public List<String> getDirectorNameByStr(String directorName);
    public List<String> getActorNameByStr(String actorName);
    public List<String> getCategoryNameByStr(String category);
    public List<String> getAllDirectorsByMovieAsin(String movieAsin);
    public List<String> getAllMainActorsByMovieAsin(String movieAsin);
    public HashMap<String,Object> getMovieResultsByMutipleRules(MovieInfoDto movieInfoDto);
    public HashMap<String,Object> getMaxCooperationTimeOfDirectors(String directorName);
    public HashMap<String,Object> getMaxCooperationTimeOfActors(String actorName);
    public HashMap<String,Object> getMaxCooperationTimeOfActorsAndDiectors(String actorName);
}
