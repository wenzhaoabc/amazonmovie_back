package com.tongji.dto;

/**
 * 导演与演员之间的合作次数
 *
 * @author 赵帅涛
 * @since 2022年12月17日
 */
public class CooperateNum {
    private String name;
    private Integer num;

    public CooperateNum() {
    }

    public CooperateNum(String name, Integer num) {
        this.name = name;
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
