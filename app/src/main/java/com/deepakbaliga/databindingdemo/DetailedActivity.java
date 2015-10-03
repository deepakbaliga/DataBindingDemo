package com.deepakbaliga.databindingdemo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.transition.Explode;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailedActivity extends AppCompatActivity {

    private ImageView image;
    private TextView title;
    private TextView description;

    private String name;
    private String info;
    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        super.onCreate(savedInstanceState);


        // set an enter transition
        getWindow().setEnterTransition(new Explode());
        // set an exit transition
        getWindow().setExitTransition(new Explode());


        setContentView(R.layout.activity_detailed);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        name = getIntent().getExtras().getString("name");
        info = getIntent().getExtras().getString("info");
        url = getIntent().getExtras().getString("url");

        referenceViews();




    }

    private void referenceViews() {

        image = (ImageView) findViewById(R.id.image);
        title = (TextView) findViewById(R.id.title);
        description = (TextView) findViewById(R.id.description);


        title.setText(name);
        description.setText(info);
        Picasso.with(this).load(url).into(image);
    }


    @Override
    public void onBackPressed() {
        finishAfterTransition();
    }
}
