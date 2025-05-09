package com.example.lab4;

public class SportEvent {
    private String type;
    private String stadium;
    private String country;
    private String region;
    private String tournament;
    private String startTime;
    private String match;

    public SportEvent(String type, String stadium, String country, String region,
                      String tournament, String startTime, String match) {
        this.type = type;
        this.stadium = stadium;
        this.country = country;
        this.region = region;
        this.tournament = tournament;
        this.startTime = startTime;
        this.match = match;
    }

    // Getters
    public String getType() { return type; }
    public String getStadium() { return stadium; }
    public String getCountry() { return country; }
    public String getRegion() { return region; }
    public String getTournament() { return tournament; }
    public String getStartTime() { return startTime; }
    public String getMatch() { return match; }
}