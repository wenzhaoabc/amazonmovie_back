package com.tongji.entity;

public class MMovieRes {
    private String asin;
    private String title;
    private Float score;
    private Integer commentNum;
    private String genres;
    private String actors;
    private String directors;

    public MMovieRes(String asin, String title, Float score, Integer commentNum,  String genres, String actors, String directors) {
        this.asin = asin;
        this.title = title;
        this.score = score;
        this.commentNum = commentNum;
        this.genres = genres;
        this.actors = actors;
        this.directors = directors;
    }

    public String getAsin() {
        return asin;
    }

    public void setAsin(String asin) {
        this.asin = asin;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }

    public Integer getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(Integer commentNum) {
        this.commentNum = commentNum;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getDirectors() {
        return directors;
    }

    public void setDirectors(String directors) {
        this.directors = directors;
    }
}
