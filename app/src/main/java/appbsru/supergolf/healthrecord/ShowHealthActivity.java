package appbsru.supergolf.healthrecord;

import android.app.AlertDialog;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ShowHealthActivity extends AppCompatActivity {

    DatabaseHealth mHelper;
    SQLiteDatabase mDb;
    Cursor mCursor;
    ListView listHealth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_health);
        mHelper = new DatabaseHealth(this);
        mDb = mHelper.getReadableDatabase();

        mCursor = mDb.rawQuery("SELECT * FROM " + DatabaseHealth.TABLE_NAME, null);

        ArrayList<String> arr_list = new ArrayList<String>();
        mCursor.moveToFirst();
        while(!mCursor.isAfterLast() ) {
            arr_list.add("วันที่ : " + mCursor.getString(mCursor.getColumnIndex(DatabaseHealth.COL_DATE))
                    + "\nพลังงานที่ได้รับ : " + mCursor.getString(mCursor.getColumnIndex(DatabaseHealth.COL_FOOD))
                    + " กิโลแคลอรี/วัน\nเวลาในการออกกำลังกาย : " + mCursor.getString(mCursor.getColumnIndex(DatabaseHealth.COL_EXERCISE))
                    + " นาที/วัน\nน้ำหนัก : " + mCursor.getString(mCursor.getColumnIndex(DatabaseHealth.COL_WEIGHT))
                    + " กิโลกรัม\nส่วนสูง : " + mCursor.getString(mCursor.getColumnIndex(DatabaseHealth.COL_HEIGHT)) + " เซนติเมตร");
            mCursor.moveToNext();
        }

        ArrayAdapter<String> adapterDir = new ArrayAdapter<String>(getApplicationContext(), R.layout.my_list_doctor, arr_list);

        listHealth = (ListView)findViewById(R.id.showHealthListView);
        listHealth.setAdapter(adapterDir);
        listHealth.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                mCursor.moveToPosition(arg2);

                String date = mCursor.getString(mCursor.getColumnIndex(DatabaseHealth.COL_DATE));
                String food = mCursor.getString(mCursor.getColumnIndex(DatabaseHealth.COL_FOOD));
                String exercise = mCursor.getString(mCursor.getColumnIndex(DatabaseHealth.COL_EXERCISE));
                String weight = mCursor.getString(mCursor.getColumnIndex(DatabaseHealth.COL_WEIGHT));
                String height = mCursor.getString(mCursor.getColumnIndex(DatabaseHealth.COL_HEIGHT));

                AlertDialog.Builder builder = new AlertDialog.Builder(ShowHealthActivity.this);
                builder.setTitle("ข้อมูลบันทึกสุขภาพ");
                builder.setMessage("วันที่ : " + date + "\n\nพลังงานที่ได้รับ : " + food + " กิโลแคลอรี/วัน\n\nเวลาในการออกกำลังกาย : " + exercise + " นาที/วัน\n\nน้ำหนัก : " + weight + " กิโลกรัม\n\nส่วนสูง : " + height + " เซนติเมตร");
                builder.setNeutralButton("OK", null);
                builder.show();
            }
        });

    }
    public void onStop() {
        super.onStop();
        mHelper.close();
        mDb.close();
    }
}
