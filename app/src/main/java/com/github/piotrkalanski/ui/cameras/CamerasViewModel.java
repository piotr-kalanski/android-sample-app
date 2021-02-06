package com.github.piotrkalanski.ui.cameras;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.github.piotrkalanski.dto.GetCamerasResponse;
import com.github.piotrkalanski.repository.CamerasRepository;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CamerasViewModel extends ViewModel {
    private final MutableLiveData<GetCamerasResponse> _cameras = new MutableLiveData<>();
    LiveData<GetCamerasResponse> cameras = _cameras;

    public CamerasViewModel(String userId) {
        CamerasRepository camerasRepository = CamerasRepository.newInstance();

        Call<GetCamerasResponse> getCamerasResponse = camerasRepository.getCameras(userId);
        getCamerasResponse.enqueue(new Callback<GetCamerasResponse>() {
            @Override
            public void onResponse(Call<GetCamerasResponse> call, Response<GetCamerasResponse> response) {
                if (response.isSuccessful()) {
                    _cameras.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<GetCamerasResponse> call, Throwable t) {
                // show error message to user
            }
        });
    }
}
