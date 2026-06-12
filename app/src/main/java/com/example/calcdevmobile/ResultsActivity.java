package com.example.calcdevmobile;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ResultsActivity extends AppCompatActivity {
    private TextView textViewRight;
    private TextView textViewWrong;
    private TextView textViewPercentage;
    private Button buttonMiniGame;
    private Button buttonMenu;

    private int bonnesReponses = 0;
    private int mauvaisesReponses = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.results);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        textViewRight = findViewById(R.id.textViewRight);
        textViewWrong = findViewById(R.id.textViewWrong);
        textViewPercentage = findViewById(R.id.textViewPercentage);
        buttonMiniGame = findViewById(R.id.buttonMiniGame);
        buttonMenu = findViewById(R.id.buttonMenu);

        textViewRight.setText("Bonnes Réponses : " + bonnesReponses);
        textViewWrong.setText("Mauvaises Réponses : " + mauvaisesReponses);
        textViewPercentage.setText("Pourcentage : " + bonnesReponses/mauvaisesReponses*100 + "%");
        buttonMiniGame.setOnClickListener(v -> MiniGame());
        buttonMenu.setOnClickListener(v -> Menu());
    }

    private void MiniGame(){

    }
    private void Menu(){

    }
}
