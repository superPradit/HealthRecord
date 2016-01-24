package appbsru.supergolf.healthrecord;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Section2Hold4Activity extends AppCompatActivity implements View.OnClickListener{

    private Button foot1Button, foot2Button, foot3Button, foot4Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section2_hold4);

        //bindwidget
        bindwidget();

        //footController
        footController();

    } //Main Method

    private void footController() {
        foot1Button.setOnClickListener(this);
        foot2Button.setOnClickListener(this);
        foot3Button.setOnClickListener(this);
        foot4Button.setOnClickListener(this);
    } //footController

    private void bindwidget() {
        foot1Button = (Button) findViewById(R.id.f1Button);
        foot2Button = (Button) findViewById(R.id.f2Button);
        foot3Button = (Button) findViewById(R.id.f3Button);
        foot4Button = (Button) findViewById(R.id.f4Button);

    } //bindwidget

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.f1Button:
                startActivity(new Intent(Section2Hold4Activity.this, Section2Sup61Activity.class));
                break;
            case R.id.f2Button:
                startActivity(new Intent(Section2Hold4Activity.this, Section2Sup62Activity.class));
                break;
            case R.id.f3Button:
                startActivity(new Intent(Section2Hold4Activity.this, Section2Sup63Activity.class));
                break;
            case R.id.f4Button:
                break;
        }
    }
} //Main Class
