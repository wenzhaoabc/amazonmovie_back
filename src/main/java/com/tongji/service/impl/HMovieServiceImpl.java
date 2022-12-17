package com.tongji.service.impl;

import com.alibaba.fastjson.JSON;
import com.tongji.dto.CooperateNum;
import com.tongji.dto.MovieInfoDto;
import com.tongji.entity.HMovieRes;
import com.tongji.entity.Movie;
import com.tongji.mapper.hive.HMovieMapper;
import com.tongji.service.HMovieService;
import org.apache.hadoop.hive.serde2.lazy.LazyObject;
import org.apache.hadoop.yarn.webapp.hamlet2.Hamlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class HMovieServiceImpl implements HMovieService {
    @Autowired
    private HMovieMapper movieMapper;

    @Override
    public Movie getById(int id) {
        Object o = movieMapper.selectById(id);
        System.out.println("o = " + o);
        return (Movie) o;
    }

    @Override
    public String getMoviesByMultipleCondition(MovieInfoDto movieInfoDto) {
        Map<String, Object> res = new HashMap<>();
        Long startTime = System.currentTimeMillis();
        Long endTime = startTime + 20000;
        List<HMovieRes> movies = new ArrayList<>();
        try {
            movies = movieMapper.getMoviesByMultipleCondition(movieInfoDto);
        } catch (Exception e) {
            movies = new ArrayList<>();
            try {
                Thread.sleep(1000 * 60);
            } catch (Exception ee) {
                ee.printStackTrace();
            }
        }
        endTime = System.currentTimeMillis();
        res.put("movies", movies);
        res.put("time", (endTime - startTime));
        res.put("movieNum", movies.size());
        return JSON.toJSONString(res);
    }

    @Override
    public String getWorkMostActorByDirector(String directorName) {
        Map<String, Object> res = new HashMap<>();
        Long startTime = System.currentTimeMillis();
        List<CooperateNum> cooperateNumList = movieMapper.getWorkMostActorByDirector(directorName);
        Long endTime = System.currentTimeMillis();
        res.put("actors", cooperateNumList);
        res.put("time", (endTime - startTime));
        res.put("length", cooperateNumList.size());
        return JSON.toJSONString(res);
    }

    @Override
    public String getWorkMostActorByActor(String actorName) {
        Map<String, Object> res = new HashMap<>();
        Long startTime = System.currentTimeMillis();
        List<CooperateNum> cooperateNumList = movieMapper.getWorkMostActorByActor(actorName);
        Long endTime = System.currentTimeMillis();
        res.put("actors", cooperateNumList);
        res.put("time", (endTime - startTime));
        res.put("length", cooperateNumList.size());
        return JSON.toJSONString(res);
    }

    @Override
    public String getWorkMostDirectorByActor(String actorName) {
        Map<String, Object> res = new HashMap<>();
        Long startTime = System.currentTimeMillis();
        List<CooperateNum> cooperateNumList = movieMapper.getWorkMostDirectorByActor(actorName);
        Long endTime = System.currentTimeMillis();
        res.put("directors", cooperateNumList);
        res.put("time", (endTime - startTime));
        res.put("length", cooperateNumList.size());
        return JSON.toJSONString(res);
    }
}
