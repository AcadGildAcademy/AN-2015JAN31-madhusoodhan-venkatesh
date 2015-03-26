package com.database.madhusoodhan.hideandseek;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by madhusoodhan on 24-Mar-15.
 */
public class MainActivity extends Activity {

    TextView tvWelcome;
    Button btHideSeek;
    String toggle = "ON";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main);


        btHideSeek = (Button) findViewById(R.id.bt_hideseek);
        tvWelcome = (TextView) findViewById(R.id.tv_welcome);

            btHideSeek.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (toggle.equals("ON")) {
                        tvWelcome.setVisibility(View.INVISIBLE);
                        btHideSeek.setText("Show");
                        toggle = "OFF";
                    } else if (toggle.equals("OFF")) {
                        tvWelcome.setVisibility(View.VISIBLE);
                        btHideSeek.setText("Hide");
                        toggle = "ON";
                    }

                }
            });


            }

    }

