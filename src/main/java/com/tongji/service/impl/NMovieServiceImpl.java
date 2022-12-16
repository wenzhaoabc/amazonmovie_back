package com.tongji.service.impl;

import com.tongji.entity.Movie;
import com.tongji.service.NMovieService;
import org.neo4j.driver.Driver;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;
import org.springframework.stereotype.Service;

/**
 * @Author : 王晨
 * @Date : Created in 18:58 2022/12/10
 */
@Service
public class NMovieServiceImpl implements NMovieService {

    private final Driver driver;

    public NMovieServiceImpl(Driver driver) {
        this.driver = driver;
    }

    @Override
    public Movie getMovieById(int id) {
        try(Session session=driver.session()){
            Result res=
                    session.run("match (n:Movie) where n.movieId=('"+id+"')  return n.title");
            System.out.println(res
                    .list(r -> r.get(0).asString()));
            while (res.hasNext()) {
                System.out.println(res.next().get(0).asString());
            }
            return null;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
