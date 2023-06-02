package com.example.masscalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.masscalculator.databinding.ActivityMainBinding;



public class AboutProgram extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        com.example.masscalculator.databinding.ActivityMainBinding binding = ActivityMainBinding.
                inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setContentView(R.layout.activity_about_program);

        Intent intent = getIntent();
        String resultString = intent.getStringExtra("result");

        TextView textView = findViewById(R.id.textInfo);
        textView.setText(resultString);
    }

    public void ReturnCalc(View view) {
        finish();
    }

}