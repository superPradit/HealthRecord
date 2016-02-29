package appbsru.supergolf.healthrecord;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateDoctorActivity extends AppCompatActivity {

    DatabaseDoctor mHelper;
    SQLiteDatabase mDb;
    Cursor mCursor;
    String name, hospital, suggest, phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_doctor);

        name = getIntent().getExtras().getString("NAME");
        hospital = getIntent().getExtras().getString("HOSPITAL");
        suggest = getIntent().getExtras().getString("SUGGEST");
        phone = getIntent().getExtras().getString("PHONE");

        mHelper = new DatabaseDoctor(this);
        mDb = mHelper.getWritableDatabase();

        mCursor = mDb.rawQuery("SELECT * FROM " + DatabaseDoctor.TABLE_NAME
                + " WHERE " + DatabaseDoctor.COL_NAME + "='" + name + "'"
                + " AND " + DatabaseDoctor.COL_HOSPITAL  + "='" + hospital + "'"
                + " AND " + DatabaseDoctor.COL_SUGGEST  + "='" + suggest + "'"
                + " AND " + DatabaseDoctor.COL_PHONE + "='" + phone + "'", null);

        final EditText editName = (EditText)findViewById(R.id.editName);
        editName.setText(name);
        final EditText editHospital = (EditText)findViewById(R.id.editHospital);
        editHospital.setText(hospital);
        final EditText editSuggest = (EditText)findViewById(R.id.editSuggest);
        editSuggest.setText(suggest);
        final EditText editPhone = (EditText)findViewById(R.id.editPhone);
        editPhone.setText(phone);

        Button buttonUpdate = (Button)findViewById(R.id.buttonUpdate);
        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String nameUpdate = editName.getText().toString();
                String hospitalUpdate = editHospital.getText().toString();
                String suggestUpdate = editSuggest.getText().toString();
                String phoneUpdate = editPhone.getText().toString();

                if(name.length() != 0 && hospital.length() != 0 && suggest.length() != 0 && phone.length() != 0 ) {
                    mDb.execSQL("UPDATE " + DatabaseDoctor.TABLE_NAME  + " SET "
                            + DatabaseDoctor.COL_NAME + "='" + nameUpdate + "', "
                            + DatabaseDoctor.COL_HOSPITAL + "='" + hospitalUpdate + "', "
                            + DatabaseDoctor.COL_SUGGEST + "='" + suggestUpdate + "', "
                            + DatabaseDoctor.COL_PHONE + "='" + phoneUpdate
                            + "' WHERE " + DatabaseDoctor.COL_NAME + "='" + name + "'"
                            + " AND " + DatabaseDoctor.COL_HOSPITAL + "='" + hospital + "'"
                            + " AND " + DatabaseDoctor.COL_SUGGEST + "='" + suggest + "'"
                            + " AND " + DatabaseDoctor.COL_PHONE + "='" + phone + "';");

                    Toast.makeText(getApplicationContext(), "แก้ไขข้อมูลแพทย์เรียบร้อยแล้ว"
                            , Toast.LENGTH_SHORT).show();

                    finish();

                } else {
                    Toast.makeText(getApplicationContext(), "กรุณาใส่ข้อมูลแพทย์ให้ครบทุกช่อง"
                            , Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button buttonNameClear = (Button)findViewById(R.id.buttonNameClear);
        buttonNameClear.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                editName.setText("");
            }
        });

        Button buttonHospitalClear = (Button)findViewById(R.id.buttonHospitalClear);
        buttonHospitalClear.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                editHospital.setText("");
            }
        });

        Button buttonSuggestClear = (Button)findViewById(R.id.buttonSuggestClear);
        buttonSuggestClear.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                editSuggest.setText("");
            }
        });

        Button buttonPhoneClear = (Button)findViewById(R.id.buttonPhoneClear);
        buttonPhoneClear.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                editPhone.setText("");
            }
        });

    } //Main Method

    public void onStop() {
        super.onStop();
        mHelper.close();
        mDb.close();
    } //onStop

} //Main Class
