package com.aptron.sqlite;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBManager extends SQLiteOpenHelper {
    private static final String DB_NAME = "yami.db";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "users";
    private static final String C_ID = "id";
    private static final String C_EMAIL = "email";
    private static final String C_PASS = "pass";
    private static final String DB_TABLE = "CREATE TABLE "
            + TABLE_NAME + " (  "
            + C_ID + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
            + C_EMAIL + " TEXT,"
            + C_PASS + " TEXT);";

    public DBManager(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(DB_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public long insertData(String email, String pass) {
        SQLiteDatabase database = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(C_EMAIL, email);
        values.put(C_PASS, pass);
        long id = database.insert(TABLE_NAME, null, values);

        return id;
    }

    public boolean getUser(String email, String pass) {
        SQLiteDatabase database = getReadableDatabase();
        String query = "select * from " + TABLE_NAME + " where " + C_EMAIL + " = " + "'" + email + "'" + " and " +
                C_PASS + " = " + "'" + pass + "'";
        Cursor cursor = database.rawQuery(query, null);
        if (cursor.getCount() > 0) {
            return true;
        }
        database.close();
        cursor.close();
        return false;
    }
}
