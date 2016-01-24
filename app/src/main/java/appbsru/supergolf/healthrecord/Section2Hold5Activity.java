package appbsru.supergolf.healthrecord;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Section2Hold5Activity extends AppCompatActivity implements View.OnClickListener{

    private Button pregnant1Button, pregnant2Button, pregnant3Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section2_hold5);

        //bindwidget
        bindwidget();

        //pregnantController
        pregnantController();

    } //Main Method

    private void pregnantController() {

        pregnant1Button.setOnClickListener(this);
        pregnant2Button.setOnClickListener(this);
        pregnant3Button.setOnClickListener(this);

    } //pregnantController

    private void bindwidget() {

        pregnant1Button = (Button) findViewById(R.id.pn1Button);
        pregnant2Button = (Button) findViewById(R.id.pn2Button);
        pregnant3Button = (Button) findViewById(R.id.pn3Button);

    } //bindwidget

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.pn1Button:
                startActivity(new Intent(Section2Hold5Activity.this, Section2Sup71Activity.class));
                break;
            case R.id.pn2Button:
                startActivity(new Intent(Section2Hold5Activity.this, Section2Sup72Activity.class));
                break;
            case R.id.pn3Button:
                startActivity(new Intent(Section2Hold5Activity.this, Section2Sup73Activity.class));
                break;
        }
    }
} //Main Class