package com.example.android.pets.data;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class PetDBHelper extends SQLiteOpenHelper {

    private static final int DatabaseVersion = 1;
    private static final String DatabaseName = "pets.db";

    private static String CreateTable = "CREATE TABLE " + petContract.petEntry.Table_Name + " ("
            + petContract.petEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + petContract.petEntry.Column_Pet_Name + " TEXT NOT NULL, "
            + petContract.petEntry.Column_Pet_Breed + " TEXT, "
            + petContract.petEntry.Column_Pet_Gender + " INTEGER NOT NULL, "
            + petContract.petEntry.Column_Pet_Weight + " INTEGER NOT NULL DEFAULT 0);";

    private static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + petContract.petEntry.Table_Name;

    public PetDBHelper(Context context){
        super(context, DatabaseName, null, DatabaseVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CreateTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
}
