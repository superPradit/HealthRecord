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

public class EditDoctorActivity extends AppCompatActivity {

    DatabaseDoctor mHelper;
    SQLiteDatabase mDb;
    Cursor mCursor;
    ListView listDoctor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_doctor);

    } //Main Method

    public void onResume() {
        super.onResume();

        mHelper = new DatabaseDoctor(this);
        mDb = mHelper.getWritableDatabase();

        mCursor = mDb.rawQuery("SELECT * FROM " + DatabaseDoctor.TABLE_NAME, null);

        listDoctor = (ListView)findViewById(R.id.listDoctor);
        listDoctor.setAdapter(updateListView());
        listDoctor.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                mCursor.moveToPosition(arg2);

                String name = mCursor.getString(mCursor.getColumnIndex(DatabaseDoctor.COL_NAME));
                String hospital = mCursor.getString(mCursor.getColumnIndex(DatabaseDoctor.COL_HOSPITAL));
                String suggest = mCursor.getString(mCursor.getColumnIndex(DatabaseDoctor.COL_SUGGEST));
                String phone = mCursor.getString(mCursor.getColumnIndex(DatabaseDoctor.COL_PHONE));

                Intent intent = new Intent(getApplicationContext(), UpdateDoctorActivity.class);
                intent.putExtra("NAME", name);
                intent.putExtra("HOSPITAL", hospital);
                intent.putExtra("SUGGEST", suggest);
                intent.putExtra("PHONE", phone);
                startActivity(intent);
            }
        });

        listDoctor.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                mCursor.moveToPosition(arg2);

                AlertDialog.Builder builder = new AlertDialog.Builder(EditDoctorActivity.this);
                builder.setTitle("ลบข้อมูลนักเรียน");
                builder.setMessage("คุณต้องการลบข้อมูลนักเรียนคนนี้ใช่หรือไม่?");
                builder.setPositiveButton("ใช่", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        String name = mCursor.getString(mCursor.getColumnIndex(DatabaseDoctor.COL_NAME));
                        String hospital = mCursor.getString(mCursor.getColumnIndex(DatabaseDoctor.COL_HOSPITAL));
                        String suggest = mCursor.getString(mCursor.getColumnIndex(DatabaseDoctor.COL_SUGGEST));
                        String phone = mCursor.getString(mCursor.getColumnIndex(DatabaseDoctor.COL_PHONE));

                        mDb.execSQL("DELETE FROM " + DatabaseDoctor.TABLE_NAME
                                + " WHERE " + DatabaseDoctor.COL_NAME + "='" + name + "'"
                                + " AND " + DatabaseDoctor.COL_HOSPITAL + "='" + hospital + "'"
                                + " AND " + DatabaseDoctor.COL_SUGGEST + "='" + suggest + "'"
                                + " AND " + DatabaseDoctor.COL_PHONE + "='" + phone + "';");

                        mCursor.requery();

                        listDoctor.setAdapter(updateListView());

                        Toast.makeText(getApplicationContext(),"ลบข้อมูลนักเรียนเรียบร้อย"
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
            arr_list.add("ชื่อ : " + mCursor.getString(mCursor.getColumnIndex(DatabaseDoctor.COL_NAME)) + "\n"
                    + "สถานที่ทำงาน : " + mCursor.getString(mCursor.getColumnIndex(DatabaseDoctor.COL_HOSPITAL)) + "\n"
                    + "ความชำนาญ : " + mCursor.getString(mCursor.getColumnIndex(DatabaseDoctor.COL_SUGGEST)) + "\n"
                    + "เบอร์ติดต่อ : " + mCursor.getString(mCursor.getColumnIndex(DatabaseDoctor.COL_PHONE)));
            mCursor.moveToNext();
        }

        ArrayAdapter<String> adapterDir = new ArrayAdapter<String>(getApplicationContext()
                , R.layout.my_list_doctor, arr_list);
        return adapterDir;
    }

} //Main Class
