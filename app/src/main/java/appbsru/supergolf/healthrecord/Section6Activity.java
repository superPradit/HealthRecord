package appbsru.supergolf.healthrecord;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Section6Activity extends AppCompatActivity implements View.OnClickListener{

    private ImageButton showHealthImageButton, addHealthImageButton, editHealthImageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section6);

        bindwidget();

        HealthController();

        DatabaseHealth mHelper = new DatabaseHealth(this);
        SQLiteDatabase mDb = mHelper.getWritableDatabase();
        mHelper.close();
        mDb.close();
    }

    private void HealthController() {
        showHealthImageButton.setOnClickListener(this);
        addHealthImageButton.setOnClickListener(this);
        editHealthImageButton.setOnClickListener(this);
    }

    private void bindwidget() {
        showHealthImageButton = (ImageButton) findViewById(R.id.showHealthImageButton);
        addHealthImageButton = (ImageButton) findViewById(R.id.addHealthImageButton);
        editHealthImageButton = (ImageButton) findViewById(R.id.editHealthImageButton);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.showHealthImageButton:
                startActivity(new Intent(Section6Activity.this, ShowHealthActivity.class));
                break;
            case R.id.addHealthImageButton:
                startActivity(new Intent(Section6Activity.this, AddHealthActivity.class));
                break;
            case R.id.editHealthImageButton:
                startActivity(new Intent(Section6Activity.this, EditHealthActivity.class));
                break;
        }
    }
}
