package com.tongji.controller;

import com.tongji.dto.MovieInfoDto;
import com.tongji.service.NMovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * @Author : 王晨
 * @Date : Created in 16:29 2022/12/17
 */
@RestController
@RequestMapping("/api/neo4j")
public class Neo4jController {
    @Resource
    NMovieService nMovieService;

    @PostMapping("/movie/result")
    public ResponseEntity<HashMap<String,Object>> getMovieResult(@RequestBody MovieInfoDto movieInfoDto) {
        try {
            return ResponseEntity.ok(nMovieService.getMoviesByMultipleCondition(movieInfoDto));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(400).body(null);
        }
    }

    @GetMapping("/relationship/actors")
    public ResponseEntity<HashMap<String, Object>> findMostCooperateActors(@RequestParam(value = "actorName") String actorName) {
        try {
            System.out.println(actorName);
            return ResponseEntity.ok(nMovieService.findMostCooperateActors(actorName));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(400).body(null);
        }
    }

    @GetMapping("/relationship/actorAndDirector")
    public ResponseEntity<HashMap<String, Object>> findMostCooperateActorAndDirector(@RequestParam(value = "actorName") String actorName){
        try {
            return ResponseEntity.ok(nMovieService.findMostCooperateActorAndDirector(actorName));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(400).body(null);
        }
    }

    @GetMapping("/relationship/directorAndActor")
    public ResponseEntity<HashMap<String, Object>> findMostCooperateDirectorAndActor(@RequestParam(value = "directorName") String directorName){
        try {
            return ResponseEntity.ok(nMovieService.findMostCooperateDirectorAndActor(directorName));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(400).body(null);
        }
    }
}
