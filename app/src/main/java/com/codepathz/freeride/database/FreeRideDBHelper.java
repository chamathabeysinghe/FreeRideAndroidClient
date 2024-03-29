package com.codepathz.freeride.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Chamath Abeysinghe on 2/8/2017.
 */

public class FreeRideDBHelper extends SQLiteOpenHelper {


    public static final int DATABASE_VERSION=1;
    public static final String DATABASE_NAME="FreeRide.db";


    private static final String COMMA_SEP = ",";
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + DataContract.SystemData.TABLE_NAME + " (" +
                    DataContract.SystemData._ID + " INTEGER PRIMARY KEY," +
                    DataContract.SystemData.COLUMN_NAME_ATTRIBUTE + " TEXT NOT NULL " + COMMA_SEP +
                    DataContract.SystemData.COLUMN_NAME_VALUE + " TEXT"   +" )";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + DataContract.SystemData.TABLE_NAME;


    private static  FreeRideDBHelper dbHelper;

    private FreeRideDBHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    public static FreeRideDBHelper getDbHelper(Context context){
        if(dbHelper==null)dbHelper=new FreeRideDBHelper(context);
        return dbHelper;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_ENTRIES);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(SQL_DELETE_ENTRIES);
        onCreate(sqLiteDatabase);
    }
}
