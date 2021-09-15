package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    TextView tv;
    private List<Example> arraylist1=new ArrayList<>();
    private List<Example> arraylist=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recycler);
        tv=findViewById(R.id.tv);

        MyApi myApi=Network.getInstance().create(MyApi.class);
        myApi.getmodels("nrupuld").enqueue(new Callback<List<Example>>() {
            @Override
            public void onResponse(Call<List<Example>> call, retrofit2.Response<List<Example>> response) {
                arraylist1=response.body();
                //tv.setText(arraylist1.get(0).getName());
                buildrecycle();
            }

            @Override
            public void onFailure(Call<List<Example>> call, Throwable t) {

            }
        });
    }
    private void buildrecycle() {
        MyAdapter adapter=new MyAdapter(arraylist1);
        LinearLayoutManager gridLayoutManager=new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);
    }
}