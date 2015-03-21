package com.example.madhusoodhan.myapplication;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by madhusoodhan on 08-Feb-15.
 */
public class FirstScreen extends Activity implements View.OnClickListener {

    EditText name, pass;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.first_screen);

        name = (EditText) findViewById(R.id.et_name);
        pass = (EditText) findViewById(R.id.et_pass);
        button =(Button) findViewById(R.id.bt_sign_in);

        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch(v.getId()){

            case R.id.bt_sign_in:
                                String userName= name.getText().toString();
                                String password= pass.getText().toString();

                    if(userName.equals("worship") && password.equals("work")){
                        Toast.makeText(getApplicationContext(),"Welcome",Toast.LENGTH_LONG).show();
                    }
                    else{
                        Toast.makeText(getApplicationContext(),"Invalid Credentials",Toast.LENGTH_LONG).show();
                    }


        }

    }
}
