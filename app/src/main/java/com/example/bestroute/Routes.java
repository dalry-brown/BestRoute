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

        logo = findViewById(R.id.logo);

        ArrayList<com.example.bestroute.Models.Routes> routesArr = (ArrayList<com.example.bestroute.Models.Routes>) getIntent().getSerializableExtra("dbArray");

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