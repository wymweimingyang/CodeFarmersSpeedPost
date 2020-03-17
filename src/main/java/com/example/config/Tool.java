package com.example.config;

public class Tool {
    /**
     * 哦工具，用来存储筛选信息
     */
    private String education;
    private int years;
    private String wtype;
    private int yx;
    public Tool(String education,int years,String wtype,int yx){
        this.education=education;
        this.years=years;
        this.wtype=wtype;
        this.yx=yx;
    }
    public int getYears() {
        return years;
    }

    public int getYx() {
        return yx;
    }

    public String getEducation() {
        return education;
    }

    public String getWtype() {
        return wtype;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public void setWtype(String wtype) {
        this.wtype = wtype;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public void setYx(int yx) {
        this.yx = yx;
    }
    public Tool(){

    }

}
