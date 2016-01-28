package appbsru.supergolf.healthrecord;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by pradit on 26/1/2559.
 */
public class myOpenHelper extends SQLiteOpenHelper{

    //explicit
    public static final String DATABASE_NAME = "Health.db";
    private static final int DATABASE_VERSION = 1;
    private static final String CREATE_MEET_TABLE = "Create table meetTable (" +
            "_id inter primary key," +
            "Date text" +
            "Month text" +
            "Year Text" +
            "Doctor text" +
            "Remark text):";


    public myOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    } //Contructor

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
