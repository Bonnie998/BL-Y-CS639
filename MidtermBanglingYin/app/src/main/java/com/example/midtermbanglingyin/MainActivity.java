package com.example.midtermbanglingyin;

import android.os.Bundle;
import android.text.InputFilter;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText meterInput;
    private TextView millimeterOutput;
    private Button convertButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeViews();
        setupButtonClickEvent();
    }

    private void initializeViews() {
        meterInput = findViewById(R.id.meterInput);
        convertButton = findViewById(R.id.convertButton);
        millimeterOutput = findViewById(R.id.millimeterOutput);
        InputFilter[] filters = new InputFilter[]{new InputFilter.LengthFilter(10)};
        meterInput.setFilters(filters);
        meterInput.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
    }

    private void setupButtonClickEvent() {
        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    double meters = Double.parseDouble(meterInput.getText().toString());
                    double millimeters = meters * 1000;
                    millimeterOutput.setText(String.format("%.2f", millimeters));
                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "Please enter a valid number", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}