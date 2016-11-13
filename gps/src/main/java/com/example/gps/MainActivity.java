package com.example.gps;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.location.Criteria;

public class MainActivity extends AppCompatActivity implements LocationListener {

    LocationManager location = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        location = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        Criteria criteria = new Criteria();
        criteria.setAccuracy(Criteria.NO_REQUIREMENT);

        String provider = location.getBestProvider(criteria, true);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        location.requestLocationUpdates(provider,1000,1, this);

    }

    public void onLocationChanged(android.location.Location location){

        TextView textView1 = (TextView) findViewById(R.id.textView1);
        TextView textView2 = (TextView) findViewById(R.id.textView2);

        double latitude = location.getLatitude();
        double longitude = location.getLongitude();

       String lati =  String.valueOf(latitude);
        textView1.setText("위도 : " + latitude);

       String longi = String.valueOf(longitude);
        textView2.setText("경도 : " + longitude);



    }

  public void onProviderDisabled(String provider){}

   public void onProviderEnabled(String provider){}

    public void onStatusChanged(String provider, int stauts, Bundle extras){

    }
}
