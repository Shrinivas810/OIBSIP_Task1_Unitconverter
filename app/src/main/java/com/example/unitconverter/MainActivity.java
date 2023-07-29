package com.example.unitconverter;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinnerFrom = findViewById(R.id.spinner_from);
        Spinner spinnerTo = findViewById(R.id.spinner_to);
        ArrayAdapter<CharSequence> lengthAdapter = ArrayAdapter.createFromResource(this,
                R.array.length_units_array, android.R.layout.simple_spinner_item);
        lengthAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerFrom.setAdapter(lengthAdapter);
        spinnerTo.setAdapter(lengthAdapter);
    }

    public void convertLength(View view) {
        Spinner spinnerFrom = findViewById(R.id.spinner_from);
        Spinner spinnerTo = findViewById(R.id.spinner_to);
        EditText editText = findViewById(R.id.et_input);
        TextView textViewResult = findViewById(R.id.tv_result);

        String fromUnit = spinnerFrom.getSelectedItem().toString();
        String toUnit = spinnerTo.getSelectedItem().toString();
        double inputValue = Double.parseDouble(editText.getText().toString());

        double result = convertLengthValue(inputValue, fromUnit, toUnit);

        textViewResult.setText(String.format(Locale.getDefault(), "%.2f %s", result, toUnit));
    }

    private double convertLengthValue(double value, String fromUnit, String toUnit) {

        double result = 0.0;


        if (fromUnit.equals("Meters")) {
            // Convert from Meters to the desired unit
            switch (toUnit) {
                case "Meters":
                    result = value;
                    break;
                case "Feet":
                    result = value * 3.28084;
                    break;
                case "Centimeters":
                    result = value * 100;
                    break;
                case "Inches":
                    result = value * 39.3701;
                    break;

            }
        } else if (fromUnit.equals("Feet")) {
            // Convert from Feet to the desired unit
            switch (toUnit) {
                case "Meters":
                    result = value * 0.3048;
                    break;
                case "Feet":
                    result = value;
                    break;
                case "Centimeters":
                    result = value * 30.48;
                    break;
                case "Inches":
                    result = value * 12;
                    break;
            }
        }

        else if (fromUnit.equals("Centimeters")) {
            // Convert from Centimeters to the desired unit
            switch (toUnit) {
                case "Meters":
                    result = value * 0.01;
                    break;
                case "Feet":
                    result = value * 0.0328084;
                    break;
                case "Centimeters":
                    result = value;
                    break;
                case "Inches":
                    result = value * 0.393701;
                    break;

            }
        } else if (fromUnit.equals("Inches")) {
            // Convert from Inches to the desired unit
            switch (toUnit) {
                case "Meters":
                    result = value * 0.0254;
                    break;
                case "Feet":
                    result = value * 0.0833333;
                    break;
                case "Centimeters":
                    result = value * 2.54;
                    break;
                case "Inches":
                    result = value;
                    break;
                
            }
        }
        return result;
    }
}
