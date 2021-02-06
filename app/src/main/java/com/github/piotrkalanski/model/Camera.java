package com.github.piotrkalanski.model;

public class Camera {
    private final String id;
    private final String modelId;
    private final String description;

    public Camera(String id, String modelId, String description) {
        this.id = id;
        this.modelId = modelId;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public String getModelId() {
        return modelId;
    }

    public String getDescription() {
        return description;
    }
}
