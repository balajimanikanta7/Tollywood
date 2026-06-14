package com.example.tollywood;

public class Movie {
    private int id;
    private int heroId;
    private String title;
    private String releaseDate;
    private String boxOffice;
    private String verdict;
    private String ottPlatform;
    private String posterUrl;

    public Movie(int id, int heroId, String title, String releaseDate,
                 String boxOffice, String verdict, String ottPlatform,
                 String posterUrl) {
        this.id = id;
        this.heroId = heroId;
        this.title = title;
        this.releaseDate = releaseDate;
        this.boxOffice = boxOffice;
        this.verdict = verdict;
        this.ottPlatform = ottPlatform;
        this.posterUrl = posterUrl;
    }

    public int getId() { return id; }
    public int getHeroId() { return heroId; }
    public String getTitle() { return title; }
    public String getReleaseDate() { return releaseDate; }
    public String getBoxOffice() { return boxOffice; }
    public String getVerdict() { return verdict; }
    public String getOttPlatform() { return ottPlatform; }
    public String getPosterUrl() { return posterUrl; }
}
