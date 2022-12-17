package com.tongji.dto;

import java.util.List;

/**
 * 电影信息
 *
 * @author 赵帅涛
 * @since 2022年12月16日
 */
public class MovieInfoDto {
    private String movieName;
    private String category;
    private List<String> directorNames;
    private List<String> mainActors;
    private List<String> actors;
    private String minScore;
    private String maxScore;
    private Integer minYear;
    private Integer minMonth;
    private Integer minDay;
    private Integer maxYear;
    private Integer maxMonth;
    private Integer maxDay;
    private Integer positive;

    public MovieInfoDto() {
    }

    public MovieInfoDto(String movieName, String category,
                        List<String> directorNames, List<String> mainActors,
                        List<String> actors, String minScore,
                        String maxScore, Integer minYear,
                        Integer minMonth, Integer minDay,
                        Integer maxYear, Integer maxMonth,
                        Integer maxDay, Integer positive) {
        this.movieName = movieName;
        this.category = category;
        this.directorNames = directorNames;
        this.mainActors = mainActors;
        this.actors = actors;
        this.minScore = minScore;
        this.maxScore = maxScore;
        this.minYear = minYear;
        this.minMonth = minMonth;
        this.minDay = minDay;
        this.maxYear = maxYear;
        this.maxMonth = maxMonth;
        this.maxDay = maxDay;
        this.positive = positive;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<String> getDirectorNames() {
        return directorNames;
    }

    public void setDirectorNames(List<String> directorNames) {
        this.directorNames = directorNames;
    }

    public List<String> getMainActors() {
        return mainActors;
    }

    public void setMainActors(List<String> mainActors) {
        this.mainActors = mainActors;
    }

    public List<String> getActors() {
        return actors;
    }

    public void setActors(List<String> actors) {
        this.actors = actors;
    }

    public String getMinScore() {
        return minScore;
    }

    public void setMinScore(String minScore) {
        this.minScore = minScore;
    }

    public String getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(String maxScore) {
        this.maxScore = maxScore;
    }

    public Integer getMinYear() {
        return minYear;
    }

    public void setMinYear(Integer minYear) {
        this.minYear = minYear;
    }

    public Integer getMinMonth() {
        return minMonth;
    }

    public void setMinMonth(Integer minMonth) {
        this.minMonth = minMonth;
    }

    public Integer getMinDay() {
        return minDay;
    }

    public void setMinDay(Integer minDay) {
        this.minDay = minDay;
    }

    public Integer getMaxYear() {
        return maxYear;
    }

    public void setMaxYear(Integer maxYear) {
        this.maxYear = maxYear;
    }

    public Integer getMaxMonth() {
        return maxMonth;
    }

    public void setMaxMonth(Integer maxMonth) {
        this.maxMonth = maxMonth;
    }

    public Integer getMaxDay() {
        return maxDay;
    }

    public void setMaxDay(Integer maxDay) {
        this.maxDay = maxDay;
    }

    public Integer getPositive() {
        return positive;
    }

    public void setPositive(Integer positive) {
        this.positive = positive;
    }
}
