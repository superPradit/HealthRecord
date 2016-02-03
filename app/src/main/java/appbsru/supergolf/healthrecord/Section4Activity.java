package appbsru.supergolf.healthrecord;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Section4Activity extends AppCompatActivity implements View.OnClickListener{

    private ImageButton showDoctorImageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section4);

        bindwidget();

        doctorController();

    }

    private void doctorController() {
        showDoctorImageButton.setOnClickListener(this);
    }

    private void bindwidget() {
        showDoctorImageButton = (ImageButton) findViewById(R.id.showDTImageButton);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.showDTImageButton:
                startActivity(new Intent(Section4Activity.this, Section4Sup1Activity.class));
                break;
        }
    }
}
