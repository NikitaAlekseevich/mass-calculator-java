package com.example.masscalculator;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.masscalculator.databinding.Fragment1Binding;

public class fragment1 extends Fragment {
    private Fragment1Binding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = Fragment1Binding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    void setCalculateResult(int inputValue) {
        String calcResult = "";
        // расчет значений в других единицах измерения
        double karats = inputValue * 5000;
        double grams = inputValue * 1000;
        double kilograms = inputValue;
        double centners = inputValue / 100;
        double tons = inputValue / 1000;
        double pounds = inputValue * 2.20462;
        double ounces = inputValue * 35.274;

        // форматирование результатов и вывод в текстовое поле
        calcResult = String.format("Караты: %.2f\nГраммы: %.2f\nКилограммы: %.2f\nЦентнеры: %.2f\nТонны: %.2f\nФунты: %.2f\nУнции: %.2f",
                karats, grams, kilograms, centners, tons, pounds, ounces);
        binding.textViewResult.setText(calcResult);
    }
}