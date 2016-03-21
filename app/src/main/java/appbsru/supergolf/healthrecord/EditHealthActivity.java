package appbsru.supergolf.healthrecord;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class EditHealthActivity extends AppCompatActivity {

    DatabaseHealth mHelper;
    SQLiteDatabase mDb;
    Cursor mCursor;
    ListView listHealth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_health);
    }

    public void onResume() {
        super.onResume();

        mHelper = new DatabaseHealth(this);
        mDb = mHelper.getWritableDatabase();

        mCursor = mDb.rawQuery("SELECT * FROM " + DatabaseHealth.TABLE_NAME, null);

        listHealth = (ListView)findViewById(R.id.listHealth);
        listHealth.setAdapter(updateListView());
        listHealth.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                mCursor.moveToPosition(arg2);

                String date = mCursor.getString(mCursor.getColumnIndex(DatabaseHealth.COL_DATE));
                String food = mCursor.getString(mCursor.getColumnIndex(DatabaseHealth.COL_FOOD));
                String exercise = mCursor.getString(mCursor.getColumnIndex(DatabaseHealth.COL_EXERCISE));
                String weight = mCursor.getString(mCursor.getColumnIndex(DatabaseHealth.COL_WEIGHT));
                String height = mCursor.getString(mCursor.getColumnIndex(DatabaseHealth.COL_HEIGHT));

                Intent intent = new Intent(getApplicationContext(), UpdateHealthActivity.class);
                intent.putExtra("DATE", date);
                intent.putExtra("FOOD", food);
                intent.putExtra("EXERCISE", exercise);
                intent.putExtra("WEIGHT", weight);
                intent.putExtra("HEIGHT", height);
                startActivity(intent);
            }
        });

        listHealth.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                mCursor.moveToPosition(arg2);

                AlertDialog.Builder builder = new AlertDialog.Builder(EditHealthActivity.this);
                builder.setTitle("ลบบันทึกสุขภาพ");
                builder.setMessage("คุณต้องการลบบันทึกสุขภาพนี้ใช่หรือไม่?");
                builder.setPositiveButton("ใช่", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        String date = mCursor.getString(mCursor.getColumnIndex(DatabaseHealth.COL_DATE));
                        String food = mCursor.getString(mCursor.getColumnIndex(DatabaseHealth.COL_FOOD));
                        String exercise = mCursor.getString(mCursor.getColumnIndex(DatabaseHealth.COL_EXERCISE));
                        String weight = mCursor.getString(mCursor.getColumnIndex(DatabaseHealth.COL_WEIGHT));
                        String height = mCursor.getString(mCursor.getColumnIndex(DatabaseHealth.COL_HEIGHT));

                        mDb.execSQL("DELETE FROM " + DatabaseHealth.TABLE_NAME
                                + " WHERE " + DatabaseHealth.COL_DATE + "='" + date + "'"
                                + " AND " + DatabaseHealth.COL_FOOD + "='" + food + "'"
                                + " AND " + DatabaseHealth.COL_EXERCISE + "='" + exercise + "'"
                                + " AND " + DatabaseHealth.COL_WEIGHT + "='" + weight + "'"
                                + " AND " + DatabaseHealth.COL_HEIGHT + "='" + height + "';");

                        mCursor.requery();

                        listHealth.setAdapter(updateListView());

                        Toast.makeText(getApplicationContext(),"ลบบันทึกสุขภาพเรียบร้อย"
                                , Toast.LENGTH_SHORT).show();
                    }
                });

                builder.setNegativeButton("ไม่", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                builder.show();

                return true;
            }
        });

    } //onResume

    public void onStop() {
        super.onStop();
        mHelper.close();
        mDb.close();
    }

    public ArrayAdapter<String> updateListView() {
        ArrayList<String> arr_list = new ArrayList<String>();
        mCursor.moveToFirst();
        while(!mCursor.isAfterLast()){
            arr_list.add("วันที่ : " + mCursor.getString(mCursor.getColumnIndex(DatabaseHealth.COL_DATE)) + "\n"
                    + "พลังงานที่ได้รับ : " + mCursor.getString(mCursor.getColumnIndex(DatabaseHealth.COL_FOOD)) + " กิโลแคลอรี/วัน\n"
                    + "เวลาในการออกกำลังกาย : " + mCursor.getString(mCursor.getColumnIndex(DatabaseHealth.COL_EXERCISE)) + " นาที/วัน\n"
                    + "น้ำหนัก : " + mCursor.getString(mCursor.getColumnIndex(DatabaseHealth.COL_WEIGHT)) + " กิโลกรัม\n"
                    + "ส่วนสูง : " + mCursor.getString(mCursor.getColumnIndex(DatabaseHealth.COL_HEIGHT)) + " เซนติเมตร");
            mCursor.moveToNext();
        }

        ArrayAdapter<String> adapterDir = new ArrayAdapter<String>(getApplicationContext()
                , R.layout.my_list_health, arr_list);
        return adapterDir;
    }

}
