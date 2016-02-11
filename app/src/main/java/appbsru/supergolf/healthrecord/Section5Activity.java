package appbsru.supergolf.healthrecord;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Section5Activity extends AppCompatActivity implements View.OnClickListener{

    Button drug1Button, drug2Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section5);

        bindwidget();

        buttonController();

    } //Main Method

    private void buttonController() {

        drug1Button.setOnClickListener(this);
        drug2Button.setOnClickListener(this);

    } //buttonController

    private void bindwidget() {

        drug1Button = (Button) findViewById(R.id.drug1Button);
        drug2Button = (Button) findViewById(R.id.drug2Button);

    } // bindwidget

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.drug1Button:
                startActivity(new Intent(Section5Activity.this, Section5Sup1Activity.class));
                break;
            case R.id.drug2Button:
                startActivity(new Intent(Section5Activity.this, Section5Sup2Activity.class));
                break;
        } //switch
    } //onClick
} // Main Class
