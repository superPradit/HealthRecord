package appbsru.supergolf.healthrecord;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Section4Activity extends AppCompatActivity implements View.OnClickListener{

    private ImageButton showDoctorImageButton, addDoctorImageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section4);

        bindwidget();

        doctorController();

        DatabaseDoctor mHelper = new DatabaseDoctor(this);
        SQLiteDatabase mDb = mHelper.getWritableDatabase();
        mHelper.close();
        mDb.close();

    }

    private void doctorController() {

        showDoctorImageButton.setOnClickListener(this);
        addDoctorImageButton.setOnClickListener(this);
    }

    private void bindwidget() {
        showDoctorImageButton = (ImageButton) findViewById(R.id.showDTImageButton);
        addDoctorImageButton = (ImageButton) findViewById(R.id.addDTImageButton);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.showDTImageButton:
                startActivity(new Intent(Section4Activity.this, ShowDoctorActivity.class));
                break;
            case R.id.addDTImageButton:
                startActivity(new Intent(Section4Activity.this, AddDoctorActivity.class));
                break;
        }
    }
}
