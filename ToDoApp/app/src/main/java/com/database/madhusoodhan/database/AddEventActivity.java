package com.database.madhusoodhan.database;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by madhusoodhan on 24-Feb-15.
 */
public class AddEventActivity extends ActionBarActivity {


    final Context context = this;
    CustomAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_to_do);

        ArrayList<EventEntity> eventList = getEventList();

        ListView list= (ListView)findViewById(R.id.ls_events);

        Resources res = getResources();

        adapter = new CustomAdapter(this,R.layout.list_row,eventList);

        if (list != null && adapter!=null)  {
            list.setAdapter(adapter);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater M = getMenuInflater();
        M.inflate(R.menu.options, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        final int id = item.getItemId();

        if(id== R.id.add_new_event){

            showNewAddEvent();

        }
        return true;
    }

    public void showNewAddEvent(){

        LayoutInflater li = LayoutInflater.from(context);
        final View addEventPrompt = li.inflate(R.layout.add_event_details, null);

        AlertDialog.Builder ad  = new AlertDialog.Builder(context);

        addItemsToPriorityList(addEventPrompt);
        final EditText toDoDescription = (EditText)addEventPrompt.findViewById(R.id.et_desc);

        ad.setView(addEventPrompt);
        ad.setCancelable(false);
        ad.setTitle("Add New Event");
        ad.setPositiveButton("ADD", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {

                String description = toDoDescription.getText().toString();
                String priority = getPriorityItem(addEventPrompt);
                String planDate = getFormattedDate(addEventPrompt);
                EventEntity event = new EventEntity(description, priority, planDate);

                DatabaseHandler db = new DatabaseHandler(context);
                Log.e("inserting....", "insert::");
                db.addContact(event);
                int count = db.getCount();

                List<EventEntity> updatedTasks = getEventList();
                adapter.updateList(updatedTasks);

            }
        }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "cancelled", Toast.LENGTH_SHORT).show();
                dialog.cancel();
            }
        });

        ad.show();

    }


    public String getPriorityItem(View priority_view){

        Spinner Priority_list = (Spinner)  priority_view.findViewById(R.id.sp_priority);

        String prioritySelected = String.valueOf(Priority_list.getSelectedItem());

        return prioritySelected;
    }

    public void addItemsToPriorityList(View priority_view){

        Spinner Priority_list = (Spinner)  priority_view.findViewById(R.id.sp_priority);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(context,R.array.priority_array,android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Priority_list.setAdapter(adapter);
    }


    public String getFormattedDate(View priority_view){
        DatePicker planDate = (DatePicker)priority_view.findViewById(R.id.dp_date);

        long datePlanned = planDate.getCalendarView().getDate();

        Date date = new Date(datePlanned);

        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        return dateFormat.format(date);

    }

    public ArrayList<EventEntity> getEventList(){

        DatabaseHandler db = new DatabaseHandler(this);

        return db.getAllEvents();
    }
}
