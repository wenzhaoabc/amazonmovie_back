package com.tongji.controller;

import com.tongji.dto.MovieInfoDto;
import com.tongji.service.MMovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/mysql/association")
public class MysqlController {

    @Resource
    MMovieService associationService;

    @RequestMapping(value = "/movie",method = RequestMethod.GET)
    public ResponseEntity<List<String>> getMovieNameListByString(
            @RequestParam(value = "movieName")String movieName
    ){
        return new ResponseEntity<>(associationService.getMovieNameByStr(movieName), HttpStatus.OK);
    }

    @RequestMapping(value = "/director",method = RequestMethod.GET)
    public ResponseEntity<List<String>> getDirectorNameListByString(
            @RequestParam(value = "directorName")String directorName
    ){
        return new ResponseEntity<>(associationService.getDirectorNameByStr(directorName), HttpStatus.OK);
    }

    @RequestMapping(value = "/actor",method = RequestMethod.GET)
    public ResponseEntity<List<String>> getActorNameListByString(
            @RequestParam(value = "actorName")String actorName
    ){
        return new ResponseEntity<>(associationService.getActorNameByStr(actorName), HttpStatus.OK);
    }

    @RequestMapping(value = "/category", method = RequestMethod.GET)
    public ResponseEntity<List<String>> getCategoryListByString(
            @RequestParam(value = "category") String category
    ){
        return new ResponseEntity<>(associationService.getCategoryNameByStr(category), HttpStatus.OK);
    }

    @RequestMapping(value = "/movie/director", method = RequestMethod.GET)
    public ResponseEntity<HashMap<String, Object>> getMovieDirectorByMovieAsin(
            @RequestParam(value = "movieAsin") String movieAsin,
            @RequestParam(value = "index") Integer index
    ){
        HashMap<String, Object> res = new HashMap<>();
        res.put("index", index);
        res.put("director", associationService.getAllDirectorsByMovieAsin(movieAsin));
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @RequestMapping(value = "/movie/mainActor", method = RequestMethod.GET)
    public ResponseEntity<HashMap<String, Object>> getMovieMainActorByMovieAsin(
            @RequestParam(value = "movieAsin") String movieAsin,
            @RequestParam(value = "index") Integer index
    ){
        HashMap<String, Object> res = new HashMap<>();
        res.put("index", index);
        res.put("mainActor", associationService.getAllMainActorsByMovieAsin(movieAsin));
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @RequestMapping(value = "/movie/actor", method = RequestMethod.GET)
    public ResponseEntity<HashMap<String, Object>> getMovieActorByMovieAsin(
            @RequestParam(value = "movieAsin") String movieAsin,
            @RequestParam(value = "index") Integer index
    ){
        HashMap<String, Object> res = new HashMap<>();
        res.put("index", index);
        res.put("actor", associationService.getAllMainActorsByMovieAsin(movieAsin));
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

//    @RequestMapping(value = "movie/actors", method = RequestMethod.GET)
//    public ResponseEntity<List<HashMap<String, Object>>> getMovieByActorAndActor(
//            @RequestParam(value = "actor1") String actor1,
//            @RequestParam(value = "actor2") String actor2
//    ){
//        return new ResponseEntity<>(associationService.getMovieNameByActorAndActor(actor1, actor2),
//                HttpStatus.OK);
//    }

//    @RequestMapping(value = "movie/actorAndDirector", method = RequestMethod.GET)
//    public ResponseEntity<List<HashMap<String, Object>>> getMovieByActorAndDirector(
//            @RequestParam(value = "actorName") String actorName,
//            @RequestParam(value = "directorName") String directorName
//    ){
//        return new ResponseEntity<>(associationService.getMovieNameByActorAndDirector(actorName, directorName),
//                HttpStatus.OK);
//    }
//
    @RequestMapping(value = "/director/cooperation",method = RequestMethod.GET)
    public ResponseEntity<HashMap<String,Object>> getDirectorActorCooperationTime(String directorName){
        //记录开始时间
        long startTime = System.currentTimeMillis();
        HashMap<String,Object> res= new HashMap<>();;
        HashMap<String,Object> result = associationService.getMaxCooperationTimeOfDirectors(directorName);
        long endTime = System.currentTimeMillis();
        res.put("actors",result);
        res.put("time",endTime-startTime);
        return  new ResponseEntity<>(res,HttpStatus.OK);
    }


    @RequestMapping(value = "/actor/cooperation", method = RequestMethod.GET)

    public ResponseEntity<HashMap<String,Object>> getActorsCooperationTime(String actorName){
        // 记录开始时间
        long startTime = System.currentTimeMillis();
        HashMap<String,Object> res= new HashMap<>();;
        HashMap<String,Object> result = associationService.getMaxCooperationTimeOfActors(actorName);
        long endTime = System.currentTimeMillis();
        res.put("actors",result);
        res.put("time",endTime-startTime);
        return new ResponseEntity<>(res,HttpStatus.OK);
    }



    @RequestMapping(value = "/actor/director/cooperation",method = RequestMethod.GET)
    public ResponseEntity<HashMap<String,Object>> getActorDirectorCooperationTime(String actorName){
        long startTime = System.currentTimeMillis();
        HashMap<String,Object> res= new HashMap<>();;
        HashMap<String,Object> result = associationService.getMaxCooperationTimeOfActorsAndDiectors(actorName);
        long endTime = System.currentTimeMillis();
        res.put("directors",result);
        res.put("time",endTime-startTime);
        return new ResponseEntity<>(res,HttpStatus.OK);
    }


    @RequestMapping(value = "/movie/result", method = RequestMethod.POST)
    public ResponseEntity<HashMap<String,Object>> getMovieResult(
            @RequestBody MovieInfoDto movieInfoDto
    ){
        HashMap<String,Object> result = associationService.getMovieResultsByMutipleRules(movieInfoDto);
        return new ResponseEntity<>(result,HttpStatus.OK);

    }



}
