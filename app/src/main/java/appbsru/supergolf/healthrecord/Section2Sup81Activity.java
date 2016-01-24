package appbsru.supergolf.healthrecord;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Section2Sup81Activity extends AppCompatActivity implements View.OnClickListener{

    private Button ketosis1Button, ketosis2Button, ketosis3Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section2_sup81);

        //bindwidget
        binwidget();

        //ketosisController
        ketosisController();

    } //Main Method

    private void ketosisController() {

        ketosis1Button.setOnClickListener(this);
        ketosis2Button.setOnClickListener(this);
        ketosis3Button.setOnClickListener(this);

    } //ketosisController

    private void binwidget() {

        ketosis1Button = (Button) findViewById(R.id.kts1Button);
        ketosis2Button = (Button) findViewById(R.id.kts2Button);
        ketosis3Button = (Button) findViewById(R.id.kts3Button);

    } //bindwidget

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.kts1Button:
                startActivity(new Intent(Section2Sup81Activity.this, Section2Sup811Activity.class));
                break;
            case R.id.kts2Button:
                break;
            case R.id.kts3Button:
                break;
        } //switch
    }
} //Main Class
