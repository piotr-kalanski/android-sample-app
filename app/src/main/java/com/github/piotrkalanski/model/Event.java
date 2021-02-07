package com.github.piotrkalanski.model;

import java.io.Serializable;

public class Event implements Serializable {
    private final String id;
    private final String time; // TODO - change type
    private final String title;
    private final String url;

    public Event(String id, String time, String description, String url) {
        this.id = id;
        this.title = description;
        this.url = url;
        this.time = time;
    }

    public String getId() {
        return id;
    }

    public String getTime() {
        //return time;
        return "2021-01-01 10:03:00"; // TODO - don't hardcode time value
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }
}
