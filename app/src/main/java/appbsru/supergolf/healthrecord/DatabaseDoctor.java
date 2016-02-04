package appbsru.supergolf.healthrecord;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by pradit on 4/2/2559.
 */
public class DatabaseDoctor extends SQLiteOpenHelper {

    private static final String DB_NAME = "MyDoctor";
    private static final int DB_VERSION = 1;

    public static final String TABLE_NAME = "Doctor";

    public static final String COL_NAME = "name";
    public static final String COL_HOSPITAL = "hospital";
    public static final String COL_SUGGEST = "suggest";
    public static final String COL_PHONE = "phone";

    public DatabaseDoctor(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COL_NAME + " TEXT, " + COL_HOSPITAL + " TEXT, " + COL_SUGGEST + " TEXT, " + COL_PHONE + " TEXT);");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (" + COL_NAME + ", " + COL_HOSPITAL + ", " + COL_SUGGEST + " , "
                + COL_PHONE + ") VALUES ('นพ.สิทธิผล ชินพงศ์'" + ", 'โรงพยาบาลกรุงเทพ', 'อายุรศาสตร์โรคต่อมไร้ท่อและเมตะบอลิสม','027551129');");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
