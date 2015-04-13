package com.database.madhusoodhan.imdb.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.database.madhusoodhan.imdb.entities.MovieDetailsEntity;


/**
 * Created by madhusoodhan on 09-Apr-15.
 */
public class MovieDetailsActivity extends Activity {

    // JSON node keys
    private static final String TAG_NAME = "name";
    private static final String TAG_EMAIL = "email";
    private static final String TAG_PHONE_MOBILE = "mobile";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_details);

        // getting intent data
        Intent in = getIntent();

        // Get JSON values from previous intent
        MovieDetailsEntity movie = (MovieDetailsEntity) in.getExtras().get("MOVIE_DETAILS");
        //String email = in.getStringExtra(TAG_EMAIL);
        //String mobile = in.getStringExtra(TAG_PHONE_MOBILE);

        // Displaying all values on the screen
        TextView lblName = (TextView) findViewById(R.id.tv_name);
        TextView lblEmail = (TextView) findViewById(R.id.tv_mobile);
        TextView lblMobile = (TextView) findViewById(R.id.tv_email);

        lblName.setText(movie.getName());
        lblEmail.setText(movie.getEmail());
        lblMobile.setText(movie.getMobile());
    }
}
