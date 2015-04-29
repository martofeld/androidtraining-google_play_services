package com.melitraining.google_play_services.activities;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.melitraining.google_play_services.R;

public class ExampleMapsActivity extends FragmentActivity {

    private GoogleMap mMap; // Might be null if Google Play services APK is not available.
    private TextView txtLatitude, txtLongitude;
    private Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example_maps);
        setUpMapIfNeeded();
        setUpView();
    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }

    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                setUpMap();
            }
        }
    }

    private void setUpMap() {
        mMap.setMyLocationEnabled(true);

        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLng(new LatLng(mMap.getMyLocation().getLatitude(), mMap.getMyLocation().getLongitude()));
        mMap.animateCamera(cameraUpdate);
    }

    private void setUpView(){
        txtLatitude = (TextView)findViewById(R.id.txtLatitude);
        txtLongitude = (TextView)findViewById(R.id.txtLongitude);
        submit = (Button)findViewById(R.id.btnSubmit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cameraUpdate();
            }
        });
    }

    private void cameraUpdate() {
        double lat = Double.parseDouble(txtLatitude.getText().toString());
        double lng = Double.parseDouble(txtLongitude.getText().toString());
        if(lat >= -90 && lat <= 90 && lng >= -180 && lng <= 180) {
            CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLng(new LatLng(lat, lng));
            mMap.animateCamera(cameraUpdate);
        }else{
            Toast.makeText(this, getString(R.string.lat_lng_error), Toast.LENGTH_SHORT).show();
        }
    }
}
