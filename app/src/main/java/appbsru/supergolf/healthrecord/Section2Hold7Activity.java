package appbsru.supergolf.healthrecord;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Section2Hold7Activity extends AppCompatActivity implements View.OnClickListener{

    private Button complication1Button, complication2Button, complication3Button,
            complication4Button, complication5Button, complication6Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section2_hold7);

        //bindwidget
        bindwidget();

        //complicationController
        complicationController();

    } //Main Method

    private void complicationController() {

        complication1Button.setOnClickListener(this);
        complication2Button.setOnClickListener(this);
        complication3Button.setOnClickListener(this);
        complication4Button.setOnClickListener(this);
        complication5Button.setOnClickListener(this);
        complication6Button.setOnClickListener(this);

    } //complicationController

    private void bindwidget() {

        complication1Button = (Button) findViewById(R.id.cp1Button);
        complication2Button = (Button) findViewById(R.id.cp2Button);
        complication3Button = (Button) findViewById(R.id.cp3Button);
        complication4Button = (Button) findViewById(R.id.cp4Button);
        complication5Button = (Button) findViewById(R.id.cp5Button);
        complication6Button = (Button) findViewById(R.id.cp6Button);

    } //bindwidget

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.cp1Button:
                startActivity(new Intent(Section2Hold7Activity.this, Section2Sup91Activity.class));
                break;
            case R.id.cp2Button:
                startActivity(new Intent(Section2Hold7Activity.this, Section2Sup92Activity.class));
                break;
            case R.id.cp3Button:
                startActivity(new Intent(Section2Hold7Activity.this, Section2Sup93Activity.class));
                break;
            case R.id.cp4Button:
                startActivity(new Intent(Section2Hold7Activity.this, Section2Sup94Activity.class));
                break;
            case R.id.cp5Button:
                startActivity(new Intent(Section2Hold7Activity.this, Section2Sup95Activity.class));
                break;
            case R.id.cp6Button:
                break;
        } //switch

    } //on Click
} //Main Class
