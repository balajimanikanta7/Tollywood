package com.example.tollywood;

public class Hero {
    private int id;
    private String name;
    private String tier;
    private String photoUrl;

    public Hero(int id, String name, String tier, String photoUrl) {
        this.id = id;
        this.name = name;
        this.tier = tier;
        this.photoUrl = photoUrl;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getTier() { return tier; }
    public String getPhotoUrl() { return photoUrl; }
}
