package com.codepathz.freeride.database;

import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by Chamath Abeysinghe on 2/8/2017.
 */

public class DataContract {

    private DataContract(){}

    //general detabase Uri s
    public static final String CONTENT_AUTHORITY="com.codepathz.freeride";
    public static final String PATH_MOVIE="data";
    public static final Uri BASE_CONTENT_URI= Uri.parse("content://" + CONTENT_AUTHORITY);
    public static final Uri CONTENT_URI=BASE_CONTENT_URI.buildUpon().appendPath(PATH_MOVIE).build();


    //data table for Rates
    public static class SystemData implements BaseColumns {
        public static final String TABLE_NAME = "config";
        public static final String COLUMN_NAME_ATTRIBUTE = "attribute";
        public static final String COLUMN_NAME_VALUE = "attr_value";

    }



}
