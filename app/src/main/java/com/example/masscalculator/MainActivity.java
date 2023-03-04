package com.example.masscalculator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.masscalculator.R;


public class MainActivity extends AppCompatActivity {

    private EditText inputEditText;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputEditText = findViewById(R.id.inputEditText);
        resultTextView = findViewById(R.id.resultTextView);

        // установка обработчика событий на кнопку "Рассчитать"
        Button calculateButton = findViewById(R.id.calculateButton);
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate();
            }
        });
    }

    // метод для расчета значений в других единицах измерения
    private void calculate() {
        // получение входного значения от пользователя
        String inputString = inputEditText.getText().toString().trim();
        if (inputString.isEmpty()) {
            Toast.makeText(this, "Введите значение", Toast.LENGTH_SHORT).show();
            return;
        }
        double inputValue = Double.parseDouble(inputString);

        // расчет значений в других единицах измерения
        double karats = inputValue * 5000;
        double grams = inputValue * 1000;
        double kilograms = inputValue;
        double centners = inputValue / 100;
        double tons = inputValue / 1000;
        double pounds = inputValue * 2.20462;
        double ounces = inputValue * 35.274;

        // форматирование результатов и вывод в текстовое поле
        @SuppressLint("DefaultLocale") String resultString = String.format("Караты: %.2f\nГраммы: %.2f\nКилограммы: %.2f\nЦентнеры: %.2f\nТонны: %.2f\nФунты: %.2f\nУнции: %.2f",
                karats, grams, kilograms, centners, tons, pounds, ounces);
        resultTextView.setText(resultString);
    }
}