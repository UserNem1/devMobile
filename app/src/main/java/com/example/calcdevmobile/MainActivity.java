package com.example.calcdevmobile;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.calcdevmobile.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button boutonCalc;
    private Button boutonHist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //Calculatrice
        boutonCalc = findViewById(R.id.buttonCalc);
        boutonCalc.setOnClickListener(v -> {
            Intent intent = new Intent(this, CalculatriceActivity.class);
            startActivity(intent);
            Toast.makeText(this,"Calculatrice lancée",Toast.LENGTH_LONG).show();
        });
        //Historique
        boutonHist = findViewById(R.id.buttonHist);
        boutonHist.setOnClickListener(v -> {
            Intent intent = new Intent(this, HistoriqueActivity.class);
            startActivity(intent);
            Toast.makeText(this,"Historique lancé",Toast.LENGTH_LONG).show();
        });
    }
}