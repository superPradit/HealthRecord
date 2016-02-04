package appbsru.supergolf.healthrecord;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ShowDoctorActivity extends Activity {

    DatabaseDoctor mHelper;
    SQLiteDatabase mDb;
    Cursor mCursor;
    ListView listDoctor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_doctor);

        mHelper = new DatabaseDoctor(this);
        mDb = mHelper.getReadableDatabase();

        mCursor = mDb.rawQuery("SELECT * FROM " + DatabaseDoctor.TABLE_NAME, null);

        ArrayList<String> arr_list = new ArrayList<String>();
        mCursor.moveToFirst();
        while(!mCursor.isAfterLast() ) {
            arr_list.add("ชื่อ : " + mCursor.getString(mCursor.getColumnIndex(DatabaseDoctor.COL_NAME))
                    + "\nสถานที่ทำงาน : " + mCursor.getString(mCursor.getColumnIndex(DatabaseDoctor.COL_HOSPITAL))
                    + "\nความชำนาญ : " + mCursor.getString(mCursor.getColumnIndex(DatabaseDoctor.COL_SUGGEST))
                    + "\nเบอร์ติดต่อ : " + mCursor.getString(mCursor.getColumnIndex(DatabaseDoctor.COL_PHONE)));
            mCursor.moveToNext();
        }

        ArrayAdapter<String> adapterDir = new ArrayAdapter<String>(getApplicationContext(), R.layout.my_list_doctor, arr_list);

        listDoctor = (ListView)findViewById(R.id.showDoctorListView);
        listDoctor.setAdapter(adapterDir);
        listDoctor.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                mCursor.moveToPosition(arg2);

                String name = mCursor.getString(mCursor.getColumnIndex(DatabaseDoctor.COL_NAME));
                String hospital = mCursor.getString(mCursor.getColumnIndex(DatabaseDoctor.COL_HOSPITAL));
                String suggest = mCursor.getString(mCursor.getColumnIndex(DatabaseDoctor.COL_SUGGEST));
                String phone = mCursor.getString(mCursor.getColumnIndex(DatabaseDoctor.COL_PHONE));

                AlertDialog.Builder builder = new AlertDialog.Builder(ShowDoctorActivity.this);
                builder.setTitle("ข้อมูลนักเรียน");
                builder.setMessage("ชื่อ : " + name + "\n\nสถานที่ทำงาน : " + hospital + "\n\nความชำนาญ : " + suggest + "\n\nเบอร์ติดต่อ : " + phone);
                builder.setNeutralButton("OK", null);
                builder.show();
            }
        });


        } //Main Method

    public void onStop() {
        super.onStop();
        mHelper.close();
        mDb.close();
    }

} //Main Class
