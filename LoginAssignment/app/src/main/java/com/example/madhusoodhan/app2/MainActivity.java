package com.example.madhusoodhan.app2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by madhusoodhan on 11-Feb-15.
 */
public class MainActivity extends Activity {
    EditText etName, etPass;
    Button btSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main_screen);

        etName = (EditText)findViewById(R.id.et_username);
        etPass = (EditText)findViewById(R.id.et_password);
        btSignIn = (Button) findViewById(R.id.bt_signin);

        btSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               String userName = etName.getText().toString();
               String password = etPass.getText().toString();

                if(userName.equals("work")&& password.equals("worship")){

                    Intent intent = new Intent(MainActivity.this,FirstActivity.class);

                    Bundle b = new Bundle();
                    b.putString("user_name", userName);

                    intent.putExtras(b);

                    startActivity(intent);
                }
                else{
                    Toast.makeText(getApplicationContext(),"Invalid Credentials", Toast.LENGTH_LONG).show();
                }

            }
        });

    }
}
