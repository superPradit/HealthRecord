package appbsru.supergolf.healthrecord;

import android.app.Activity;

import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddDoctorActivity extends Activity {

    DatabaseDoctor mHelper;
    SQLiteDatabase mDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_doctor);

        mHelper = new DatabaseDoctor(this);
        mDb = mHelper.getWritableDatabase();

        final EditText editName = (EditText)findViewById(R.id.editName);
        final EditText editHospital = (EditText)findViewById(R.id.editHospital);
        final EditText editSuggest = (EditText)findViewById(R.id.editSugest);
        final EditText editPhone = (EditText) findViewById(R.id.editPhone);

        Button buttonAdd = (Button)findViewById(R.id.buttonAdd);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String name = editName.getText().toString();
                String hospital = editHospital.getText().toString();
                String suggest = editSuggest.getText().toString();
                String phone = editPhone.getText().toString();

                if(name.length() != 0 && hospital.length() != 0 && suggest.length() != 0 && phone.length() != 0 ) {

                    Cursor mCursor = mDb.rawQuery("SELECT * FROM " + DatabaseDoctor.TABLE_NAME
                            + " WHERE " + DatabaseDoctor.COL_NAME + "='" + name + "'"
                            + " AND " + DatabaseDoctor.COL_HOSPITAL + "='" + hospital + "'"
                            + " AND " + DatabaseDoctor.COL_SUGGEST + "='" + suggest + "'"
                            + " AND " + DatabaseDoctor.COL_PHONE + "='" + phone + "'", null);

                    if(mCursor.getCount() == 0) {
                        mDb.execSQL("INSERT INTO " + DatabaseDoctor.TABLE_NAME + " ("
                                + DatabaseDoctor.COL_NAME + ", " + DatabaseDoctor.COL_HOSPITAL
                                + ", " + DatabaseDoctor.COL_SUGGEST + ", " + DatabaseDoctor.COL_PHONE + ") VALUES ('" + name
                                + "', '" + hospital + "', '" + suggest + "', '" + phone + "');");

                        editName.setText("");
                        editHospital.setText("");
                        editSuggest.setText("");
                        editPhone.setText("");

                        Toast.makeText(getApplicationContext(), "เพิ่มข้อมูลแพทย์เรียบร้อยแล้ว"
                                , Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "คุณมีข้อมูลแพทย์คนนี้อยู่แล้ว"
                                , Toast.LENGTH_SHORT).show();
                    }
                    } else {
                        Toast.makeText(getApplicationContext(), "กรุณาใส่ข้อมูลแพทย์ให้ครบทุกช่อง"
                            , Toast.LENGTH_SHORT).show();
                    }
            }
        });

    } //Main Method

    public void onStop() {
        super.onStop();
        mHelper.close();
        mDb.close();
    }

} //Main Class
