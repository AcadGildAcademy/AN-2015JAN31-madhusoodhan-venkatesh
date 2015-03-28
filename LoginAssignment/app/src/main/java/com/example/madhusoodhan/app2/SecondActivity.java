package com.example.madhusoodhan.app2;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SecondActivity extends FragmentActivity {

    final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

                AlertDialog.Builder ad  = new AlertDialog.Builder(context);


                ad.setTitle("Add New Event");
                ad.setPositiveButton("ADD", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {



                        Toast.makeText(getApplicationContext()," added success", Toast.LENGTH_LONG).show();

                    }
                }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "cancelled", Toast.LENGTH_LONG).show();
                        dialog.cancel();
                    }
                });

                ad.show();

            }


}

