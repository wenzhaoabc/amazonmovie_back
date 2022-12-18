package com.tongji.service.impl;

import com.tongji.dto.MovieInfoDto;
import com.tongji.entity.Cooperation;
import com.tongji.entity.MMovieRes;
import com.tongji.mapper.mysql.MMovieMapper;
import com.tongji.service.MMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

@Service
public class MMovieServiceImpl implements MMovieService {
    @Autowired
    private MMovieMapper movieMapper;
    @Override
    public List<String> getMovieNameByStr(String movieName){
       List<String> list=movieMapper.getMovieNameByStr(movieName);
       return list;
    }
    @Override
    public List<String> getDirectorNameByStr(String directorName){
        List<String> list=movieMapper.getDirectorNameByStr(directorName);
        return list;
    }
    @Override
    public List<String> getActorNameByStr(String actorName){
        List<String> list=movieMapper.getActorNameByStr(actorName);
        return list;
    }
    @Override
    public List<String> getCategoryNameByStr(String category){
        List<String> list=movieMapper.getCategoryNameByStr(category);
        return list;
    }
    @Override
    public List<String> getAllDirectorsByMovieAsin(String movieAsin){
        String str=movieMapper.getAllDirectorsByMovieAsin(movieAsin);
        List<String> list= List.of(str.split(","));
        return list;
    }
    @Override
    public List<String> getAllMainActorsByMovieAsin(String movieAsin){
        String str=movieMapper.getAllMainActorsByMovieAsin(movieAsin);
        List<String> list= List.of(str.split(","));
        return list;
    }
    @Override
    public HashMap<String,Object>  getMovieResultsByMutipleRules(MovieInfoDto movieInfoDto) {
        HashMap<String, Object> res = new HashMap<>();
        Long startTime = System.currentTimeMillis();
        List<MMovieRes> movies = new ArrayList<>();
        try {
            movies = movieMapper.getMoviesByMultipleCondition(movieInfoDto);
        } catch (Exception e) {
            movies = new ArrayList<>();
        }
        Long endTime = System.currentTimeMillis();
        res.put("movies", movies);
        res.put("time", (endTime - startTime) / 1000 / 60);
        res.put("movieNum", movies.size());
        return res;
    }
    @Override
    public HashMap<String,Object> getMaxCooperationTimeOfDirectors(String directorName){
        HashMap<String, Object> res = new HashMap<>();
        List<Cooperation> list=movieMapper.getActorsNameByDirector(directorName);
        List<String> names=new ArrayList<>();
        List<Integer> times=new ArrayList<>();
        if(list.size()>5){
            list.subList(0,list.size()-5).clear();
        }
        for (Cooperation coo :list){
            names.add(coo.getName());
            times.add(coo.getTimes());
        }
        res.put("name",names);
        res.put("cooperationNum",times);
        return res;
    }
    @Override
    public HashMap<String,Object> getMaxCooperationTimeOfActors(String actorName){
        HashMap<String, Object> res = new HashMap<>();
        List<Cooperation> list=movieMapper.getActorsNameByActor(actorName);
        List<Cooperation> list2=movieMapper.getActorsName2ByActor(actorName);
        list.addAll(list2);
        Collections.sort(list);
        List<String> names=new ArrayList<>();
        List<Integer> times=new ArrayList<>();
        if(list.size()>5){
            list.subList(0,list.size()-5).clear();
        }
        for (Cooperation coo :list){
            names.add(coo.getName());
            times.add(coo.getTimes());
        }
        res.put("name",names);
        res.put("cooperationNum",times);
        return res;
    }
    @Override
    public HashMap<String,Object> getMaxCooperationTimeOfActorsAndDiectors(String actorName){
        HashMap<String, Object> res = new HashMap<>();
        List<Cooperation> list=movieMapper.getDirectorsNameByActor(actorName);
        List<String> names=new ArrayList<>();
        List<Integer> times=new ArrayList<>();
        if(list.size()>5){
            list.subList(0,list.size()-5).clear();
        }
        for (Cooperation coo :list){
            names.add(coo.getName());
            times.add(coo.getTimes());
        }
        res.put("name",names);
        res.put("cooperationNum",times);
        return res;
    }


}
