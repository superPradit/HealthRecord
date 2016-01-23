package appbsru.supergolf.healthrecord;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Section2Hold2Activity extends AppCompatActivity implements View.OnClickListener {

    private Button smbg01Button, smbg02Button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section2_hold2);

        //bindwidget
        bindwidget();

        //buttunController
        buttonController();

    } //Main Method

    private void buttonController() {
        smbg01Button.setOnClickListener(this);
        smbg02Button.setOnClickListener(this);

    } //buttunController

    private void bindwidget() {
        smbg01Button = (Button) findViewById(R.id.smbg1Button);
        smbg02Button = (Button) findViewById(R.id.smbg2Button);
    } //bindwidget

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.smbg1Button:
                startActivity(new Intent(Section2Hold2Activity.this, Section2Sup21Activity.class));
                break;
            case R.id.smbg2Button:
                startActivity(new Intent(Section2Hold2Activity.this, Section2Sup22Activity.class));
                break;
        } //switch
    }
} //Main Class
