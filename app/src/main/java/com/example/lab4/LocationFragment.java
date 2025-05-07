package com.example.lab4;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.lab4.LocationAdapter;
import com.example.lab4.LocationItem;
import com.example.lab4.R;
import com.example.lab4.WeatherApi;

import java.util.List;

import retrofit2.*;
import retrofit2.converter.gson.GsonConverterFactory;

public class LocationFragment extends Fragment {

    private EditText etBuscar;
    private Button btnBuscar;
    private RecyclerView recyclerView;

    private final String API_KEY = "ec24b1c6dd8a4d528c1205500250305";

    public LocationFragment() {}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_location, container, false);

        etBuscar = view.findViewById(R.id.etBuscar);
        btnBuscar = view.findViewById(R.id.btnBuscar);
        recyclerView = view.findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        btnBuscar.setOnClickListener(v -> {
            String query = etBuscar.getText().toString().trim();
            if (!query.isEmpty()) {
                buscarLocaciones(query);
            } else {
                Toast.makeText(getContext(), "Escribe una locación", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }


    private void buscarLocaciones(String query) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.weatherapi.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        WeatherApi service = retrofit.create(WeatherApi.class);
        Call<List<LocationItem>> call = service.searchLocations(API_KEY, query);

        call.enqueue(new Callback<List<LocationItem>>() {
            @Override
            public void onResponse(Call<List<LocationItem>> call, Response<List<LocationItem>> response) {
                if (response.isSuccessful()) {
                    List<LocationItem> locations = response.body();
                    recyclerView.setAdapter(new LocationAdapter(locations));
                } else {
                    Toast.makeText(getContext(), "Error en la respuesta", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<LocationItem>> call, Throwable t) {
                Toast.makeText(getContext(), "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
