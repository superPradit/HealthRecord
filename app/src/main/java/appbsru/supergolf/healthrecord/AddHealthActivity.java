package appbsru.supergolf.healthrecord;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddHealthActivity extends AppCompatActivity {

    DatabaseHealth mHelper;
    SQLiteDatabase mDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_health);

        mHelper = new DatabaseHealth(this);
        mDb = mHelper.getWritableDatabase();

        final EditText editDate = (EditText)findViewById(R.id.editDate);
        final EditText editFood = (EditText)findViewById(R.id.editFood);
        final EditText editExercise = (EditText)findViewById(R.id.editExercise);
        final EditText editWeight = (EditText) findViewById(R.id.editWeight);
        final EditText editHeight = (EditText) findViewById(R.id.editHeight);

        Button buttonAdd = (Button)findViewById(R.id.buttonAdd);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String date = editDate.getText().toString();
                String food = editFood.getText().toString();
                String exercise = editExercise.getText().toString();
                String weight = editWeight.getText().toString();
                String height = editHeight.getText().toString();

                if(date.length() != 0 && food.length() != 0 && exercise.length() != 0 && weight.length() != 0 && height.length() != 0 ) {

                    Cursor mCursor = mDb.rawQuery("SELECT * FROM " + DatabaseHealth.TABLE_NAME
                            + " WHERE " + DatabaseHealth.COL_DATE + "='" + date + "'"
                            + " AND " + DatabaseHealth.COL_FOOD + "='" + food + "'"
                            + " AND " + DatabaseHealth.COL_EXERCISE + "='" + exercise + "'"
                            + " AND " + DatabaseHealth.COL_WEIGHT + "='" + weight + "'"
                            + " AND " + DatabaseHealth.COL_HEIGHT + "='" + height + "'", null);

                    if(mCursor.getCount() == 0) {
                        mDb.execSQL("INSERT INTO " + DatabaseHealth.TABLE_NAME + " ("
                                + DatabaseHealth.COL_DATE + ", " + DatabaseHealth.COL_FOOD + ", " + DatabaseHealth.COL_EXERCISE
                                + ", " + DatabaseHealth.COL_WEIGHT + ", " + DatabaseHealth.COL_HEIGHT + ") VALUES ('" + date
                                + "', '" + food + "', '" + exercise + "', '" + weight + "', '" + height + "');");

                        editDate.setText("");
                        editFood.setText("");
                        editExercise.setText("");
                        editWeight.setText("");
                        editHeight.setText("");

                        Toast.makeText(getApplicationContext(), "เพิ่มบันทึกสุขภาพเรียบร้อยแล้ว"
                                , Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "คุณมีบันทึกสุขภาพนี้อยู่แล้ว"
                                , Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "กรุณาใส่ข้อมูลบันทึกสุขภาพให้ครบทุกช่อง"
                            , Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    public void onStop() {
        super.onStop();
        mHelper.close();
        mDb.close();
    }
}
