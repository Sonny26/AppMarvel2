package com.example.appmarvel;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class Main2Activity extends AppCompatActivity {
        private RecyclerView recyclerView;
        private RecyclerView.Adapter mAdapter;
        private RecyclerView.LayoutManager layoutManager;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            Toast.makeText(getApplicationContext(), "Et non!", Toast.LENGTH_SHORT);


            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://raw.githubusercontent.com/Sonny26/TEAK/master/")
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();

            MarvelRestApi marvelRestApi = retrofit.create(MarvelRestApi.class);


            Call<RestMarvelResponse> call = marvelRestApi.getListMarvel();
            call.enqueue(new Callback<RestMarvelResponse>() {
                @Override
                public void onResponse(Call<RestMarvelResponse> call, Response<RestMarvelResponse> response) {
                    RestMarvelResponse restMarvelResponse = response.body();
                    List<Marvel> listMarvel = restMarvelResponse.getResults();
                    showList(listMarvel);
                }

                @Override
                public void onFailure(Call<RestMarvelResponse> call, Throwable t) {
                    Log.d("Erreur", "API KO");
                }
            });
        }

        private void showList(final List<Marvel> list) {
            recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
            recyclerView.setHasFixedSize(true);
            layoutManager = new LinearLayoutManager(this);
            recyclerView.setLayoutManager(layoutManager);
            mAdapter = new MyAdapter(this, list);

            recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
                @Override
                public void onClick(View view, int position) {
                    Marvel perso = list.get(position);

                    Toast.makeText(getApplicationContext(), perso.getName(), Toast.LENGTH_SHORT);

                    Intent listIntent = new Intent(Main2Activity.this, Main3Activity.class);

                    listIntent.putExtra("nom", perso.getName());

                    listIntent.putExtra("texte", perso.getText());

                    //startActivity(listIntent);

                    //Marvel perso = list.get(position);

                   // Toast.makeText(getApplicationContext(), perso.getText(), Toast.LENGTH_SHORT);

                    //Intent listIntent = new Intent(Main2Activity.this, Main3Activity.class);

                   // listIntent.putExtra("text", perso.getText());

                    startActivity(listIntent);


                }

                @Override
                public void onLongClick(View view, int position) {

                }
            }));

            recyclerView.setAdapter(mAdapter);
        }
    }

