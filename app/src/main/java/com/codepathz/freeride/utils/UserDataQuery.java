package com.codepathz.freeride.utils;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.codepathz.freeride.database.DataContract;
import com.codepathz.freeride.database.FreeRideDBHelper;

/**
 * Created by Chamath Abeysinghe on 2/8/2017.
 */

public class UserDataQuery {

    public static String findUserCode(){
        SQLiteDatabase db=FreeRideDBHelper.getDbHelper(null).getReadableDatabase();
        String projection[]={DataContract.SystemData.COLUMN_NAME_ATTRIBUTE,DataContract.SystemData.COLUMN_NAME_VALUE};
        String selectionArgs[]={"userId"};
        String selection=DataContract.SystemData.COLUMN_NAME_ATTRIBUTE+" = ? ";
        Cursor cursor=db.query(
                DataContract.SystemData.TABLE_NAME,
                projection,
                selection,
                selectionArgs,
                null,
                null,
                null
        );
        while(cursor.moveToNext()){
            String userId=cursor.getString(cursor.getColumnIndex(DataContract.SystemData.COLUMN_NAME_VALUE));
            return userId;
        }
        return null;
    }
}





