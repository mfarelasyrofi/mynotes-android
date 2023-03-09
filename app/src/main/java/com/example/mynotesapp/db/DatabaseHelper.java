package com.example.mynotesapp.db;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.mynotesapp.db.DatabaseContract.NoteColumns;

import static com.example.mynotesapp.db.DatabaseContract.NoteColumns.TABLE_NAME;

class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "dbnoteapp";

    private static final int DATABASE_VERSION = 1;

    private static final String SQL_CREATE_TABLE_NOTE = String.format("CREATE TABLE %s"
                    + " (%s INTEGER PRIMARY KEY AUTOINCREMENT," +
                    " %s TEXT NOT NULL," +
                    " %s TEXT NOT NULL," +
                    " %s TEXT NOT NULL)",
            TABLE_NAME,
            NoteColumns._ID,
            NoteColumns.TITLE,
            NoteColumns.DESCRIPTION,
            NoteColumns.DATE
    );

    DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TABLE_NOTE);
    }

    /*
    The onUpgrade method will be called when there is a version difference.
    Use the onUpgrade method to perform the data migration process
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        /*
        Drop table is not recommended when the migration process occurs because user data will be lost
        */
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}