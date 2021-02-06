package com.github.piotrkalanski.model;

import java.io.Serializable;

public class Event implements Serializable {
    private final String id;
    private final String time; // TODO - change type
    private final String description;

    public Event(String id, String time, String description) {
        this.id = id;
        this.time = time;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public String getTime() {
        return time;
    }

    public String getDescription() {
        return description;
    }
}
