package com.example.bestroute;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bestroute.Database.RoutesDatabaseHelper;
import com.example.bestroute.Models.Locations;
import com.example.bestroute.Models.Routes;
import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RoutesDatabaseHelper routesDatabaseHelper = new RoutesDatabaseHelper(MainActivity.this);
    ArrayList<Routes> routesArrayList = new ArrayList<>();
    CardView searchBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        searchBtn = findViewById(R.id.searchRoute);

        Locations location1 = new Locations(1, "Pent", "Evandy");
        Locations location2 = new Locations(2, "Math dept", "Great hall");

        Routes route1 = new Routes(1, 1, "Pent", "NNP", "JQB", "Evandy", 500, 20);
        Routes route2 = new Routes(2, 1, "Pent", "Great Hall", "TF", "Evandy", 700, 10);
        Routes route3 = new Routes(3, 1, "Pent", "Volta", "JQB", "Nelson", 300, 8);
        Routes route4 = new Routes(4, 2, "Pent", "Volta", "JQB", "Nelson", 300, 8);

        routesDatabaseHelper.createNewRoutes(route1);
        routesDatabaseHelper.createNewRoutes(route2);
        routesDatabaseHelper.createNewRoutes(route3);
        routesDatabaseHelper.createNewRoutes(route4);

        routesDatabaseHelper.createNewLocation(location1);
        routesDatabaseHelper.createNewLocation(location2);

        routesArrayList = routesDatabaseHelper.getPentEvandy();

//        for (int i = 0; i < routesArrayList.size(); i++) {
//            Toast.makeText(this,  routesArrayList.get(i).getRoutes_id() + " " + routesArrayList.get(i).getLocation_id() + " " + routesArrayList.get(i).getLm1(), Toast.LENGTH_LONG).show();
//        }

        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context =   MainActivity.this;
                Intent i = new Intent(context, com.example.bestroute.Routes.class);
                i.putExtra("dbArray", routesArrayList);
                context.startActivity(i);
            }
        });

    }
}