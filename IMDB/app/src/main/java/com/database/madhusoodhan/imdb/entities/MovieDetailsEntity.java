package com.database.madhusoodhan.imdb.entities;

import com.database.madhusoodhan.imdb.constants.ConstantTags;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

/**
 * Created by madhusoodhan on 11-Apr-15.
 */
public class MovieDetailsEntity implements Serializable {


    private String id;
    private String title;
    private String releaseDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public MovieDetailsEntity(JSONObject jsonObj) throws JSONException {
        title = jsonObj.getString(ConstantTags.TAG_TITLE);
        releaseDate = jsonObj.getString(ConstantTags.TAG_RELEASE_DATE);
    }

    public MovieDetailsEntity(String title, String releaseDate){
        this.title = title;
        this.releaseDate = releaseDate;
    }
}
