package com.github.piotrkalanski.services;

import com.github.piotrkalanski.model.Event;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface EventsService {
    // TODO - replace by target endpoint, currently it is mock api: https://jsonplaceholder.typicode.com/posts?userId=2
    @GET("posts")
    Call<List<Event>> getEvents(@Query("userId") String userId);
}
