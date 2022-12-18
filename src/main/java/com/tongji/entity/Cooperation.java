package com.tongji.entity;

import lombok.Data;

@Data
public class Cooperation implements Comparable<Cooperation>{
    private String name;
    private int times;
    @Override
    public int compareTo(Cooperation p) {
        return this.getTimes() - p.getTimes();
    }

}
