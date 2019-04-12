package com.example.tax_calculator_rabin_gurung.presenter;

import android.view.View;
import android.widget.Button;

import com.example.tax_calculator_rabin_gurung.MainActivity;

public class Presenter {
    private MainActivity mainActivity;

    public Presenter(final MainActivity mainActivity, Button submit) {
        this.mainActivity = mainActivity;
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mainActivity.CheckForInputError()){
                    mainActivity.setResult(
                            Double.toString(CalculateTax(mainActivity.getInput())));
                }else{
                   mainActivity.setResult("Please give proper input");
                }
            }
        });

    }

    public Double CalculateTax(Double mtax){
        Double ytax = mtax *12;
        if(ytax < 200000){
            return 2000.0; // 1 % tax of 200000 is 2000
        }else if(ytax > 200000 && ytax < 350000){
            ytax -= 200000;
            return 2000 + 0.15 * ytax;
        }else{
            ytax -= 350000;
            return 2000 + 0.15*150000 + 0.25*ytax;
        }
    }
}
