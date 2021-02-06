package com.github.piotrkalanski.services;

import com.github.piotrkalanski.dto.GetCamerasResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CamerasService {
    @GET("devices/user/{userId}")
    Call<GetCamerasResponse> getCameras(@Path("userId") String userId);
}
