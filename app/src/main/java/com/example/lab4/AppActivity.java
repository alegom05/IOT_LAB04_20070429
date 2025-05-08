package com.example.lab4;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class AppActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app); // tu layout con FrameLayout y BottomNav

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        // Obtener el NavController desde el NavHostFragment
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager()
                .findFragmentById(R.id.fragment_container);
        NavController navController = navHostFragment.getNavController();

        // Enlazar BottomNavigation con el NavController
        NavigationUI.setupWithNavController(bottomNavigationView, navController);
    }

    @Override
    public void onBackPressed() {
        // Al presionar atrás, regresar al MainActivity directamente
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
