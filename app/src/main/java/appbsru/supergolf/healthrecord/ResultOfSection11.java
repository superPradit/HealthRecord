package appbsru.supergolf.healthrecord;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class ResultOfSection11 extends AppCompatActivity {

    //Explicit
    private int ageAnInt, sexAnInt, pressureAnInt, diabetesAnInt, indexMassAnInt, widthAnInt;
    private Double heightADouble, weightADouble, widthADouble, indexMassADouble;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_of_section11);
        //Receive Value Intent
        receiveValueFormIntent();

        indexMassAnInt = findIndexMass();

        //show Log
        showLog();

    }// Main method

    private void showLog() {

        String tag = "Result";
        Log.d(tag, "indexDouble = " + indexMassADouble);
        Log.d(tag, "indexAnInt = " + indexMassAnInt);

    } // showLog

    private int findIndexMass() {

        int intIndex = 0;
        indexMassADouble = weightADouble / Math.pow(heightADouble, 2);
        if (indexMassADouble < 23.0) {
            intIndex = 0;
        } else if (indexMassADouble < 27.5) {
            intIndex = 3;
        } else {
            intIndex = 5;
        }
        return intIndex;
    }

    private void receiveValueFormIntent() {

        ageAnInt = getIntent().getIntExtra("Age", 0);
        sexAnInt = getIntent().getIntExtra("Sex", 0);
        pressureAnInt = getIntent().getIntExtra("Pressue", 0);
        diabetesAnInt = getIntent().getIntExtra("Diabetes", 0);
        heightADouble = getIntent().getDoubleExtra("Height", 0);
        weightADouble = getIntent().getDoubleExtra("Weight", 0);
        widthADouble = getIntent().getDoubleExtra("Width", 0);

    } // receiviValueFormIntent

} //Main Class
