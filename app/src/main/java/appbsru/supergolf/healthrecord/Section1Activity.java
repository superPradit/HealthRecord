package appbsru.supergolf.healthrecord;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
    private String ageString, sexString, pressureString, diabetesString,
                    heightString, weightString, widthString;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section1);

        //bind widget
        bindwidget();

    } // Main Method

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
