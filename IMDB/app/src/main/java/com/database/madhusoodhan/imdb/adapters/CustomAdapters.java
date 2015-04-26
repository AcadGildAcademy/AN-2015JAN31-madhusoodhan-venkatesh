package com.database.madhusoodhan.imdb.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.database.madhusoodhan.imdb.activities.R;
import com.database.madhusoodhan.imdb.entities.MovieDetailsEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by madhusoodhan on 25-Apr-15.
 */
public class CustomAdapters extends ArrayAdapter<MovieDetailsEntity> {

/**
 * ******** Declare Used Variables ********
 */
private Context context;
private ArrayList<MovieDetailsEntity> data;
        int i = 0;

/**
 * **********  CustomAdapter Constructor ****************
 *
 *
 */

public CustomAdapters(Context context, int row, ArrayList<MovieDetailsEntity> data) {

        super(context,row,data);

        /********** Take passed values **********/
        Log.d("Inside CustomAdapter ::" , "constructor");

        this.context = context;
        this.data = data;

        Log.d("Returning CustomAdapter ::" , "constructor");
        }


/**
 * ****** Create a holder Class to contain inflated xml file elements ********
 */
public static class ViewHolder {

    public TextView text;
    public TextView text1;
    public TextView text2;


}

    /**
     * *** Depends upon data size called for each row , Create each ListView row ****
     */
    public View getView(int position, View convertView, ViewGroup parent) {

        Log.d("Inside getView ::", "getView");

        View vi = convertView;
        ViewHolder holder;

        if (vi == null) {

            /****** Inflate tabitem.xml file for each row ( Defined below ) *******/
            LayoutInflater inflater = (LayoutInflater) context.
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            vi = inflater.inflate(R.layout.movie_details, null);

            /****** View Holder Object to contain tabitem.xml file elements ******/

            holder = new ViewHolder();
            holder.text = (TextView) vi.findViewById(R.id.tv_title);
            holder.text1 = (TextView) vi.findViewById(R.id.tv_releasedate);

            /************  Set holder with LayoutInflater ************/
            vi.setTag(holder);
        } else{
            holder = (ViewHolder)vi.getTag();
        }

        MovieDetailsEntity tempValues = data.get(position);

        /************  Set Model values in Holder elements ***********/

        holder.text.setText(tempValues.getTitle());
        holder.text1.setText(tempValues.getReleaseDate());

        Log.d("madhu", tempValues.getTitle());
        /******** Set Item Click Listner for LayoutInflater for each row *******/

        // vi.setOnClickListener(new OnItemClickListener( position ))
        return vi;
    }

    @Override
    public int getCount() {

        if(data!=null)
            return data.size();
        else
            return 0;
    }

    public void updateList(List<MovieDetailsEntity> newList) {
        data.clear();
        data.addAll(newList);
        this.notifyDataSetChanged();
    }

     /*   @Override
        public void onClick(View v) {
            Log.v("CustomAdapter", "=====Row button clicked=====");
        }

        ********** Called when Item click in ListView ************/
}



