package astitva.expensesmanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBVehicle {

    private static final String TAG = "DBVehicle";

    //File Names

    public static final String KEY_ROWID = "_id";
    public static final String KEY_TYPE = "type";
    public static final String KEY_TASK = "task";
    public static final String KEY_DATE = "date";

    public static final String[] ALL_KEYS= new String[]{KEY_ROWID,KEY_TYPE,KEY_TASK,KEY_DATE};

    // column number for each field Name:

    public static final String COL_ROWID = "0";
    public static final String COL_TASK = "1";
    public static final String COL_DATE = "2";

    //DATABASE info

    public static final String DATABASE_NAME = "vehicle";
    public static final String TABLE_NAME = "mainToDo";
    public static final int DATABASE_VERSION=2;


    //sql statement to create database

    private static final String CREATE_TABLE = "create table mainToDo (_id INTEGER PRIMARY KEY AUTOINCREMENT , "
            + " type text not null,task text not null, date text);";

    private final Context context;

    private DBVehicle.DatabaseHelper myDBHelper;

    private SQLiteDatabase db;

    public DBVehicle(Context ctx){

        this.context = ctx;

        myDBHelper = new DBVehicle.DatabaseHelper(context);
    }

    //open the database connection

    public DBVehicle open(){

        db = myDBHelper.getWritableDatabase();
        return this;


    }

    //close database connection

    public void close(){

        myDBHelper.close();
    }

    public long insertRow(String type ,String task , String date){

        ContentValues cv = new ContentValues();

        cv.put(KEY_TYPE,type);
        cv.put(KEY_TASK,task);
        cv.put(KEY_DATE,date);

        //Insert the data into the database

        return db.insert(TABLE_NAME,null,cv);
    }

    public boolean deleteRow(long rowId){

        String where = KEY_ROWID + "=" +rowId;

        return db.delete(TABLE_NAME,where,null)!=0;

    }

    public void deleteRows(){

        Cursor c= getall();

        long rowId = c.getColumnIndexOrThrow(KEY_ROWID);

        if(c.moveToFirst()){
            do{
                deleteRow(c.getLong((int) rowId));
            }while (c.moveToNext());
        }
        c.close();
    }


    //Return all data in the database.

    String where = null;

    public Cursor getall() {

        db = myDBHelper.getWritableDatabase();
        return db.query(TABLE_NAME, new String[] { KEY_ROWID,KEY_TYPE,KEY_TASK,KEY_DATE
                }, null, null, null,
                null, null);
    }

    // ---retrieves a particular contact---
    public Cursor getContact(String rowId) throws SQLException {
        db = myDBHelper.getWritableDatabase();

        Cursor cursor = db.query(DATABASE_NAME, new String[] { KEY_ROWID, KEY_TYPE, KEY_TASK,
                        KEY_DATE }, KEY_ROWID + "=?",
                new String[] { String.valueOf(rowId) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        return cursor;
    }


    private static class DatabaseHelper extends SQLiteOpenHelper {


        DatabaseHelper(Context context){

            super(context , DATABASE_NAME,null,DATABASE_VERSION);
        }
        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {

            sqLiteDatabase.execSQL(CREATE_TABLE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        }
    }

}
