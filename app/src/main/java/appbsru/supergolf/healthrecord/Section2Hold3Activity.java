package appbsru.supergolf.healthrecord;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Section2Hold3Activity extends AppCompatActivity implements View.OnClickListener{

    private Button urinalysis1Button, urinalysis2Button, urinalysis3Button, urinalysis4Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section2_hold3);

        //bindwidget
        bindwidget();

        //uController
        uController();

    } //Main Method

    private void uController() {

        urinalysis1Button.setOnClickListener(this);
        urinalysis2Button.setOnClickListener(this);
        urinalysis3Button.setOnClickListener(this);
        urinalysis4Button.setOnClickListener(this);

    } //uController

    private void bindwidget() {

        urinalysis1Button = (Button) findViewById(R.id.u1Button);
        urinalysis2Button = (Button) findViewById(R.id.u2Button);
        urinalysis3Button = (Button) findViewById(R.id.u3Button);
        urinalysis4Button = (Button) findViewById(R.id.u4Button);

    } //bindwidget

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.u1Button:
                startActivity(new Intent(Section2Hold3Activity.this, Section2Sup31Activity.class));
                break;
            case R.id.u2Button:
                startActivity(new Intent(Section2Hold3Activity.this, Section2Sup32Activity.class));
                break;
            case R.id.u3Button:
                startActivity(new Intent(Section2Hold3Activity.this, Section2Sup33Activity.class));
                break;
            case R.id.u4Button:
                startActivity(new Intent(Section2Hold3Activity.this, Section2Sup34Activity.class));
                break;
        }
    }
} //Main Class
