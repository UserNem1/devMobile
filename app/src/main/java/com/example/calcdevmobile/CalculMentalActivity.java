package com.example.calcdevmobile;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Timer;
import java.util.TimerTask;

public class CalculMentalActivity extends AppCompatActivity {
    private TextView textViewCalcul;
    private TextView textViewInput;
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
    private Button buttonEquals;
    private Button buttonMinus;
    private Button buttonErase;


    private Double input = 0.0;
    private Double premierElement = 0.0;
    private Double deuxiemeElement = 0.0;
    private Double resultat = 0.0;
    private TypeOperation typeOperation;

    private int bonnesReponses = 0;
    private int mauvaisesReponses = 0;


    private Timer timer = new Timer();
    private TimerTask timerTask = new TimerTask(){
        @Override
        public void run() {
            timePassed();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calcul_mental);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        textViewCalcul = findViewById(R.id.textViewCalc);
        textViewInput = findViewById(R.id.textViewInput);
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
        buttonEquals = findViewById(R.id.buttonEquals);
        buttonMinus = findViewById(R.id.buttonMinus);
        buttonErase = findViewById(R.id.buttonErase);

        button0.setOnClickListener(v -> AppuieBoutonChiffre(0));
        button1.setOnClickListener(v -> AppuieBoutonChiffre(1));
        button2.setOnClickListener(v -> AppuieBoutonChiffre(2));
        button3.setOnClickListener(v -> AppuieBoutonChiffre(3));
        button4.setOnClickListener(v -> AppuieBoutonChiffre(4));
        button5.setOnClickListener(v -> AppuieBoutonChiffre(5));
        button6.setOnClickListener(v -> AppuieBoutonChiffre(6));
        button7.setOnClickListener(v -> AppuieBoutonChiffre(7));
        button8.setOnClickListener(v -> AppuieBoutonChiffre(8));
        button9.setOnClickListener(v -> AppuieBoutonChiffre(9));
        buttonEquals.setOnClickListener(v -> SubmitResult());
        buttonMinus.setOnClickListener(v -> OppositeResult());
        buttonErase.setOnClickListener(v -> Erase());

        NouveauCalcul();
        //TO DO: changer la valeur de delay
        timer.schedule(timerTask, 5000);
    }

    private void timePassed(){
        //Redirection vers écran de résultat
        Intent intent = new Intent(this, ResultsActivity.class);
        intent.putExtra("Bonnes Reponses", bonnesReponses);
        intent.putExtra("Mauvaises Reponses", mauvaisesReponses);
        startActivity(intent);
    }


    private void AppuieBoutonChiffre(Integer chiffre){
        input = input * 10 + chiffre;

        majTextView();
    }
    private void majTextView() {
        textViewInput.setText(input.toString());
    }
    private void majCalcTextView(){
        switch(typeOperation){
            case ADD:
                textViewCalcul.setText(premierElement + " + " + deuxiemeElement);
                break;
            case SUBSTRACT:
                textViewCalcul.setText(premierElement + " - " + deuxiemeElement);
                break;
            case DIVIDE:
                textViewCalcul.setText(premierElement + " / " + deuxiemeElement);
                break;
            case MULTIPLY:
                textViewCalcul.setText(premierElement + " * " + deuxiemeElement);
                break;
        }
    }
    private void SubmitResult(){
        if (input.equals(resultat)) {
            BonneReponse();
            Toast.makeText(this,"Bonne réponse",Toast.LENGTH_SHORT).show();
        }
        else {
            MauvaiseReponse();
            Toast.makeText(this,"Mauvaise réponse",Toast.LENGTH_SHORT).show();
        }

        input = 0.0;
        majTextView();
        NouveauCalcul();
    }
    private void OppositeResult(){
        input = -input;

        majTextView();
    }
    private void Erase(){
        input = 0.0;

        majTextView();
    }

    private void BonneReponse(){
        bonnesReponses++;

        NouveauCalcul();
    }
    private void MauvaiseReponse(){
        mauvaisesReponses++;

        NouveauCalcul();
    }

    private void NouveauCalcul(){
        //0 - 99
        int premRNG = (int)(Math.random() * 100);
        int deuxRNG = (int)(Math.random() * 100);
        //elements
        premierElement = Double.valueOf(premRNG);
        deuxiemeElement = Double.valueOf(deuxRNG);
        //operation
        int operation = (int)(Math.random() * 3);

        switch (operation) {
            case 0:
                resultat = premierElement + deuxiemeElement;
                typeOperation = TypeOperation.ADD;
                break;
            case 1:
                resultat = premierElement - deuxiemeElement;
                typeOperation = TypeOperation.SUBSTRACT;
                break;
            case 2:
                resultat = premierElement * deuxiemeElement;
                typeOperation = TypeOperation.MULTIPLY;
                break;
            default :
                break;
        }

        majCalcTextView();
    }
}
