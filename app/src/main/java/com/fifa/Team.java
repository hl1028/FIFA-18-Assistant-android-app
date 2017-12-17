package com.fifa;

/**
 * Created by qiyuanxu on 12/16/17.
 */

public class Team {
    private int id;
    private int apiId;
    private int fifaId;
    private String longName;
    private String shortName;
    private String date;
    private int buildUpPlaySpeed;
    private String buildUpPlaySpeedClass;
    private int buildUpPlayDribbling;
    private String buildUpPlayDribblingClass;
    private int buildUpPlayPassing;
    private String buildUpPlayPassingClass;

    public Team(int id, int apiId, int fifaId, String longName, String shortName) {
        this.id = id;
        this.apiId = apiId;
        this.fifaId = fifaId;
        this.longName = longName;
        this.shortName = shortName;
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", apiId=" + apiId +
                ", fifaId=" + fifaId +
                ", longName='" + longName + '\'' +
                ", shortName='" + shortName + '\'' +
                ", date='" + date + '\'' +
                ", buildUpPlaySpeed=" + buildUpPlaySpeed +
                ", buildUpPlaySpeedClass='" + buildUpPlaySpeedClass + '\'' +
                ", buildUpPlayDribbling=" + buildUpPlayDribbling +
                ", buildUpPlayDribblingClass='" + buildUpPlayDribblingClass + '\'' +
                ", buildUpPlayPassing=" + buildUpPlayPassing +
                ", buildUpPlayPassingClass='" + buildUpPlayPassingClass + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getApiId() {
        return apiId;
    }

    public void setApiId(int apiId) {
        this.apiId = apiId;
    }

    public int getFifaId() {
        return fifaId;
    }

    public void setFifaId(int fifaId) {
        this.fifaId = fifaId;
    }

    public String getLongName() {
        return longName;
    }

    public void setLongName(String longName) {
        this.longName = longName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getBuildUpPlaySpeed() {
        return buildUpPlaySpeed;
    }

    public void setBuildUpPlaySpeed(int buildUpPlaySpeed) {
        this.buildUpPlaySpeed = buildUpPlaySpeed;
    }

    public String getBuildUpPlaySpeedClass() {
        return buildUpPlaySpeedClass;
    }

    public void setBuildUpPlaySpeedClass(String buildUpPlaySpeedClass) {
        this.buildUpPlaySpeedClass = buildUpPlaySpeedClass;
    }

    public int getBuildUpPlayDribbling() {
        return buildUpPlayDribbling;
    }

    public void setBuildUpPlayDribbling(int buildUpPlayDribbling) {
        this.buildUpPlayDribbling = buildUpPlayDribbling;
    }

    public String getBuildUpPlayDribblingClass() {
        return buildUpPlayDribblingClass;
    }

    public void setBuildUpPlayDribblingClass(String buildUpPlayDribblingClass) {
        this.buildUpPlayDribblingClass = buildUpPlayDribblingClass;
    }

    public int getBuildUpPlayPassing() {
        return buildUpPlayPassing;
    }

    public void setBuildUpPlayPassing(int buildUpPlayPassing) {
        this.buildUpPlayPassing = buildUpPlayPassing;
    }

    public String getBuildUpPlayPassingClass() {
        return buildUpPlayPassingClass;
    }

    public void setBuildUpPlayPassingClass(String buildUpPlayPassingClass) {
        this.buildUpPlayPassingClass = buildUpPlayPassingClass;
    }
}