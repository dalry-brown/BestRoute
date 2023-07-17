package com.example.bestroute;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
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
    ArrayList<Locations> locationArrayList = new ArrayList<>();
    CardView searchBtn;
    Spinner spinner1;
    Spinner spinner2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        searchBtn = findViewById(R.id.searchRoute);

        spinner1 = findViewById(R.id.spinner1);
        spinner2 = findViewById(R.id.spinner2);

        Locations location1 = new Locations(1, "Pent", "Evandy");
        Locations location2 = new Locations(2, "Math dept", "Great hall");

        Routes route1 = new Routes(1, 1, "Pent", "NNB", "JQB", "Evandy", 500, 20);
        Routes route2 = new Routes(2, 1, "Pent", "Great Hall", "TF", "Evandy", 700, 10);
        Routes route3 = new Routes(3, 1, "Pent", "Volta", "JQB", "Nelson", 300, 8);
        Routes route4 = new Routes(4, 2, "Math dept", "N-Block", "Business sch.", "Great hall", 400, 9);
        Routes route5 = new Routes(5, 2, "Math dept", "TF", "JQB", "Main gate", 900, 3);
        Routes route6 = new Routes(6, 2, "Math dept", "Balme Lib", "JQB", "Great hall", 20, 1);

        routesDatabaseHelper.createNewRoutes(route1);
        routesDatabaseHelper.createNewRoutes(route2);
        routesDatabaseHelper.createNewRoutes(route3);
        routesDatabaseHelper.createNewRoutes(route4);
        routesDatabaseHelper.createNewRoutes(route5);
        routesDatabaseHelper.createNewRoutes(route6);

        routesDatabaseHelper.createNewLocation(location1);
        routesDatabaseHelper.createNewLocation(location2);

        locationArrayList = routesDatabaseHelper.getLocation();

        ArrayList<String> spinner1Arr = new ArrayList<>();

        for (int i = 0; i < locationArrayList.size(); i++) {
            spinner1Arr.add(locationArrayList.get(i).getLocation1());
        }

        ArrayAdapter adapter1 = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                spinner1Arr
        );
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);

        ArrayList<String> spinner2Arr = new ArrayList<>();

        for (int i = 0; i < locationArrayList.size(); i++) {
            spinner2Arr.add(locationArrayList.get(i).getLocation2());
        }

        ArrayAdapter adapter2 = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                spinner2Arr
        );
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);



//        for (int i = 0; i < routesArrayList.size(); i++) {
//            Toast.makeText(this,  routesArrayList.get(i).getRoutes_id() + " " + routesArrayList.get(i).getLocation_id() + " " + routesArrayList.get(i).getLm1(), Toast.LENGTH_LONG).show();
//        }
        //Toast.makeText(this,  ""+3, Toast.LENGTH_SHORT).show();

        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value1 = spinner1.getSelectedItem().toString();
                String value2 = spinner2.getSelectedItem().toString();

                if (value1.equals("Pent") && value2.equals("Evandy")) {
                    routesArrayList = routesDatabaseHelper.getPentEvandy();
                } else if (value1.equals("Math dept") && value2.equals("Great hall")){
                    routesArrayList = routesDatabaseHelper.getMathdeptGreathall();
                }

                //Toast.makeText(MainActivity.this, value1 + " " + value2, Toast.LENGTH_LONG).show();
                Context context =   MainActivity.this;
                Intent i = new Intent(context, com.example.bestroute.Routes.class);
                i.putExtra("location1", routesArrayList.get(0).getLm1());
                i.putExtra("location2", routesArrayList.get(0).getLm4());
                i.putExtra("route1direction", routesArrayList.get(0).getLm1() + " ---> " +routesArrayList.get(0).getLm2() + " ---> " +routesArrayList.get(0).getLm3() + " ---> " +routesArrayList.get(0).getLm4());
                i.putExtra("route2direction", routesArrayList.get(1).getLm1() + " ---> " +routesArrayList.get(1).getLm2() + " ---> " +routesArrayList.get(1).getLm3() + " ---> " +routesArrayList.get(1).getLm4());
                i.putExtra("route3direction", routesArrayList.get(2).getLm1() + " ---> " +routesArrayList.get(2).getLm2() + " ---> " +routesArrayList.get(2).getLm3() + " ---> " +routesArrayList.get(2).getLm4());
                i.putExtra("route4direction", routesArrayList.get(2).getLm1() + " ---> " +routesArrayList.get(2).getLm2() + " ---> " +routesArrayList.get(2).getLm3() + " ---> " +routesArrayList.get(2).getLm4());
                i.putExtra("route1distance", routesArrayList.get(0).getDistance());
                i.putExtra("route2distance", routesArrayList.get(1).getDistance());
                i.putExtra("route3distance", routesArrayList.get(2).getDistance());
                i.putExtra("route4distance", routesArrayList.get(2).getDistance());
                i.putExtra("route1duration", routesArrayList.get(0).getDuration());
                i.putExtra("route2duration", routesArrayList.get(1).getDuration());
                i.putExtra("route3duration", routesArrayList.get(2).getDuration());
                i.putExtra("route4duration", routesArrayList.get(2).getDuration());
                context.startActivity(i);
            }
        });

    }
}