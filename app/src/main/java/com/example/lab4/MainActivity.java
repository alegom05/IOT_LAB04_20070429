package com.example.lab4;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.example.lab4.LocationFragment;
import com.example.lab4.R;

public class MainActivity extends AppCompatActivity {

    private Button btnIngresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tvTitulo = findViewById(R.id.tvTitulo);
        ImageView ivIcono = findViewById(R.id.ivIcono);
        TextView tvDatos = findViewById(R.id.tvDatos);
        btnIngresar = findViewById(R.id.btnIngresar);

        tvTitulo.setText("TELEWEATHER");
        tvDatos.setText("Alejandro Gómez 20070429");

        btnIngresar.setOnClickListener(view -> {
            // Reemplaza la vista por LocationFragment
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(android.R.id.content, new  LocationFragment())
                    .addToBackStack(null)
                    .commit();
        });
    }
}
