package com.github.piotrkalanski.model;

import com.github.piotrkalanski.R;

import java.io.Serializable;

public class Camera implements Serializable {
    private final String id;
    private final String model;
    private final String description;

    public Camera(String id, String modelId, String description) {
        this.id = id;
        this.model = modelId;
        this.description = description;
    }

    public int getDrawable() {
        switch(model) {
            case "model1": return R.drawable.model1;
            case "model2": return R.drawable.model2;
            case "model3": return R.drawable.model3;
            default: return R.drawable.ic_menu_camera;
        }
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
