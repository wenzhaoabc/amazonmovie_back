package com.tongji.controller;

import com.tongji.dto.MovieInfoDto;
import com.tongji.service.HMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
