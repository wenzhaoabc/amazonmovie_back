package com.tongji.controller;

import com.tongji.dto.MovieInfoDto;
import com.tongji.service.HMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.GET;

/**
 * Hive相关的请求API
 *
 * @author 赵帅涛
 * @since 2022年12月16日
 */
@RestController
@RequestMapping("/hive")
public class HiveController {
    @Autowired
    private HMovieService hMovieService;

    @PostMapping("/movie/result")
    public ResponseEntity<String> getMovieResult(@RequestBody MovieInfoDto movieInfoDto) {
        try {
            return ResponseEntity.ok(hMovieService.getMoviesByMultipleCondition(movieInfoDto));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(400).body(null);
        }
    }

    /**
     * 和导演directorName合作最多的10位演员
     *
     * @param directorName 导演名
     * @return json time字段表示查询时间
     */
    @GetMapping("/director/actor")
    public ResponseEntity<String> getWorkMostActorByDirector(@RequestParam String directorName) {
        try {
            return ResponseEntity.ok(hMovieService.getWorkMostActorByDirector(directorName));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(400).body(null);
        }
    }

    /**
     * 和该演员合作次数最多的导演
     *
     * @param actorName 演员名
     * @return json time字段表示查询时间
     */
    @GetMapping("/actor/director")
    public ResponseEntity<String> getWorkMostActorByActor(@RequestParam String actorName) {
        try {
            return ResponseEntity.ok(hMovieService.getWorkMostActorByActor(actorName));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(400).body(null);
        }
    }

    /**
     * 和该演员合作次数最多的演员前10位
     *
     * @param actorName 演员名
     * @return json time字段表示查询时间
     */
    @GetMapping("/actor/actor")
    public ResponseEntity<String> getWorkMostDirectorByActor(@RequestParam String actorName) {
        try {
            return ResponseEntity.ok(hMovieService.getWorkMostDirectorByActor(actorName));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(400).body(null);
        }
    }
}
