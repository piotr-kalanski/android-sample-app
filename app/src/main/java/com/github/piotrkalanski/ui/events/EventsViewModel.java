package com.github.piotrkalanski.ui.events;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.github.piotrkalanski.model.Event;
import com.github.piotrkalanski.repository.EventsRepository;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EventsViewModel extends ViewModel {
    private final MutableLiveData<List<Event>> _events = new MutableLiveData<>();
    LiveData<List<Event>> events = _events;

    public EventsViewModel(String userId) {
        EventsRepository eventsRepository = EventsRepository.newInstance();

        Call<List<Event>> getEventsResponse = eventsRepository.getEvents(userId);
        getEventsResponse.enqueue(new Callback<List<Event>>() {
            @Override
            public void onResponse(Call<List<Event>> call, Response<List<Event>> response) {
                if (response.isSuccessful()) {
                    _events.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Event>> call, Throwable t) {
                // show error message to user
            }
        });
    }
}
