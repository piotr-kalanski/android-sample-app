package com.github.piotrkalanski.dto;

import com.github.piotrkalanski.model.Camera;

import java.util.List;

public class GetCamerasResponse {
    public final List<Camera> items;

    public GetCamerasResponse(List<Camera> items) {
        this.items = items;
    }
}
