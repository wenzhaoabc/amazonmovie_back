package com.tongji.service;

import com.tongji.entity.Movie;
import com.tongji.entity.Origin;

import java.util.List;

public interface MovieService {
    public Movie getById(String id);

    List<Origin> getOrigin(String title);
}
