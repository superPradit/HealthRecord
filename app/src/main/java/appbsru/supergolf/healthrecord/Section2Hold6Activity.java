package appbsru.supergolf.healthrecord;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Section2Hold6Activity extends AppCompatActivity implements View.OnClickListener{

    private Button emergency1Button, emergency2Button, emergency3Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section2_hold6);

        //bindwidget
        bindwidget();

        //emergencyController
        emergencyController();

    } //Main Method

    private void emergencyController() {

        emergency1Button.setOnClickListener(this);
        emergency2Button.setOnClickListener(this);
        emergency3Button.setOnClickListener(this);

    } //emergencyController

    private void bindwidget() {

        emergency1Button = (Button) findViewById(R.id.emg1Button);
        emergency2Button = (Button) findViewById(R.id.emg2Button);
        emergency3Button = (Button) findViewById(R.id.emg3Button);

    } //bindwidget

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.emg1Button:
                startActivity(new Intent(Section2Hold6Activity.this, Section2Sup81Activity.class));
                break;
            case R.id.emg2Button:
                startActivity(new Intent(Section2Hold6Activity.this, Section2Sup82Activity.class));
                break;
            case R.id.emg3Button:
                startActivity(new Intent(Section2Hold6Activity.this, Section2Sup83Activity.class));
                break;
        }

    }//on Click

} //Main Class
