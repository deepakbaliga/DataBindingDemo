package com.deepakbaliga.databindingdemo;

import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private PlaceAdapter placeAdapter;

    private LinkedList<Place> places = new LinkedList<>();
    private PlaceClickListener placeClickListener;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        //Populating Data
        populateData();

        placeClickListener = new PlaceClickListener() {
            @Override
            public void onTouch(View view ,int position) {
                Intent i = new Intent(MainActivity.this, DetailedActivity.class);

                i.putExtra("name",Data.name[position]);
                i.putExtra("info",Data.description[position]);
                i.putExtra("url",Data.link[position]);
                ActivityOptions options = ActivityOptions
                        .makeSceneTransitionAnimation(MainActivity.this, view, "image");
                startActivity(i, options.toBundle());
            }
        };

        placeAdapter = new PlaceAdapter(places, placeClickListener);
        recyclerView.setAdapter(placeAdapter);
    }

    private void populateData(){
        for(int i=0 ; i<5;i++){
            places.add(new Place(Data.name[i], Data.description[i],Data.link[i]));
        }
    }
}
