package com.database.madhusoodhan.database;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

    /**
     * ****** Adapter class extends with BaseAdapter and implements with OnClickListener ***********
     */
    public class CustomAdapter extends ArrayAdapter<EventEntity> {

        /**
         * ******** Declare Used Variables ********
         */
        private Context context;
        private ArrayList<EventEntity> data;
        private static LayoutInflater inflater = null;

        EventEntity tempValues = null;
        int i = 0;

        /**
         * **********  CustomAdapter Constructor ****************
         */
        public CustomAdapter(Context context, ArrayList<EventEntity> data) {
            super(context,R.layout.list_row,data);

            /********** Take passed values **********/
            Log.d("Inside CustomAdapter ::" , "constructor");
            this.context=context;
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

            Log.d("Inside getView ::" , "getView");
            View vi = convertView;
            ViewHolder holder;

            if (convertView == null) {

                /***********  Layout inflator to call external xml layout () ***********/
                inflater = (LayoutInflater) context.
                        getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                /****** Inflate tabitem.xml file for each row ( Defined below ) *******/
                vi = inflater.inflate(R.layout.list_row, null);

                /****** View Holder Object to contain tabitem.xml file elements ******/

                holder = new ViewHolder();
                holder.text = (TextView) vi.findViewById(R.id.tv_desc);
                holder.text1 = (TextView) vi.findViewById(R.id.tv_priority);
                holder.text2 = (TextView) vi.findViewById(R.id.tv_planned);

                /************  Set holder with LayoutInflater ************/
                vi.setTag(holder);
            } else {
                holder = (ViewHolder)vi.getTag();
               // holder.text.setText("No Data");
            }

                tempValues = data.get(position);

                /************  Set Model values in Holder elements ***********/

                holder.text.setText(tempValues.getDescription());
                holder.text1.setText(tempValues.getPriority());
                holder.text2.setText(tempValues.getPlanDate());


            Log.d("pushpa",tempValues.getDescription());

                /******** Set Item Click Listner for LayoutInflater for each row *******/

                // vi.setOnClickListener(new OnItemClickListener( position ));

            return vi;
        }

     /*   @Override
        public void onClick(View v) {
            Log.v("CustomAdapter", "=====Row button clicked=====");
        }

        ********** Called when Item click in ListView ************/
   }


