package com.example.i2m;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private TextView resultTextView;
    private EditText inchesEditText;
    private Button calculateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calculateButton = findViewById(R.id.calculateButton);
        inchesEditText = findViewById(R.id.inchesEditText);
        resultTextView = findViewById(R.id.resultTextView);


        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String height = inchesEditText.getText().toString();
                if (height.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Input Field Empty!", Toast.LENGTH_LONG).show();
                }
                else{
                    displayResult(height);
                }

            }
        });
    }
    private double calculateHeight(String height) {
        int heightInteger = Integer.parseInt(height);
        return heightInteger * 0.0254;
    }

    private void displayResult(String height) {
        double result = calculateHeight(height);
        DecimalFormat myDecimalFormatter = new DecimalFormat("0.00");
        String resultString = myDecimalFormatter.format(result);
        resultTextView.setText(resultString);
    }
}