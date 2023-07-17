package com.example.bestroute.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.bestroute.Models.Locations;
import com.example.bestroute.Models.Routes;

import java.util.ArrayList;

public class RoutesDatabaseHelper extends SQLiteOpenHelper {

    public static final String LOCATION_TABLE = "location_table";
    public static final String COLUMN_LOCATION_ID = "location_id";
    public static final String COLUMN_LOCATION_1 = "location1";
    public static final String COLUMN_LOCATION_2 = "location2";
    public static final String ROUTES_TABLE = "routes_table";
    public static final String COLUMN_ROUTE_ID = "route_id";
    public static final String COLUMN_LOC_ID = "loc_Id";
    public static final String COLUMN_LM_1 = "lm1";
    public static final String COLUMN_LM_2 = "lm2";
    public static final String COLUMN_LM_3 = "lm3";
    public static final String COLUMN_LM_4 = "lm4";
    public static final String COLUMN_DISTANCE = "distance";
    public static final String COLUMN_DURATION = "duration";

    public RoutesDatabaseHelper(@Nullable Context context) {
        super(context, "routes.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryStringLocation = "CREATE TABLE " + LOCATION_TABLE + "(" + COLUMN_LOCATION_ID + " INTEGER PRIMARY KEY, " + COLUMN_LOCATION_1 + " TEXT NOT NULL, " + COLUMN_LOCATION_2 + " TEXT NOT NULL)";
        String queryStringRoutes = "CREATE TABLE " + ROUTES_TABLE + "(" + COLUMN_ROUTE_ID + " INTEGER PRIMARY KEY, " + COLUMN_LOC_ID + " INTEGER NOT NULL, " + COLUMN_LM_1 + " TEXT NOT NULL, " + COLUMN_LM_2 + " TEXT NOT NULL, " + COLUMN_LM_3 + " TEXT NOT NULL, " + COLUMN_LM_4 + " TEXT NOT NULL, " + COLUMN_DISTANCE + " INT NOT NULL, " + COLUMN_DURATION + " INT NOT NULL)";
        db.execSQL(queryStringRoutes);
        db.execSQL(queryStringLocation);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + ROUTES_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + LOCATION_TABLE);
        onCreate(db);
    }

    SQLiteDatabase db;

    public boolean createNewRoutes (Routes routes){
        db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_ROUTE_ID, routes.getRoutes_id());
        cv.put(COLUMN_LOC_ID, routes.getLocation_id());
        cv.put(COLUMN_LM_1, routes.getLm1());
        cv.put(COLUMN_LM_2, routes.getLm2());
        cv.put(COLUMN_LM_3, routes.getLm3());
        cv.put(COLUMN_LM_4, routes.getLm4());
        cv.put(COLUMN_DISTANCE, routes.getDistance());
        cv.put(COLUMN_DURATION, routes.getDuration());

        long result = db.insert(ROUTES_TABLE, null, cv);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public boolean createNewLocation (Locations locations){
        db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_LOCATION_ID, locations.getId());
        cv.put(COLUMN_LOCATION_1, locations.getLocation1());
        cv.put(COLUMN_LOCATION_2, locations.getLocation2());

        long result = db.insert(LOCATION_TABLE, null, cv);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public ArrayList<Routes> getPentEvandy() {
        db = this.getReadableDatabase();
        String queryString = "SELECT * FROM " + ROUTES_TABLE + " WHERE " + COLUMN_LOC_ID + " = 1";
        ArrayList<Routes> routesArrayList = new ArrayList<>();
        Cursor cursor = db.rawQuery(queryString, null);

        if (cursor.moveToFirst()) {
            do {
                int routeId = cursor.getInt(0);
                int locationId = cursor.getInt(1);
                String lm1 = cursor.getString(2);
                String lm2 = cursor.getString(3);
                String lm3 = cursor.getString(4);
                String lm4 = cursor.getString(5);
                int distance = cursor.getInt(6);
                int duration = cursor.getInt(7);

                Routes routes = new Routes(routeId, locationId, lm1, lm2, lm3, lm4, distance, duration);
                routesArrayList.add(routes);
            } while (cursor.moveToNext());
        } else {
            //Do nothing
        }

        cursor.close();
        db.close();
        return routesArrayList;
    }

}
