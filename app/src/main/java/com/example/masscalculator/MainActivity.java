package com.example.masscalculator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.masscalculator.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // установка обработчика событий на кнопку "Рассчитать"
        binding.calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate();
            }
        });
    }

    // метод для расчета значений в других единицах измерения
    private void calculate() {
        // получение входного значения от пользователя
        String inputString = binding.inputEditText.getText().toString().trim();
        if (inputString.isEmpty()) {
            Toast.makeText(this, "@string/enterValue_text", Toast.LENGTH_SHORT).show();
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
        binding.resultTextView.setText(resultString);
    }
}
