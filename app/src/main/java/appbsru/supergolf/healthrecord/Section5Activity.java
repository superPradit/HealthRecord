package appbsru.supergolf.healthrecord;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Section5Activity extends AppCompatActivity {

    //explicit
    private TextView showTimeTextView;
    private Button setUpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section5);

        //bindwidget
        bindwidget();

        buttonController();


    } //Main Method

    private void buttonController() {

        setUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



            } //event
        });

    }

    private void bindwidget() {

        showTimeTextView = (TextView) findViewById(R.id.textView23);
        setUpButton = (Button) findViewById(R.id.button3);

    }

} //Main Class
