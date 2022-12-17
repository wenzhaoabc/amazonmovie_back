package com.tongji.entity;

/**
 * hive查询电影结果实体类型
 *
 * @author 赵帅涛
 * @since 2022年12月17日
 */
public class HMovieRes {
    // 在hive中实际存储电影序号，此处asin为1，2，3，
    private String asin;
    private String title;
    private String edition;
    private Float score;
    private Integer commentNum;
    private Integer year;
    private Integer month;
    private Integer day;

    public HMovieRes() {
    }

    public HMovieRes(String asin, String title, String edition, Float score, Integer commentNum, Integer year, Integer month, Integer day) {
        this.asin = asin;
        this.title = title;
        this.edition = edition;
        this.score = score;
        this.commentNum = commentNum;
        this.year = year;
        this.month = month;
        this.day = day;
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

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
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

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }
}
