package appbsru.supergolf.healthrecord;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Section2Sup83Activity extends AppCompatActivity implements View.OnClickListener{

    private Button sugarlow1Button, sugarlow2Button, sugarlow3Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section2_sup83);

        //bindwidget
        bindwidget();

        //sugarlowController
        sugarlowController();

    } //Main Method

    private void sugarlowController() {

        sugarlow1Button.setOnClickListener(this);
        sugarlow2Button.setOnClickListener(this);
        sugarlow3Button.setOnClickListener(this);

    } //sugarlowController

    private void bindwidget() {

        sugarlow1Button = (Button) findViewById(R.id.kts31Button);
        sugarlow2Button = (Button) findViewById(R.id.kts32Button);
        sugarlow3Button = (Button) findViewById(R.id.kts33Button);

    } //bindwidget

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.kts31Button:
                break;
            case R.id.kts32Button:
                break;
            case R.id.kts33Button:
                break;
        }
    }
} //Main Class
