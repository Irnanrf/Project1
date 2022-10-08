package com.lunarvnx.shortvideoplayer;

public class VideoModel {
    private String name;
    private String description;
    private String res;
    private String location;

    public VideoModel(String name, String description, String res,String location){
        this.name = name;
        this.description = description;
        this.res = res;
        this.location = location;
    }

    public String getName(){ return this.name; }
    public String getDescription(){ return this.description; }
    public String getRes(){ return this.res; }
    public String getLocation(){ return this.location; }

}
