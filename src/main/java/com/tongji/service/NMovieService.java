package com.tongji.service;

import com.tongji.entity.Movie;
import org.springframework.stereotype.Service;

/**
 * @Author : 王晨
 * @Date : Created in 18:58 2022/12/10
 */
@Service
public interface NMovieService {
    public Movie getMovieById(int id);


}
