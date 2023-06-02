package com.example.masscalculator;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.masscalculator.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements InputFragment.onSomeEventListener{
    private ActivityMainBinding binding;
    private static final int CONTENT_VIEW_ID = 10101010;
    InputFragment inputFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        binding.inputFragment.setId(CONTENT_VIEW_ID);
        inputFragment = new InputFragment();
        FragmentTransaction fragmentTransaction;
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(CONTENT_VIEW_ID, inputFragment);
    }

    @Override
    public void someEvent(int value) {
        fragment1 fragment1 = (com.example.masscalculator.fragment1) getSupportFragmentManager().
                findFragmentById(R.id.fragment1);
        if(fragment1 != null)
            fragment1.setCalculateResult(value);
    }
}
