package com.database.madhusoodhan.imdb.activities;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;


import com.database.madhusoodhan.imdb.constants.ConstantTags;
import com.database.madhusoodhan.imdb.entities.MovieDetailsEntity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by madhusoodhan on 10-Apr-15.
 */
public class UpcomingMoviesActivity extends ListActivity {

    private ProgressDialog pDialog;

    private MovieDetailsEntity movieDetailsEntity;
    JSONArray movies = null;

    ArrayList<HashMap<String, MovieDetailsEntity>> contactList; //WHY LIST OF HASHMAPS SHOULD BE THERE

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_upcoming_movies);

        contactList = new ArrayList<HashMap<String, MovieDetailsEntity>>();

        ListView lvUpcomingMovies = getListView();

        lvUpcomingMovies.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //MovieDetailsEntity movieDetailsEntit
                String name = ((TextView) view.findViewById(R.id.tv_name)).getText().toString();
                String mob = ((TextView) view.findViewById(R.id.tv_mobile)).getText().toString();
                String email = ((TextView) view.findViewById(R.id.tv_email)).getText().toString();

                // Starting single contact activity
                Intent in = new Intent(getApplicationContext(), MovieDetailsActivity.class);

                movieDetailsEntity =  new MovieDetailsEntity(name,mob,email);

                in.putExtra("MOVIE_DETAILS", movieDetailsEntity);

                startActivity(in);

            }
        });

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
                movies = jsonObj.getJSONArray(ConstantTags.TAG_CONTACTS);

                // looping through All Contacts
                for (int i = 0; i < movies.length(); i++) {

                    JSONObject jsonMovies = movies.getJSONObject(i);

                    MovieDetailsEntity movieDetails = new MovieDetailsEntity(jsonMovies);

                    HashMap<String, MovieDetailsEntity> contact = new HashMap<String, MovieDetailsEntity>();

                    contact.put("MOVIE", movieDetails);

                    // adding contact to contact list
                    contactList.add(contact);
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


        ListAdapter adapter = new SimpleAdapter(
                UpcomingMoviesActivity.this, contactList,
                R.layout.movie_details, new String[] { ConstantTags.TAG_NAME, ConstantTags.TAG_EMAIL,
                ConstantTags.TAG_PHONE_MOBILE }, new int[] { R.id.tv_name,R.id.tv_mobile, R.id.tv_email });

        setListAdapter(adapter);
    }

}

}
















