package com.example.calcdevmobile;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CalculatriceActivity extends AppCompatActivity {

    private Button buttonPlus;
    private Button buttonMinus;
    private Button buttonTimes;
    private Button buttonDivide;

    private Button button0;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;

    private TextView textViewCalcul;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calculatrice);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        textViewCalcul = findViewById(R.id.textViewCalc);
        buttonPlus = findViewById(R.id.buttonPlus);
        buttonMinus = findViewById(R.id.buttonMinus);
        buttonTimes = findViewById(R.id.buttonTimes);
        buttonDivide = findViewById(R.id.buttonDivide);

        button0.setOnClickListener(v -> textViewCalcul.append("0"));
        button1.setOnClickListener(v -> textViewCalcul.append("1"));
        button2.setOnClickListener(v -> textViewCalcul.append("2"));
        button3.setOnClickListener(v -> textViewCalcul.append("3"));
        button4.setOnClickListener(v -> textViewCalcul.append("4"));
        button5.setOnClickListener(v -> textViewCalcul.append("5"));
        button6.setOnClickListener(v -> textViewCalcul.append("6"));
        button7.setOnClickListener(v -> textViewCalcul.append("7"));
        button8.setOnClickListener(v -> textViewCalcul.append("8"));
        button9.setOnClickListener(v -> textViewCalcul.append("9"));

        buttonPlus.setOnClickListener(v -> textViewCalcul.append("+"));
        buttonMinus.setOnClickListener(v -> textViewCalcul.append("-"));
        buttonTimes.setOnClickListener(v -> textViewCalcul.append("*"));
        buttonDivide.setOnClickListener(v -> textViewCalcul.append("/"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.monmenu, menu);
        MenuItem boutonRAZ = menu.findItem(R.id.menu_raz);
        boutonRAZ.setOnMenuItemClickListener(item -> {
            textViewCalcul.setText("");
            return true;
        });
        return super.onCreateOptionsMenu(menu);
    }
}