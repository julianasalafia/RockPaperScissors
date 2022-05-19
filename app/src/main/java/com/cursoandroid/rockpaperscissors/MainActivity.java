package com.cursoandroid.rockpaperscissors;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selectedRock(View view) {
        this.selectedChoice("Rock");
    }

    public void selectedPaper(View view) {
        this.selectedChoice("Paper");
    }

    public void selectedScissors(View view) {
        this.selectedChoice("Scissors");
    }

    public void selectedChoice(String userChoice) {
        ImageView image = findViewById(R.id.appsChoice);
        TextView result = findViewById(R.id.result);

        int number = new Random().nextInt(3);

        String[] options = {"Rock", "Paper", "Scissors"};
        String appsChoice = options[number];

        switch (appsChoice) {
            case "Rock":
                image.setImageResource(R.drawable.rock);
                break;

            case "Paper":
                image.setImageResource(R.drawable.paper);
                break;

            case "Scissors":
                image.setImageResource(R.drawable.scissors);
                break;
        }

        if ((appsChoice == "Scissors" && userChoice == "Paper") || (appsChoice == "Paper" && userChoice == "Rock") || (appsChoice == "Rock" && userChoice == "Scissors")) {
            result.setText("You loose! :(");
        } else if ((userChoice == "Scissors" && appsChoice == "Paper") || (userChoice == "Paper" && appsChoice == "Rock") || (userChoice == "Rock" && appsChoice == "Scissors")) {
            result.setText("You won! :)");
        } else {
            result.setText("Drawn o_ó");
        }
    }
}
