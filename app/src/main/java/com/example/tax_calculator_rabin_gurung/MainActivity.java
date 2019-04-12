package com.example.tax_calculator_rabin_gurung;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.tax_calculator_rabin_gurung.presenter.Presenter;

public class MainActivity extends AppCompatActivity {
    private Button submit;
    private TextView result;
    private EditText et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        submit = findViewById(R.id.submit);
        result = findViewById(R.id.result);
        et = findViewById(R.id.et);


        new Presenter(this, submit);
    }

    public Boolean CheckForInputError(){
        if(TextUtils.isEmpty(et.getText().toString())){
            et.setError("Please a input");
            return false;
        }
        return true;
    }

    public Double getInput(){
        return Double.parseDouble(et.getText().toString());
    }

    public void setResult(String s){
        result.setText("The yearly tax is:"+s);
    }

}
