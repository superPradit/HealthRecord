package appbsru.supergolf.healthrecord;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Section2HoldActivity extends AppCompatActivity implements View.OnClickListener{

    //Explicit
    private Button exert1Button, exert2Button, exert3Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section2_hold);

        //bindwidget
        bindwidget();

        //buttonController
        buttonController();

    } //Main Method

    private void buttonController() {

        exert1Button.setOnClickListener(this);
        exert2Button.setOnClickListener(this);
        exert3Button.setOnClickListener(this);

    } //buttonController

    private void bindwidget() {

        exert1Button = (Button) findViewById(R.id.exercise1Button);
        exert2Button = (Button) findViewById(R.id.exercise2Button);
        exert3Button = (Button) findViewById(R.id.exercise3Button);

    } //bindwidget

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.exercise1Button:
                startActivity(new Intent(Section2HoldActivity.this, Section2Sup11Activity.class));
                break;
            case R.id.exercise2Button:
                startActivity(new Intent(Section2HoldActivity.this, Section2Sup12Activity.class));
                break;
            case R.id.exercise3Button:
                startActivity(new Intent(Section2HoldActivity.this, Section2Sup13Activity.class));
                break;
        }
    }
} //Main Class
