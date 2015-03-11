package com.database.madhusoodhan.database;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by madhusoodhan on 25-Feb-15.
 */
public class DatabaseHandler extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "ContactsManager";
    private static final int DATABASE_VER = 1;
    private static final String TABLE_TODO = "todoevents";

    private static final String KEY_ID = "id";
    private static final String KEY_DESCRIPTION="description";
    private static final String KEY_PRIORITY = "priority";
    private static final String KEY_PLAN_DATE = "plandate";


    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VER);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " +TABLE_TODO+ "("
                                        +KEY_ID+  " INTEGER PRIMARY KEY AUTOINCREMENT,"
                                        +KEY_DESCRIPTION+ " TEXT,"
                                        +KEY_PRIORITY+ " TEXT,"
                                        +KEY_PLAN_DATE+ " TEXT)";

        db.execSQL(CREATE_CONTACTS_TABLE);
        Log.d("Table Created Successfully::","todoevents");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addContact(EventEntity event){

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(KEY_DESCRIPTION, event.getDescription());
        values.put(KEY_PRIORITY, event.getPriority());
        values.put(KEY_PLAN_DATE, event.getPlanDate());

        Long status = db.insert(TABLE_TODO, null,values);
        Log.e("db status::" , Long.toString(status));
        db.close();
    }

    public int getCount(){

       String countQuery = "SELECT * FROM " +TABLE_TODO;
       SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery,null);
        //cursor.close();
        Log.e("no of rows ", Integer.toString(cursor.getCount()));
        return cursor.getCount();

    }

    public ArrayList<EventEntity> getAllEvents(){

        ArrayList<EventEntity> eventList = new ArrayList<EventEntity>();

        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery =  "SELECT * FROM " +TABLE_TODO;
        Cursor cursor = db.rawQuery(selectQuery,null);

        final int isTableEmpty = cursor.getCount();
        if(isTableEmpty<1){
            return null;
        }

        else if(cursor.moveToFirst()){
            do{
                EventEntity event = new EventEntity();
                event.setId(Integer.parseInt(cursor.getString(0)));
                event.setDescription(cursor.getString(1));
                Log.d("pushpa",cursor.getString(1));
                event.setPriority(cursor.getString(2));
                event.setPlanDate(cursor.getString(3));

                eventList.add(event);
            }while(cursor.moveToNext());

        }
        return  eventList;

    }
}