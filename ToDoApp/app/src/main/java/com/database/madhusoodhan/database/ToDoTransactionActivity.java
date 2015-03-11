
package com.database.madhusoodhan.database;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

/*
public class ToDoTransactionActivity extends Activity {

  Button bt_add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_to_do);

        bt_add = (Button)findViewById(R.id.add_button);

        bt_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseHandler db = new DatabaseHandler(ToDoTransactionActivity.this);

                Log.e("inserting....","insert::");
                  db.addContact(new Contacts("Krishna","22612"));
                 db.addContact(new Contacts("Krishna","22612"));
                  db.addContact(new Contacts("Krishna","22612"));
                 db.addContact(new Contacts("Krishna","22612"));


                int rowCount =  db.getCount();

                Log.e("status::", Long.toString(rowCount));

                // status = db.getCount();

                if(rowCount>=1){
                    Toast.makeText(getApplicationContext(),"Added Successfully",Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_LONG).show();
                }
            }
        });


    }
}*/

