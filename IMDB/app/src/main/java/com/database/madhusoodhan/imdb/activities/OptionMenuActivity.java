package com.database.madhusoodhan.imdb.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

/**
 * Created by madhusoodhan on 24-Apr-15.
 */
public class OptionMenuActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.welcome_screen);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater M = getMenuInflater();
        M.inflate(R.menu.options,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id =  item.getItemId();

        if(id == R.id.upcomingmovies){

            Intent in = new Intent(getApplicationContext(), UpcomingMoviesActivity.class);

            startActivity(in);

        }
        return true;
    }
}
