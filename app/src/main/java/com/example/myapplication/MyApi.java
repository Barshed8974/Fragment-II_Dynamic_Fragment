package com.example.myapplication;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface MyApi {
    @GET(" /users/{user}/repos")
    Call<List<Example>> getmodels(@Path("user")String user);
}
