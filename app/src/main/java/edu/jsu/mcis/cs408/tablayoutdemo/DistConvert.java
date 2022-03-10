package edu.jsu.mcis.cs408.tablayoutdemo;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;


import edu.jsu.mcis.cs408.tablayoutdemo.databinding.DistConvertBinding;

public class DistConvert extends Fragment {

    private DistConvertBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = DistConvertBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String temp = binding.Far.getText().toString();
                boolean convertToFer;
                boolean convertToCel;
                double mile;
                Log.i("log", temp);
                try {
                    mile = Double.parseDouble(temp);
                    mile *= 1.609;
                    binding.cel.setText("" + mile);
                }catch(Exception e){
                    temp = binding.cel.getText().toString();
                    double kilo;
                    kilo = Double.parseDouble(temp);
                    kilo /= 1.609;
                    binding.Far.setText("" + kilo);
                }

            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}