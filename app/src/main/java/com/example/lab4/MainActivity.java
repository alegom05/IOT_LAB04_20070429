package com.example.lab4;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnIngresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // layout con el botón Ingresar

        btnIngresar = findViewById(R.id.btnIngresar);
        btnIngresar.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AppActivity.class);
            startActivity(intent);
            finish();
        });
    }
}
