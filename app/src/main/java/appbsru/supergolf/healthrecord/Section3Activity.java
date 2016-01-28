package appbsru.supergolf.healthrecord;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Section3Activity extends AppCompatActivity implements View.OnClickListener{

    private Button nutrition1Button, nutrition2Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section3);

        bindwidget();

        nutritionController();

    } //Main Method

    private void nutritionController() {

        nutrition1Button.setOnClickListener(this);
        nutrition2Button.setOnClickListener(this);

    }

    private void bindwidget() {

        nutrition1Button = (Button) findViewById(R.id.fd1Button);
        nutrition2Button = (Button) findViewById(R.id.fd2Button);

    } //bindwidget

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.fd1Button:
                break;
            case R.id.fd2Button:
                break;
        }

    }
} //Main Class
