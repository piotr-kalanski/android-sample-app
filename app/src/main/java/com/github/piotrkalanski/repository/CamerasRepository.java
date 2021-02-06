package com.github.piotrkalanski.repository;

import com.github.piotrkalanski.dto.GetCamerasResponse;
import com.github.piotrkalanski.services.CamerasService;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CamerasRepository {
    private CamerasService camerasService;

    public static CamerasRepository newInstance() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://piroyu1b5d.execute-api.eu-west-1.amazonaws.com/prod/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return new CamerasRepository(retrofit.create(CamerasService.class));
    }

    protected CamerasRepository(CamerasService camerasService) {
        this.camerasService = camerasService;
    }

    public Call<GetCamerasResponse> getCameras(String userId) {
        return camerasService.getCameras(userId);
    }
}
