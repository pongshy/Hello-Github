package com.shu.labrary.pojo;

public class Famousteacher {
    private Integer teacherid;

    private String introductions;

    public Integer getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(Integer teacherid) {
        this.teacherid = teacherid;
    }

    public String getIntroductions() {
        return introductions;
    }

    public void setIntroductions(String introductions) {
        this.introductions = introductions == null ? null : introductions.trim();
    }
}