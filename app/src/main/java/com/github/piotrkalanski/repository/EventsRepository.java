package com.github.piotrkalanski.repository;

import com.github.piotrkalanski.model.Event;
import com.github.piotrkalanski.services.EventsService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class EventsRepository {
    private EventsService eventsService;

    public static EventsRepository newInstance() {
        Retrofit retrofit = new Retrofit.Builder()
                // TODO - replace by target endpoint, currently it is mock api: https://jsonplaceholder.typicode.com/posts?userId=2
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return new EventsRepository(retrofit.create(EventsService.class));
    }

    protected EventsRepository(EventsService eventsService) {
        this.eventsService = eventsService;
    }

    public Call<List<Event>> getEvents(String userId) {
        return eventsService.getEvents(userId);
    }
}
