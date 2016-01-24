package appbsru.supergolf.healthrecord;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Section2Sup82Activity extends AppCompatActivity implements View.OnClickListener{

    private Button koma1Button, koma2Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section2_sup82);

        //bindwidget
        bindwidget();

        //komaController
        komaController();

    } //Main Method

    private void komaController() {

        koma1Button.setOnClickListener(this);
        koma2Button.setOnClickListener(this);

    } //komaController

    private void bindwidget() {

        koma1Button = (Button) findViewById(R.id.kts21Button);
        koma2Button = (Button) findViewById(R.id.kts22Button);

    } //bindwidget

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.kts21Button:
                startActivity(new Intent(Section2Sup82Activity.this, Section2Sup821Activity.class));
                break;
            case R.id.kts22Button:
                startActivity(new Intent(Section2Sup82Activity.this, Section2Sup822Activity.class));
                break;
        } //switch
    } //onClick

} //Main Class
