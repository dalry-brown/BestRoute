package com.example.bestroute;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Routes extends AppCompatActivity {
    ImageView logo;
    TextView locationheader1, locationheader2;
    TextView route1direction, route2direction, route3direction, route4direction;
    TextView route1distance, route2distance, route3distance, route4distance;
    TextView route1duration, route2duration, route3duration, route4duration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_routes);

        locationheader1 = findViewById(R.id.locationheader1);
        locationheader2 = findViewById(R.id.locationheader2);
        route1direction = findViewById(R.id.route1_direction);
        route2direction = findViewById(R.id.route2_direction);
        route3direction = findViewById(R.id.route3_direction);
        route4direction = findViewById(R.id.route4_direction);
        route1distance = findViewById(R.id.route1_distance);
        route2distance = findViewById(R.id.route2_distance);
        route3distance = findViewById(R.id.route3_distance);
        route4distance = findViewById(R.id.route4_distance);
        route1duration = findViewById(R.id.route1_duration);
        route2duration = findViewById(R.id.route2_duration);
        route3duration = findViewById(R.id.route3_duration);
        route4duration = findViewById(R.id.route4_duration);


        String location1data = getIntent().getStringExtra("location1");
        String location2data = getIntent().getStringExtra("location2");
        String route1directiondata = getIntent().getStringExtra("route1direction");
        String route2directiondata = getIntent().getStringExtra("route2direction");
        String route3directiondata = getIntent().getStringExtra("route3direction");
        String route4directiondata = getIntent().getStringExtra("route4direction");
        int route1distancedata = getIntent().getIntExtra("route1distance", 1);
        int route2distancedata = getIntent().getIntExtra("route2distance", 1);
        int route3distancedata = getIntent().getIntExtra("route3distance", 1);
        int route4distancedata = getIntent().getIntExtra("route4distance", 1);
        int route1durationdata = getIntent().getIntExtra("route1duration", 1);
        int route2durationdata = getIntent().getIntExtra("route2duration", 1);
        int route3durationdata = getIntent().getIntExtra("route3duration", 1);
        int route4durationdata = getIntent().getIntExtra("route4duration", 1);

        locationheader1.setText(location1data);
        locationheader2.setText(location2data);
        route1direction.setText(""+route1directiondata);
        route2direction.setText(""+route2directiondata);
        route3direction.setText(""+route3directiondata);
        route4direction.setText(""+route4directiondata);
        route1distance.setText(""+route1distancedata);
        route2distance.setText(""+route2distancedata);
        route3distance.setText(""+route3distancedata);
        route4distance.setText(""+route4distancedata);
        route1duration.setText(""+route1durationdata);
        route2duration.setText(""+route2durationdata);
        route3duration.setText(""+route3durationdata);
        route4duration.setText(""+route4durationdata);

        logo = findViewById(R.id.logo);

//        ArrayList<com.example.bestroute.Models.Routes> routesArr = (ArrayList<com.example.bestroute.Models.Routes>) getIntent().getSerializableExtra("dbArray");

        logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = Routes.this;
                Intent i = new Intent(context, MainActivity.class);
                context.startActivity(i);
            }
        });
    }
}