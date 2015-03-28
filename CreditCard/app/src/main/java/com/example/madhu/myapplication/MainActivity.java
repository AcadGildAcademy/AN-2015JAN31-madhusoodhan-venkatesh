package com.example.madhu.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by 754158 on 2/27/2015.
 */
public class MainActivity extends Activity {

    EditText etCardNum, etRate, etMinPayment,etCardBal,etRemMonths,etInterest;
    Button btCompute,btClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        btCompute = (Button)findViewById(R.id.bt_compute);
        btClear = (Button)findViewById(R.id.bt_clear);

        etRate = (EditText)findViewById(R.id.et_int_rate);
        etMinPayment = (EditText)findViewById(R.id.et_int_rate);
        etCardBal = (EditText)findViewById(R.id.et_card_bal);
        etRemMonths = (EditText)findViewById(R.id.et_months_rem);
        etInterest = (EditText)findViewById(R.id.et_int_rate);


        btCompute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final int principal = 10000;
                final int intRate = Integer.parseInt(etRate.getText().toString());
                final int minPayment = Integer.parseInt(etMinPayment.getText().toString());

               



            }
        });

    }
}
