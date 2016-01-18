package appbsru.supergolf.healthrecord;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;

public class MainHoldSection1 extends AppCompatActivity implements View.OnClickListener {

    //explicit
    private ImageView section1ImageView, section2ImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_hold_section1);

        //Bind Widget
        bindwidget();

        //Image Controller
        imageController();
    } //Main method

    private void imageController() {
        section1ImageView.setOnClickListener(this);
        section2ImageView.setOnClickListener(this);
    }

    private void bindwidget() {

        section1ImageView = (ImageView) findViewById(R.id.imageView5);
        section2ImageView = (ImageView) findViewById(R.id.imageView6);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.imageView5:
                startActivity(new Intent(MainHoldSection1.this, Section1Activity.class));
                break;
            case R.id.imageView6:
                startActivity(new Intent(MainHoldSection1.this, Section12Activity.class));
                break;
        }// switch

    } // onClick
} //Main Class
