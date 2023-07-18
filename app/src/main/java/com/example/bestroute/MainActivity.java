package com.example.bestroute;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.bestroute.Database.RoutesDatabaseHelper;
import com.example.bestroute.Models.Locations;
import com.example.bestroute.Models.Routes;

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

        Locations location1 = new Locations(1, "School of Law", "Balme Library");
        Locations location2 = new Locations(2, "School of Law", "Volta Hall");
        Locations location3 = new Locations(3, "School of Law", "Business School");
        Locations location4 = new Locations(4, "Engineering School", "Business School");
        Locations location5 = new Locations(5, "Engineering School", "Balme Library");
        Locations location6 = new Locations(6, "Engineering School", "Volta Hall");
        Locations location7 = new Locations(7, "Nursing School", "Business School");
        Locations location8 = new Locations(8, "Nursing School", "Balme Library");
        Locations location9 = new Locations(9, "Nursing School", "Volta Hall");

        Routes route1 = new Routes(1, 1, "School of Law", "UGCS", "Institute of applied sci.", "Balme Library", 700, 3);
        Routes route2 = new Routes(2, 1, "School of Law", "JQB", "Akuafo", "Balme Library", 1000, 4);
        Routes route3 = new Routes(3, 1, "School of Law", "Chemistry dept.", "Research Commons", "Balme Library", 1600, 5);
        Routes route4 = new Routes(4, 2, "School of Law", "Veterinary School of medicine", "Legon Hall", "Volta Hall", 1200, 4);
        Routes route5 = new Routes(5, 2, "School of Law", "Math Dept.", "Chemistry", "Volta Hall", 850, 3);
        Routes route6 = new Routes(6, 2, "School of Law", "Volta Hall", "UGBS", "Volta Hall", 1000, 3);
        Routes route7 = new Routes(7, 3, "School of Law", "Math Dept.", "Chemistry dept.", "Business School", 350, 3);
        Routes route8 = new Routes(8, 3, "School of Law", "Math Dept.", "Animal Biology", "Business School", 800, 3);
        Routes route9 = new Routes(9, 3, "School of Law", "KAB", "Chemistry Dept.", "Business School", 950, 3);
        Routes route10 = new Routes(10, 4, "Engineering School", "KAB", "Chemistry Dept.", "Business School", 1000, 3);
        Routes route11 = new Routes(11, 4, "Engineering School", "Math Dept.", "Botany Dept.", "Business School", 850, 3);
        Routes route12 = new Routes(12, 4, "Engineering School", "Math Dept.", "Chemistry Dept.", "Business School", 900, 3);
        Routes route13 = new Routes(13, 5, "Engineering School", "JQB", "Akuafo", "Balme Library", 1200, 4);
        Routes route14 = new Routes(14, 5, "Engineering School", "Math Dept.", "Chemistry Dept.", "Balme Library", 900, 4);
        Routes route15 = new Routes(15, 5, "Engineering School", "Academic Computing Unit", "Ghana Korea Info Access center", "Balme Library", 1100, 4);
        Routes route16 = new Routes(16, 6, "Engineering School", "Veterinary School", "Legon Hall", "Volta Hall", 1000, 4);
        Routes route17 = new Routes(17, 6, "Engineering School", "School of arts", "Business School", "Volta Hall", 850, 4);
        Routes route18 = new Routes(18, 6, "Engineering School", "Math Dept.", "Chemistry Dept.", "Volta Hall", 900, 5);
        Routes route19 = new Routes(19, 7, "Nursing School", "International Affairs", "UGBS car park", "Business School", 240, 2);
        Routes route20 = new Routes(20, 7, "Nursing School", "International Affairs", "UGBS car park", "Business School", 260, 2);
        Routes route21 = new Routes(21, 7, "Nursing School", "School of Pharmacy", "LOT", "Business School", 400, 3);
        Routes route22 = new Routes(22, 8, "Nursing School", "UGBS", "UGCS", "Balme Library", 550, 3);
        Routes route23 = new Routes(23, 8, "Nursing School", "UGBS", "Chemistry Dept.", "Balme Library", 750, 3);
        Routes route24 = new Routes(24, 8, "Nursing School", "Economics Dept.", "Ghana Post, legon", "Balme Library", 850, 4);
        Routes route25 = new Routes(25, 9, "Nursing School", "Barclays ATM", "International affairs centre", "Volta Hall", 260, 1);
        Routes route26 = new Routes(26, 9, "Nursing School", "Bacchus Garden", "Restaurant", "Volta Hall", 750, 3);
        Routes route27 = new Routes(27, 9, "Nursing School", "Cedi Conference", "Volta Cafe", "Volta Hall", 500, 2);


        routesDatabaseHelper.createNewRoutes(route1);
        routesDatabaseHelper.createNewRoutes(route2);
        routesDatabaseHelper.createNewRoutes(route3);
        routesDatabaseHelper.createNewRoutes(route4);
        routesDatabaseHelper.createNewRoutes(route5);
        routesDatabaseHelper.createNewRoutes(route6);
        routesDatabaseHelper.createNewRoutes(route7);
        routesDatabaseHelper.createNewRoutes(route8);
        routesDatabaseHelper.createNewRoutes(route9);
        routesDatabaseHelper.createNewRoutes(route10);
        routesDatabaseHelper.createNewRoutes(route11);
        routesDatabaseHelper.createNewRoutes(route12);
        routesDatabaseHelper.createNewRoutes(route13);
        routesDatabaseHelper.createNewRoutes(route14);
        routesDatabaseHelper.createNewRoutes(route15);
        routesDatabaseHelper.createNewRoutes(route16);
        routesDatabaseHelper.createNewRoutes(route17);
        routesDatabaseHelper.createNewRoutes(route18);
        routesDatabaseHelper.createNewRoutes(route19);
        routesDatabaseHelper.createNewRoutes(route20);
        routesDatabaseHelper.createNewRoutes(route21);
        routesDatabaseHelper.createNewRoutes(route22);
        routesDatabaseHelper.createNewRoutes(route23);
        routesDatabaseHelper.createNewRoutes(route24);
        routesDatabaseHelper.createNewRoutes(route25);
        routesDatabaseHelper.createNewRoutes(route26);
        routesDatabaseHelper.createNewRoutes(route27);

        routesDatabaseHelper.createNewLocation(location1);
        routesDatabaseHelper.createNewLocation(location2);
        routesDatabaseHelper.createNewLocation(location3);
        routesDatabaseHelper.createNewLocation(location4);
        routesDatabaseHelper.createNewLocation(location5);
        routesDatabaseHelper.createNewLocation(location6);
        routesDatabaseHelper.createNewLocation(location7);
        routesDatabaseHelper.createNewLocation(location8);
        routesDatabaseHelper.createNewLocation(location9);

        locationArrayList = routesDatabaseHelper.getLocation();

        ArrayList<String> spinner1Arr = new ArrayList<>();

        for (int i = 0; i < locationArrayList.size(); i++) {
            if (!spinner1Arr.contains(locationArrayList.get(i).getLocation1())) {
                spinner1Arr.add(locationArrayList.get(i).getLocation1());
            }
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
            if (!spinner2Arr.contains(locationArrayList.get(i).getLocation2())) {
                spinner2Arr.add(locationArrayList.get(i).getLocation2());
            }
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

                if (value1.equals("School of Law") && value2.equals("Balme Library")) {
                    routesArrayList = routesDatabaseHelper.getLawBalme();
                } else if (value1.equals("School of Law") && value2.equals("Volta Hall")){
                    routesArrayList = routesDatabaseHelper.getLawVolta();
                }  else if (value1.equals("School of Law") && value2.equals("Business School")){
                    routesArrayList = routesDatabaseHelper.getLawBusiness();
                }  else if (value1.equals("Engineering School") && value2.equals("Balme Library")){
                    routesArrayList = routesDatabaseHelper.getEngBalme();
                }  else if (value1.equals("Engineering School") && value2.equals("Volta Hall")){
                    routesArrayList = routesDatabaseHelper.getEngVolta();
                }  else if (value1.equals("Engineering School") && value2.equals("Business School")){
                    routesArrayList = routesDatabaseHelper.getEngBus();
                }else if (value1.equals("Nursing School") && value2.equals("Balme Library")){
                    routesArrayList = routesDatabaseHelper.getNurseBalme();
                }else if (value1.equals("Nursing School") && value2.equals("Volta Hall")){
                    routesArrayList = routesDatabaseHelper.getNurseVolta();
                }else if (value1.equals("Nursing School") && value2.equals("Business School")){
                    routesArrayList = routesDatabaseHelper.getNurseBus();
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