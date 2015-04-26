package com.database.madhusoodhan.imdb.activities;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;


import com.database.madhusoodhan.imdb.adapters.CustomAdapters;
import com.database.madhusoodhan.imdb.constants.ConstantTags;
import com.database.madhusoodhan.imdb.entities.MovieDetailsEntity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by madhusoodhan on 10-Apr-15.
 */
public class UpcomingMoviesActivity extends ActionBarActivity {

    private ProgressDialog pDialog;
    private MovieDetailsEntity movieDetailsEntity;
    JSONArray movies = null;
    ArrayList<MovieDetailsEntity> movieList; //WHY LIST OF HASHMAPS SHOULD BE THERE
    CustomAdapters adapter;
    ListView list;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_screen);

        movieList = new ArrayList<MovieDetailsEntity>();

        list = (ListView)findViewById(R.id.ls_movies);

      /*  list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //MovieDetailsEntity movieDetailsEntit
                String title = ((TextView) view.findViewById(R.id.tv_title)).getText().toString();
                String releaseDate = ((TextView) view.findViewById(R.id.tv_releasedate)).getText().toString();

                // Starting single contact activity
                Intent in = new Intent(getApplicationContext(), MovieDetailsActivity.class);

                movieDetailsEntity =  new MovieDetailsEntity(title,releaseDate);

                in.putExtra("MOVIE_DETAILS", movieDetailsEntity);

                startActivity(in);

            }
        });*/

        new GetMovies().execute();

    }


private class GetMovies extends AsyncTask<Void, Void, Void> {

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        // Showing progress dialog
        pDialog = new ProgressDialog(UpcomingMoviesActivity.this);
        pDialog.setMessage("Please wait...");
        pDialog.setCancelable(false);
        pDialog.show();

    }

    @Override
    protected Void doInBackground(Void... arg0) {

        ServiceHandler sh = new ServiceHandler();

        String jsonStr = sh.makeServiceCall(ConstantTags.upcomingMoviesUrl, ServiceHandler.GET);

        Log.d("Response: ", "> " + jsonStr);

        if (jsonStr != null) {
            try {
                JSONObject jsonObj = new JSONObject(jsonStr);

                // Getting JSON Array node
                movies = jsonObj.getJSONArray(ConstantTags.TAG_MOVIES);

                // looping through All Contacts
                for (int i = 0; i < movies.length(); i++) {

                    JSONObject jsonMovies = movies.getJSONObject(i);

                    MovieDetailsEntity movieDetails = new MovieDetailsEntity(jsonMovies);

                    movieList.add(movieDetails);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            Log.e("ServiceHandler", "Couldn't get any data from the url");
        }
        return null;
    }
    @Override
    protected void onPostExecute(Void result) {
        super.onPostExecute(result);

        if (pDialog.isShowing())
            pDialog.dismiss();

        adapter = new CustomAdapters(UpcomingMoviesActivity.this,R.layout.movie_details,movieList);

        if(movieList != null && adapter!=null){
            list.setAdapter(adapter);
        }
    }

}


    public HashMap<String,String> getContactTags(MovieDetailsEntity movieDetails ){

        HashMap<String, String> contact = new HashMap<>();
        contact.put(ConstantTags.TAG_ID, movieDetails.getId());
        contact.put(ConstantTags.TAG_TITLE, movieDetails.getTitle());
        contact.put(ConstantTags.TAG_RELEASE_DATE, movieDetails.getReleaseDate());

        return contact;

    }

}
















