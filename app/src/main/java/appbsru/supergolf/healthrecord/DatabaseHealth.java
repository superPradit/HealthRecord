package appbsru.supergolf.healthrecord;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by pradit on 21/3/2559.
 */
public class DatabaseHealth extends SQLiteOpenHelper{
    private static final String DB_NAME = "MyHealth";
    private static final int DB_VERSION = 1;

    public static final String TABLE_NAME = "Health";

    public static final String COL_DATE = "date";
    public static final String COL_FOOD = "food";
    public static final String COL_EXERCISE = "exercise";
    public static final String COL_WEIGHT = "weight";
    public static final String COL_HEIGHT = "height";

    public DatabaseHealth(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COL_DATE + " TEXT, " + COL_FOOD + " TEXT, " + COL_EXERCISE + " TEXT, " + COL_WEIGHT + " TEXT, " + COL_HEIGHT + " TEXT);");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (" + COL_DATE + ", " + COL_FOOD + ", " + COL_EXERCISE + " , " + COL_WEIGHT + " , "
                + COL_HEIGHT + ") VALUES ('15/03/2559', '1660', '20','70','168');");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (" + COL_DATE + ", " + COL_FOOD + ", " + COL_EXERCISE + " , " + COL_WEIGHT + " , "
                + COL_HEIGHT + ") VALUES ('16/03/2559', '1615', '25','70','168');");

    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
