package com.sathvika.midtermsathvika;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private EditText sideLengthEditText;
    private TextView perimeterTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        sideLengthEditText = findViewById(R.id.side_length_edit_text);
        Button calculateButton = findViewById(R.id.calculate_button);
        perimeterTextView = findViewById(R.id.perimeter_text_view);

        calculateButton.setOnClickListener(v -> calculatePerimeter());

    }

    @SuppressLint({"SetTextI18n", "DefaultLocale"})
    private void calculatePerimeter() {
            String input = sideLengthEditText.getText().toString();
            if (input.isEmpty() || !input.matches("\\d+(\\.\\d+)?")) {
                Toast.makeText(this, "Invalid input. Please enter a positive number.", Toast.LENGTH_SHORT).show();
                return;
            }

            double sideLength = Double.parseDouble(input);
            if (sideLength <= 0) {
                Toast.makeText(this, "Side length must be positive.", Toast.LENGTH_SHORT).show();
                return;
            }
        double perimeter = 4 * sideLength;
        perimeterTextView.setText("Perimeter: " + String.format("%.2f", perimeter));
        Button calculateButton = findViewById(R.id.calculate_button);
        calculateButton.setBackgroundColor(Color.parseColor("#009688"));
    }

}