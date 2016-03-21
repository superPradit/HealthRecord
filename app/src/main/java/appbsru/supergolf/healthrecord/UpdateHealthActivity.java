package appbsru.supergolf.healthrecord;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateHealthActivity extends AppCompatActivity {

    DatabaseHealth mHelper;
    SQLiteDatabase mDb;
    Cursor mCursor;
    String date, food, exercise, weight, height;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_health);

        date = getIntent().getExtras().getString("DATE");
        food = getIntent().getExtras().getString("FOOD");
        exercise = getIntent().getExtras().getString("EXERCISE");
        weight = getIntent().getExtras().getString("WEIGHT");
        height = getIntent().getExtras().getString("HEIGHT");

        mHelper = new DatabaseHealth(this);
        mDb = mHelper.getWritableDatabase();

        mCursor = mDb.rawQuery("SELECT * FROM " + DatabaseHealth.TABLE_NAME
                + " WHERE " + DatabaseHealth.COL_DATE + "='" + date + "'"
                + " AND " + DatabaseHealth.COL_FOOD  + "='" + food + "'"
                + " AND " + DatabaseHealth.COL_EXERCISE  + "='" + exercise + "'"
                + " AND " + DatabaseHealth.COL_WEIGHT  + "='" + weight + "'"
                + " AND " + DatabaseHealth.COL_HEIGHT + "='" + height + "'", null);

        final EditText editDate = (EditText)findViewById(R.id.editDate);
        editDate.setText(date);
        final EditText editFood = (EditText)findViewById(R.id.editFood);
        editFood.setText(food);
        final EditText editExercise = (EditText)findViewById(R.id.editExercise);
        editExercise.setText(exercise);
        final EditText editWeight = (EditText)findViewById(R.id.editWeight);
        editWeight.setText(weight);
        final EditText editHeight = (EditText)findViewById(R.id.editHeight);
        editHeight.setText(height);

        Button buttonUpdate = (Button)findViewById(R.id.buttonUpdate);
        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String dateUpdate = editDate.getText().toString();
                String foodUpdate = editFood.getText().toString();
                String exerciseUpdate = editExercise.getText().toString();
                String weightUpdate = editWeight.getText().toString();
                String heightUpdate = editHeight.getText().toString();

                if(date.length() != 0 && food.length() != 0 && exercise.length() != 0 && weight.length() != 0 && height.length() != 0 ) {
                    mDb.execSQL("UPDATE " + DatabaseHealth.TABLE_NAME  + " SET "
                            + DatabaseHealth.COL_DATE + "='" + dateUpdate + "', "
                            + DatabaseHealth.COL_FOOD + "='" + foodUpdate + "', "
                            + DatabaseHealth.COL_EXERCISE + "='" + exerciseUpdate + "', "
                            + DatabaseHealth.COL_WEIGHT + "='" + weightUpdate + "', "
                            + DatabaseHealth.COL_HEIGHT + "='" + heightUpdate
                            + "' WHERE " + DatabaseHealth.COL_DATE + "='" + date + "'"
                            + " AND " + DatabaseHealth.COL_FOOD + "='" + food + "'"
                            + " AND " + DatabaseHealth.COL_EXERCISE + "='" + exercise + "'"
                            + " AND " + DatabaseHealth.COL_WEIGHT + "='" + weight + "'"
                            + " AND " + DatabaseHealth.COL_HEIGHT + "='" + height + "';");

                    Toast.makeText(getApplicationContext(), "แก้ไขบันทึกสุขภาพเรียบร้อยแล้ว"
                            , Toast.LENGTH_SHORT).show();

                    finish();

                } else {
                    Toast.makeText(getApplicationContext(), "กรุณาใส่ข้อมูลบันทึกสุขภาพให้ครบทุกช่อง"
                            , Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button buttonDate = (Button)findViewById(R.id.buttonDate);
        buttonDate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                editDate.setText("");
            }
        });

        Button buttonFood = (Button)findViewById(R.id.buttonFood);
        buttonFood.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                editFood.setText("");
            }
        });

        Button buttonExercise = (Button)findViewById(R.id.buttonExercise);
        buttonExercise.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                editExercise.setText("");
            }
        });

        Button buttonWeight = (Button)findViewById(R.id.buttonWeight);
        buttonWeight.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                editWeight.setText("");
            }
        });
        Button buttonHeight = (Button)findViewById(R.id.buttonHeight);
        buttonHeight.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                editHeight.setText("");
            }
        });

    }
    public void onStop() {
        super.onStop();
        mHelper.close();
        mDb.close();
    } //onStop
}
