package com.example.lab2fintechapps;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.lab2fintechapps.exception.InvalidInputException;
import com.example.lab2fintechapps.util.TextCounter;

public class MainActivity extends AppCompatActivity {

    private EditText edtInputText;
    private Spinner spnCountType;
    private Button btnCalculate;
    private TextView tvResult;
    private TextCounter textCounter;
    private String selectedCountType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeViews();
        setupSpinner();
        setupButtonListener();

        textCounter = new TextCounter();
    }

    private void initializeViews() {
        edtInputText = findViewById(R.id.edtInputText);
        spnCountType = findViewById(R.id.spnCountType);
        btnCalculate = findViewById(R.id.btnCalculate);
        tvResult = findViewById(R.id.tvResult);
    }

    private void setupSpinner() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.count_types,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnCountType.setAdapter(adapter);

        spnCountType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedCountType = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                selectedCountType = getResources().getStringArray(R.array.count_types)[0];
            }
        });
    }

    private void setupButtonListener() {
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    calculateAndDisplay();
                } catch (InvalidInputException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    private void calculateAndDisplay() throws InvalidInputException {
        String inputText = edtInputText.getText().toString();

        if (inputText.trim().isEmpty()) {
            Toast.makeText(
                    this,
                    R.string.error_empty_input,
                    Toast.LENGTH_SHORT
            ).show();
            tvResult.setText("");
            return;
        }

        int count;
        String resultMessage;
        String[] countTypes = getResources().getStringArray(R.array.count_types);

        if (selectedCountType.equals(countTypes[0])) {
            count = textCounter.countWords(inputText);
            resultMessage = getString(R.string.result_words, count);
        } else {
            count = textCounter.countPunctuationMarks(inputText);
            resultMessage = getString(R.string.result_punctuation, count);
        }

        tvResult.setText(resultMessage);
    }
}