package appbsru.supergolf.healthrecord;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class Section1Activity extends AppCompatActivity {

    //explicit
    private Spinner ageSpinner;
    private RadioGroup sexRadioGroup, pressureRadioGroup, diabetesRadioGroup;
    private RadioButton sexMaleRadioButton, sexFemaleRadioButton,
            pressureNoHaveRadioButton, pressureHaveRadioButton,
            diabetesNoHaveRadioButton, diabetesHaveRadioButton;
    private EditText heightEditText, weightEditText, widthEditText;
    private String sexString, pressureString, diabetesString,
            heightString, weightString, widthString;
    private int ageAnInt, sexAnInt = 0, pressureAnInt = 0, diabetesAnInt = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section1);

        //bind widget
        bindwidget();

        //Create Age Spinner
        createAgeSpinner();

        //sex Choose
        sexChoose();

        //pressure Choose
        pressureChoose();

        //diabetesChoose
        diabetesChoose();


    } // Main Method

    private void diabetesChoose() {
        diabetesRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radioButton5:
                        diabetesAnInt = 0;
                        break;
                    case R.id.radioButton6:
                        diabetesAnInt = 4;
                        break;
                }

            }
        });


    }

    private void pressureChoose() {

        pressureRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radioButton3:
                        pressureAnInt = 0;
                        break;
                    case R.id.radioButton4:
                        pressureAnInt = 2;
                        break;
                }
            }
        });

    } // pressureChoose

    private void sexChoose() {

        sexRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radioButton:
                        sexAnInt = 0;
                        break;
                    case R.id.radioButton2:
                        sexAnInt = 2;
                        break;
                }
            }
        });

    }// sexChoose

    public void clickSection11(View view) {

        String tag = "section11";
        Log.d(tag, "ageAnInt = " + ageAnInt);
        Log.d(tag, "sexAnInt = " + sexAnInt);
        Log.d(tag, "pressureAnInt = " + pressureAnInt);
        Log.d(tag, "diabetesAnInt = " + diabetesAnInt);
    } //clickSection11

    private void createAgeSpinner() {

        String[] chioceStrings = new String[3];
        chioceStrings[0] = "0 - 44 ปี";
        chioceStrings[1] = "45 - 49 ปี";
        chioceStrings[2] = "50 ปี ขึ้นไป";

        ArrayAdapter<String> ageAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, chioceStrings);
        ageSpinner.setAdapter(ageAdapter);
        ageSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ageAnInt = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                ageAnInt = 0;
            }
        });

    }// CreateAgeSpinner

    private void bindwidget() {

        ageSpinner = (Spinner) findViewById(R.id.spinner);
        sexRadioGroup = (RadioGroup) findViewById(R.id.ragSex);
        pressureRadioGroup = (RadioGroup) findViewById(R.id.ragPressure);
        diabetesRadioGroup = (RadioGroup) findViewById(R.id.ragDiabetes);
        sexMaleRadioButton = (RadioButton) findViewById(R.id.radioButton);
        sexFemaleRadioButton = (RadioButton) findViewById(R.id.radioButton2);
        pressureNoHaveRadioButton = (RadioButton) findViewById(R.id.radioButton3);
        pressureHaveRadioButton = (RadioButton) findViewById(R.id.radioButton4);
        diabetesNoHaveRadioButton = (RadioButton) findViewById(R.id.radioButton5);
        diabetesHaveRadioButton = (RadioButton) findViewById(R.id.radioButton6);

    }

}  //Main Class
