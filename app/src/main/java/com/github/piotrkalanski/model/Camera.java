package com.github.piotrkalanski.model;

public class Camera {
    private final String id;
    private final String model;
    private final String description;

    public Camera(String id, String modelId, String description) {
        this.id = id;
        this.model = modelId;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public String getDescription() {
        return description;
    }
}
