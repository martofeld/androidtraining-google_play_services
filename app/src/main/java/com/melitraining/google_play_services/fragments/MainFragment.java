package com.melitraining.google_play_services.fragments;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.melitraining.google_play_services.R;
import com.melitraining.google_play_services.activities.ExampleMapsActivity;

public class MainFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        Button goToMapsActivityButton = (Button) view.findViewById(R.id.go_to_maps_button);
        goToMapsActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToMapsActivity();
            }
        });

        return view;
    }

    private void goToMapsActivity() {
        startActivity(new Intent(getActivity(), ExampleMapsActivity.class));
    }
}
