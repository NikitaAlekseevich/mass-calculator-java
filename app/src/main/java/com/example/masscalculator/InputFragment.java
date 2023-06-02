package com.example.masscalculator;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.masscalculator.databinding.FragmentInputBinding;

public class InputFragment extends Fragment {
    public interface onSomeEventListener {
        void someEvent(int value);
    }
    onSomeEventListener someEventListener;
    @Override
    public void onAttach(@NonNull Context context){
        super.onAttach(context);
        try {
            someEventListener = (onSomeEventListener) context;
        }
        catch (ClassCastException e){
            throw new ClassCastException(context +
                    " must implement on-SomeEventListener");
        }
    }
    private FragmentInputBinding binding;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        binding = FragmentInputBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        binding.calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                someEventListener.someEvent(Integer.parseInt(binding.inputEditText.getText().toString()));
            }
        });
        return view;
    }
}