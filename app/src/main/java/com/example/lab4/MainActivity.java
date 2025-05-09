package com.example.lab4;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

// El Main Activity controla la vista principal
// y también verifica que haya internet en la app.
// Tiene un logo relativo al clima y mi nombre y código.
// Con Ingresar entra a las 3 vistas que se encuentran
// con fragments. Solo la primera funciona.

public class MainActivity extends AppCompatActivity {

    Button btnIngresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (!NetworkUtils.isNetworkAvailable(this)) {
            showNoConnectionDialog();
            return;
        } else {
            showConnectionConfirmation();
        }

        btnIngresar = findViewById(R.id.btnIngresar);
        btnIngresar.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AppActivity.class);
            startActivity(intent);
            finish();
        });
    }

    private void showNoConnectionDialog() {
        new AlertDialog.Builder(this)
                .setTitle("Sin conexión a Internet")
                .setMessage("No hay conexión a Internet. ¿Deseas ir a los ajustes?")
                .setCancelable(false)
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

    private void showConnectionConfirmation() {
        new AlertDialog.Builder(this)
                .setTitle("Conexión a Internet")
                .setMessage("Hay conexión a Internet. Puede continuar usando la aplicación.")
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .show();

    }
}