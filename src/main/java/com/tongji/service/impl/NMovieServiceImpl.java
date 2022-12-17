package com.tongji.service.impl;

import com.tongji.dto.MovieInfoDto;
import com.tongji.entity.Movie;
import com.tongji.service.NMovieService;
import org.neo4j.driver.Driver;
import org.neo4j.driver.Record;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;
import org.neo4j.driver.internal.value.NullValue;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Override
    public HashMap<String,Object> getMoviesByMultipleCondition(MovieInfoDto condition) {
        // match (m:Movie), (m)-[:Belong]->(c:Category{name:'DTS'}) where m.title = 'Book and Sword' return count(m)
        // where m.year*10000+m.month*100+m.day >=20101102
        // 导演：match (m:Movie), (m)<-[:MainAct]-(:Person{name:'Santana'}),(m)<-[:MainAct]-(:Person{name:'Treglia'})
        // 评分用 where
        try (Session session = driver.session()) {
            String query = "match (m:Movie) ";
            if (condition.getCategory() != null){
                query +=" , (m)-[:GENRE]->(:Genre{genre:\""+condition.getCategory()+"\"}) ";
            }

            // 导演名称
            if(condition.getDirectorNames() != null){
                for(String directorName: condition.getDirectorNames()){
                    query += " ,(m)-[:DIRECTOR_BY]->(:Director{directorName:\""+directorName+"\"})";
                }
            }

            // 主演名称
            if(condition.getMainActors() != null){
                for(String mainActor: condition.getMainActors()){
                    query += " ,(m)-[:ACTOR_IN]->(:Actor{actorName:\""+mainActor+"\"})";
                }
            }

            // 演员名称
            if(condition.getActors() != null){
                for(String actor: condition.getActors()){
                    query += " ,(m)-[:ACTOR_IN]->(:Actor{actorName:\""+actor+"\"})";
                }
            }

            Boolean whereAppear = false;
            // 电影名称
            if(condition.getMovieName() != null){
                query += " where m.title=\""+condition.getMovieName()+"\" ";
                whereAppear = true;
            }

            // 最低评分
            if (condition.getMinScore() != null){
                if (whereAppear){
                    query+= " and ";
                }
                else {
                    query += " where ";
                    whereAppear = true;
                }
                query += " toFloat(m.score) >="+ condition.getMinScore()+" ";
            }

            // 最高评分
            if (condition.getMaxScore() != null){
                if (whereAppear){
                    query+= " and ";
                }
                else {
                    query += " where ";
                    whereAppear = true;
                }
                query+=" toFloat(m.score) <= "+condition.getMaxScore()+" ";
            }


            // 上映时间
            if(condition.getMinYear()!=null){
                if (whereAppear){
                    query+= " and ";
                }
                else {
                    query += " where ";
                    whereAppear = true;
                }
                query+=" toInteger(m.year)*10000+toInteger(m.month)*100+toInteger(m.day) >= "+
                        (10000*condition.getMinYear()+100*condition.getMinMonth()+condition.getMinDay())+" ";
            }
            if(condition.getMaxYear()!=null){
                if (whereAppear){
                    query+= " and ";
                }
                else {
                    query += " where ";
                    whereAppear = true;
                }
                query+=" toInteger(m.year)*10000+toInteger(m.month)*100+toInteger(m.day) <= "+
                        (10000*condition.getMaxYear()+100*condition.getMaxMonth()+condition.getMaxDay())+" ";
            }

            if(condition.getPositive()!=null){
                if (whereAppear){
                    query+= " and ";
                }
                else {
                    query += " where ";
                    whereAppear = true;
                }
                query+=" m.positive>= "+
                        String.valueOf(condition.getPositive() * 1.0 / 100)+" ";
            }

            query+=" return m ";
            System.out.println("查询语句为: "+query);

            // 记录开始时间
            long startTime = System.currentTimeMillis();
            Result res=
                    session.run(query);




            HashMap<String,Object> response = new HashMap<>();

            List<Record> result = res.list();

            List<HashMap<String, Object>> movieResult = new ArrayList<>();
            // 记录结束时间
            long endTime = System.currentTimeMillis();
            // 返回50条
            for(int i=0;i<result.size() && i <50;++i){
                HashMap<String, Object> movieNode = new HashMap<>();
                if (result.get(i).get(0).get("movieId") != NullValue.NULL){
                    movieNode.put("asin",result.get(i).get(0).get("movieId").asString());
                }
                if (result.get(i).get(0).get("title") != NullValue.NULL){
                    movieNode.put("title",result.get(i).get(0).get("title").asString());
                }
                if (result.get(i).get(0).get("format") != NullValue.NULL){
                    movieNode.put("format",result.get(i).get(0).get("format").asString());
                }
                if (result.get(i).get(0).get("edition") != NullValue.NULL){
                    movieNode.put("edition",result.get(i).get(0).get("edition").asString());
                }
                if (result.get(i).get(0).get("score") != NullValue.NULL){
                    movieNode.put("score",String.valueOf(result.get(i).get(0).get("score")));
                }
                if (result.get(i).get(0).get("comments") != NullValue.NULL){
                    movieNode.put("commentNum",String.valueOf(result.get(i).get(0).get("comments")));
                }
                if (result.get(i).get(0).get("year") != NullValue.NULL){
                    movieNode.put("year",String.valueOf(result.get(i).get(0).get("year")));
                }
                if (result.get(i).get(0).get("month") != NullValue.NULL){
                    movieNode.put("month",String.valueOf(result.get(i).get(0).get("month")));
                }
                if (result.get(i).get(0).get("day") != NullValue.NULL){
                    movieNode.put("day",String.valueOf(result.get(i).get(0).get("day")));
                }
                movieResult.add(movieNode);
            }


            response.put("movies",movieResult);
            response.put("movieNum",result.size());
            response.put("time",endTime-startTime);
            System.out.println(response);

            return response;
        }
    }

    @Override
    public HashMap<String, Object> findMostCooperateActors(String actorName) {
        try (Session session = driver.session()) {
            // 记录开始时间
            long startTime = System.currentTimeMillis();
            System.out.println(actorName);
            Result res=
                    session.run("Match (p:Actor)<-[r:ACTOR_IN]-(m:Movie)-[a:ACTOR_IN]->(q:Actor) " +
                            "where id(p)<> id(q) and p.actorName='"+actorName+"' return q.actorName,count(m) order by count(m) desc limit 1");

            // 记录结束时间
            long endTime = System.currentTimeMillis();

            List<Record> relation = res.list();
            HashMap<String,Object> response = new HashMap<>();

            List<String> actors= new ArrayList<>();
            if(relation.size()==0){
                return null;
            }
            actors.add(relation.get(0).get(0).asString());
            response.put("actor",actors);
            response.put("number",relation.get(0).get(1).toString());
            response.put("time",endTime-startTime);
            System.out.println(response);
            return response;
        }
    }

    @Override
    public HashMap<String, Object> findMostCooperateActorAndDirector(String actorName) {
        try (Session session = driver.session()) {
            // 记录开始时间
            long startTime = System.currentTimeMillis();
            Result res=
                    session.run("Match (p:Actor)<-[r:ACTOR_IN]-(m:Movie)-[a:DIRECTOR_BY]->(q:Director) " +
                            "where p.actorName='"+actorName+"' return q.directorName,count(m) order by count(m) desc limit 1");

            // 记录结束时间
            long endTime = System.currentTimeMillis();

            List<Record> relation = res.list();
            HashMap<String,Object> response = new HashMap<>();
            response.put("director",relation.get(0).get(0).asString());
            response.put("number",relation.get(0).get(1).toString());
            response.put("time",endTime-startTime);
            System.out.println(response);
            return response;
        }
    }

    @Override
    public HashMap<String, Object> findMostCooperateDirectorAndActor(String directorName) {
        try (Session session = driver.session()) {
            // 记录开始时间
            long startTime = System.currentTimeMillis();
            Result res=
                    session.run("Match (p:Actor)<-[r:ACTOR_IN]-(m:Movie)-[a:DIRECTOR_BY]->(q:Director) " +
                            "where q.directorName='"+directorName+"' return p.actorName,count(m) order by count(m) desc limit 1");

            // 记录结束时间
            long endTime = System.currentTimeMillis();

            List<Record> relation = res.list();
            HashMap<String,Object> response = new HashMap<>();
            response.put("actor",relation.get(0).get(0).asString());
            response.put("number",relation.get(0).get(1).toString());
            response.put("time",endTime-startTime);
            System.out.println(response);
            return response;
        }
    }
}
