package com.hungrok.mycomponents;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.preference.PreferenceManager;

public class MyContentProvider extends ContentProvider {
    public MyContentProvider() {
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        // Implement this to handle requests to delete one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public String getType(Uri uri) {
        // TODO: Implement this to handle requests for the MIME type of the data
        // at the given URI.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        // TODO: Implement this to handle requests to insert a new row.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public boolean onCreate() {
        // TODO: Implement this to initialize your content provider on startup.
        System.out.printf("ContentProvide onCreate \n") ;
        SharedPreferences sp = getContext().getSharedPreferences("kwon",getContext().MODE_PRIVATE) ;

        System.out.printf("SharedPreferences=%s \n",sp.toString()) ;
        SharedPreferences.Editor ed = sp.edit() ;
        ed.putString("name","kwon Hungrok") ;
        ed.putInt("age",35) ;
        ed.putBoolean("male", true) ;
        ed.apply() ;


        return false;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        // TODO: Implement this to handle query requests from clients.
        throw new UnsupportedOperationException("Not yet implemented");

    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        // TODO: Implement this to handle requests to update one or more rows.

        SharedPreferences sp = getContext().getSharedPreferences("kwon",getContext().MODE_PRIVATE) ;
        System.out.printf("SharedPreferences=%s \n",sp.toString()) ;
        Boolean male= sp.getBoolean("male",false) ;
        Integer age = sp.getInt("age",0) ;
        String name = sp.getString("name","none") ;
        System.out.printf("ContentProvide update name=%s,age=%d,male=%s\n",name,age,male) ;

        return 1 ;
    }
}
