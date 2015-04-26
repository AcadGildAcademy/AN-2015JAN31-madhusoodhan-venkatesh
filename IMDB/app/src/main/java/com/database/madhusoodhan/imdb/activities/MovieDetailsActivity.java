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
   // private static final String TAG_TITLE = "original_title";
    //private static final String TAG_RELEASE_DATE = "release_date";
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
        TextView lblTitle = (TextView) findViewById(R.id.tv_title);
        TextView lblReleaseDate = (TextView) findViewById(R.id.tv_releasedate);

        lblTitle.setText(movie.getTitle());
        lblReleaseDate.setText(movie.getReleaseDate());

    }
}
