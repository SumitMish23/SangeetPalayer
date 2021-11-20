package com.example.myweather;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {


    final String API_ID = "bcc2fc97219a1dddce3cc755ed92dd08";
    final String Weather_Url = "https://api.home.openweathermap.org/data/2.5/weather";
    final long min_time = 5000;
    final float min_distance = 1000;
    final int request = 101;


    String Location_Provider = LocationManager.GPS_PROVIDER;
    TextView NameofCity, weatherState, Temperature;
    ImageView weathericon;

    RelativeLayout cityFinder;
    LocationManager locationManager;
    LocationListener locationListener = new LocationListener() {
        @Override
        public void onLocationChanged(@NonNull Location location) {


            String Latitude = String.valueOf(location.getLatitude());
            String Longitude = String.valueOf(location.getLongitude());

            RequestParams params = new RequestParams();
            params.put("lat", Latitude);
            params.put("lon", Longitude);
            params.put("appid", API_ID);
            networkingLocation(params);

        }

        @Override
        public void onProviderDisabled(@NonNull String provider) {

        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        weatherState = findViewById(R.id.textView5);
        Temperature = findViewById(R.id.textView8);
        cityFinder = findViewById(R.id.Home);
        NameofCity = findViewById(R.id.textView2);
        weathericon=findViewById(R.id.i2);

        cityFinder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, cityFinder.class);
                startActivity(intent);

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        getWeatherForCurrentLocation();
    }

    private void getWeatherForCurrentLocation() {
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},request);
            return;
        }
        locationManager.requestLocationUpdates(Location_Provider, min_time, min_distance, locationListener);


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {


        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == request) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                Toast.makeText(MainActivity.this, "Analysing Location", Toast.LENGTH_SHORT).show();
                getWeatherForCurrentLocation();
            }
        }

    }

    private void networkingLocation(RequestParams params) {
        AsyncHttpClient client = new AsyncHttpClient();
        client.get(Weather_Url, params, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();


               weatherData w=weatherData.fromJson(response);
               updateUI(w);










            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                //  super.onFailure(statusCode, headers, throwable, errorResponse);
            }
        });
    }




    private void updateUI(weatherData w){
        Temperature.setText(w.getTemp());
        NameofCity.setText(w.getCity());
        weatherState.setText(w.getWeathertype());
        int resourceID=getResources().getIdentifier(w.getIcon(),"drawable",getPackageName());
        weathericon.setImageResource(resourceID);


    }

    @Override
    protected void onPause() {
        super.onPause();
        if(locationManager!=null){

locationManager.removeUpdates(locationListener);
        }
    }
}






