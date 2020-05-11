package com.example.whereruiot;


import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by seegate on 1/17/2016.
 */
public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "TestDB";
    private static final String TABLE_PERSON = "User_table";
    private static final String KEY_ID = "id";
    private static final String KEY_Name = "name";
    private static final String KEY_Person1_NAME = "person1_name";
    private static final String KEY_Person2_NAME = "person2_name";

    public DatabaseHandler(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_PERSON_TABLE = "CREATE TABLE " + TABLE_PERSON + "("
                + KEY_ID + " INTEGER PRIMARY KEY,"
                + KEY_Name + " TEXT," + KEY_Person1_NAME + " TEXT,"
                + KEY_Person2_NAME + " TEXT" + ")";
        db.execSQL(CREATE_PERSON_TABLE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PERSON);
        onCreate(db);
    }

    public void save(User user){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        //values.put(KEY_ID, user.getId());
        values.put(KEY_Name, user.getName());
        values.put(KEY_Person1_NAME, user.getPerson1Name());
        values.put(KEY_Person2_NAME, user.getPerson2Name());

        db.insert(TABLE_PERSON, null, values);
        db.close();
    }

    public User findOne(int id){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor;
        cursor=db.query(TABLE_PERSON, new String[]{KEY_ID,KEY_Name,KEY_Person1_NAME,KEY_Person2_NAME},
                KEY_ID+"=?", new String[]{String.valueOf(id)}, null, null, null);
        if(cursor!=null){
            cursor.moveToFirst();
        }
        return new User(cursor.getInt(0),cursor.getString(1),cursor.getString(2),cursor.getString(3));
    }

    public List<User> findAll(){
        List<User> listperson=new ArrayList<User>();
        String query="SELECT * FROM "+TABLE_PERSON;

        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery(query, null);

        if(cursor.moveToFirst()){
            do{
                User user=new User();
                user.setId(cursor.getInt(0));
                user.setName(cursor.getString(1));
                user.setPerson1Name(cursor.getString(2));
                user.setPerson2Name(cursor.getString(3));
                listperson.add(user);
            }while(cursor.moveToNext());
        }

        return listperson;
    }

  /*  public void update(User user){
        SQLiteDatabase db=this.getWritableDatabase();

        ContentValues values=new ContentValues();
        values.put(KEY_Person1_NAME , user.getPerson1Name());
        values.put(KEY_Person2_NAME, user.getPerson2Name());

        db.update(TABLE_PERSON, values, KEY_Name+"=?", new String[]{String.valueOf(user.getName())});
        db.close();
    }*/

    public void delete(User user){
        SQLiteDatabase db=this.getWritableDatabase();
        db.delete(TABLE_PERSON, KEY_Name+"=?", new String[]{String.valueOf(user.getName())});
        db.close();
    }
}