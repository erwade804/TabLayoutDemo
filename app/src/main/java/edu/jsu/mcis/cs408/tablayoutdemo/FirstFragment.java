package edu.jsu.mcis.cs408.tablayoutdemo;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import edu.jsu.mcis.cs408.tablayoutdemo.databinding.TipConverterFragmentBinding;


public class FirstFragment extends Fragment {

    private @NonNull
    TipConverterFragmentBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = TipConverterFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String temp = binding.bill.getText().toString();
                double bill = Double.parseDouble(temp);
                temp = binding.tipPer.getText().toString();
                double tipPer = Double.parseDouble(temp);
                temp = binding.numPeople.getText().toString();
                double people = Double.parseDouble(temp);
                double calculation = (bill*(1.0+tipPer*.01))/people;
                calculation *= 100;
                calculation = Math.ceil(calculation);
                calculation /= 100;

                binding.output.setText("Total Per Person: $"+calculation);
            }
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}