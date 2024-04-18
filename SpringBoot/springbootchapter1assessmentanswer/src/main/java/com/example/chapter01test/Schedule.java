package com.example.chapter01test;

import java.time.LocalDateTime;

public class Schedule {
    private int id; // ID

    private String name; // スケジュール名

    private LocalDateTime startDateTime; // 開始時間

    private double duration; // 所要時間

    private String location; // 場所

    public Schedule(int id, String name, LocalDateTime startDateTime, double duration, String location) {
        this.id = id;
        this.name = name;
        this.startDateTime = startDateTime;
        this.duration = duration;
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(LocalDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
