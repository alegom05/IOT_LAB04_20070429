package com.example.lab4;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnIngresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // layout con el botón Ingresar

        // Verificar la conexión a Internet primero
        if (!NetworkUtils.isNetworkAvailable(this)) {
            showNoConnectionDialog();
            return; // Importante: evitar continuar con la inicialización normal
        }

        // Solo si hay conexión, inicializar el botón
        btnIngresar = findViewById(R.id.btnIngresar);
        btnIngresar.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AppActivity.class);
            startActivity(intent);
            finish();
        });
    }

    private void showNoConnectionDialog() {
        // Crear un Dialog para mostrar el error y dar la opción de ir a los Ajustes
        new AlertDialog.Builder(this)
                .setTitle("Sin conexión a Internet")
                .setMessage("No hay conexión a Internet. ¿Deseas ir a los ajustes?")
                .setCancelable(false)  // No permitir que el usuario cierre el diálogo
                .setPositiveButton("Configuración", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Redirigir a los Ajustes del dispositivo
                        Intent intent = new Intent(Settings.ACTION_WIFI_SETTINGS);
                        startActivity(intent);
                    }
                })
                .setNegativeButton("Salir", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Salir de la aplicación si no se desea ir a los ajustes
                        finish();
                    }
                })
                .show();
    }
}