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
    private String name;
    private String email;
    private String mobile;

    public MovieDetailsEntity(JSONObject jsonObj) throws JSONException {
        name = jsonObj.getString(ConstantTags.TAG_NAME);
        email = jsonObj.getString(ConstantTags.TAG_EMAIL);

        JSONObject j = jsonObj.getJSONObject(ConstantTags.TAG_PHONE);
        mobile = j.getString(ConstantTags.TAG_PHONE_MOBILE);

    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public MovieDetailsEntity(String name, String mobile, String email){
        this.name = name;
        this.mobile = mobile;
        this.email = email;
    }
}
