package appbsru.supergolf.healthrecord;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class Section2Activity extends AppCompatActivity implements View.OnClickListener {
    private Button practice1Button, practice2Button, practice3Button,
            practice4Button, practice5Button, practice6Button,
            practice7Button, practice8Button, practice9Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section2);

        //bindwidget
        bindwidget();

        //buttonControlle
        buttonController();

    } //Main method

    private void buttonController() {
        practice1Button.setOnClickListener(this);
        practice2Button.setOnClickListener(this);
        practice3Button.setOnClickListener(this);
        practice4Button.setOnClickListener(this);
        practice5Button.setOnClickListener(this);
        practice6Button.setOnClickListener(this);
        practice7Button.setOnClickListener(this);
        practice8Button.setOnClickListener(this);
        practice9Button.setOnClickListener(this);

    } //buttonControlle

    private void bindwidget() {

        practice1Button = (Button) findViewById(R.id.perform1Button);
        practice2Button = (Button) findViewById(R.id.perform2Button);
        practice3Button = (Button) findViewById(R.id.perform3Button);
        practice4Button = (Button) findViewById(R.id.perform4Button);
        practice5Button = (Button) findViewById(R.id.perform5Button);
        practice6Button = (Button) findViewById(R.id.perform6Button);
        practice7Button = (Button) findViewById(R.id.perform7Button);
        practice8Button = (Button) findViewById(R.id.perform8Button);
        practice9Button = (Button) findViewById(R.id.perform9Button);

    } //bindwidget


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.perform1Button:
                startActivity(new Intent(Section2Activity.this, Section2HoldActivity.class));
                break;
            case R.id.perform2Button:
                startActivity(new Intent(Section2Activity.this, Section2Hold2Activity.class));
                break;
            case R.id.perform3Button:
                startActivity(new Intent(Section2Activity.this, Section2Hold3Activity.class));
                break;
            case R.id.perform4Button:
                startActivity(new Intent(Section2Activity.this, Section2Sup41Activity.class));
                break;
            case R.id.perform5Button:
                startActivity(new Intent(Section2Activity.this, Section2Sup51Activity.class));
                break;
            case R.id.perform6Button:
                startActivity(new Intent(Section2Activity.this, Section2Hold4Activity.class));
                break;
            case R.id.perform7Button:
                startActivity(new Intent(Section2Activity.this, Section2Hold5Activity.class));
                break;
            case R.id.perform8Button:
                startActivity(new Intent(Section2Activity.this, Section2Hold6Activity.class));
                break;
            case R.id.perform9Button:
                startActivity(new Intent(Section2Activity.this, Section2Hold7Activity.class));
                break;
        }
    }
} //Main Class
