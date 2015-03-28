package com.example.madhusoodhan.app2;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by madhusoodhan on 11-Feb-15.
 */
public class FirstActivity extends ActionBarActivity {

    ListView list;

    private static final int Menu1 = 100;

    private static final int Menu2 = 101;

    private static final int Menu3 = 102;

    TextView tvUserName;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.first_page);

        String userName = getIntent().getExtras().getString("user_name");

        tvUserName = (TextView) findViewById(R.id.tv_user_name);

        tvUserName.setText("Hi " +userName );

        List<String> item = new ArrayList<String>();

        for(int i=1;i<10; i++){
            item.add("item"+i);
        }

        list = (ListView) findViewById(R.id.ls_month);

        ArrayAdapter<String> ad = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, android.R.id.text1,item);

        list.setAdapter(ad);

        //register list for context menu

        registerForContextMenu(list);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Options");


        menu.add(0,Menu1,1,"Cut");
        menu.add(0,Menu2,2,"Copy");
        menu.add(1,Menu3,3,"Delete");
    }


    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if(item.getItemId()==Menu1){
            Toast.makeText(getApplicationContext(),"Cut" , Toast.LENGTH_LONG).show();
        }
        else if(item.getItemId()==Menu2){
            Toast.makeText(getApplicationContext(),"Copy" , Toast.LENGTH_LONG).show();
        }else {
            return false;
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater M = getMenuInflater();

        M.inflate(R.menu.options,menu);

       return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id= item.getItemId();

        if(id== R.id.settings){
            Toast.makeText(getApplicationContext(),"settings" , Toast.LENGTH_LONG).show();

            /*Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
            startActivity(intent);*/
            AlertDialog.Builder ad  = new AlertDialog.Builder(FirstActivity.this);


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
    return true;

    }
}
