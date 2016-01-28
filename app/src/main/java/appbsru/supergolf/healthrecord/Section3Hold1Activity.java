package appbsru.supergolf.healthrecord;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Section3Hold1Activity extends AppCompatActivity implements View.OnClickListener{

    private Button menuFood1Button, menuFood2Button, menuFood3Button, menuFood4Button, menuFood5Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section3_hold1);

        bindwidget();

        menuFoodController();

    } //Main Method

    private void menuFoodController() {

        menuFood1Button.setOnClickListener(this);
        menuFood2Button.setOnClickListener(this);
        menuFood3Button.setOnClickListener(this);
        menuFood4Button.setOnClickListener(this);
        menuFood5Button.setOnClickListener(this);

    } //menuFoodController

    private void bindwidget() {

        menuFood1Button = (Button) findViewById(R.id.fd11Button);
        menuFood2Button = (Button) findViewById(R.id.fd12Button);
        menuFood3Button = (Button) findViewById(R.id.fd13Button);
        menuFood4Button = (Button) findViewById(R.id.fd14Button);
        menuFood5Button = (Button) findViewById(R.id.fd15Button);

    } //bindwidget

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.fd11Button:
                startActivity(new Intent(Section3Hold1Activity.this, Section3Sup11Activity.class));
                break;
            case R.id.fd12Button:
                startActivity(new Intent(Section3Hold1Activity.this, Section3Sup12Activity.class));
                break;
            case R.id.fd13Button:
                startActivity(new Intent(Section3Hold1Activity.this, Section3Sup13Activity.class));
                break;
            case R.id.fd14Button:
                startActivity(new Intent(Section3Hold1Activity.this, Section3Sup14Activity.class));
                break;
            case R.id.fd15Button:
                break;
        } //switch

    } //onClick
} //Main Class
