package appbsru.supergolf.healthrecord;

import android.app.Activity;
import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class Section3Hold2Activity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section3_hold2);

        int[] array_res = getImageArray(R.array.my_image_array,R.drawable.ic_launcher);
        String[] array_string = getStringArray(R.array.my_string_array);

        ListView listView = (ListView)findViewById(R.id.recipefoodListView);
        listView.setAdapter(new CustomListViewAdapter(getApplicationContext(), android.R.id.text1, array_string, array_res));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent;
                switch (position) {
                    case 0:
                        intent = new Intent(getApplicationContext(), Section3Sup21Activity.class);
                        startActivity(intent);
                        break;
                    case 1:
                        intent = new Intent(getApplicationContext(), Section3Sup22Activity.class);
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(getApplicationContext(), Section3Sup23Activity.class);
                        startActivity(intent);
                        break;
                    case 3:
                        intent = new Intent(getApplicationContext(), Section3Sup24Activity.class);
                        startActivity(intent);
                        break;
                    case 4:
                        intent = new Intent(getApplicationContext(), Section3Sup25Activity.class);
                        startActivity(intent);
                        break;
                    case 5:
                        intent = new Intent(getApplicationContext(), Section3Sup26Activity.class);
                        startActivity(intent);
                        break;
                    case 6:
                        intent = new Intent(getApplicationContext(), Section3Sup27Activity.class);
                        startActivity(intent);
                        break;
                    case 7:
                        intent = new Intent(getApplicationContext(), Section3Sup28Activity.class);
                        startActivity(intent);
                        break;
                    case 8:
                        intent = new Intent(getApplicationContext(), Section3Sup29Activity.class);
                        startActivity(intent);
                        break;
                    case 9:
                        intent = new Intent(getApplicationContext(), Section3Sup210Activity.class);
                        startActivity(intent);
                        break;
                }
            }
        });
    }

    private int[] getImageArray(int resID, int defresID) {
        TypedArray my_image_array = getResources().obtainTypedArray(resID);
        int[] array_res = new int[my_image_array.length()];
        for(int i = 0; i < array_res.length ; i++)
            array_res[i] = my_image_array.getResourceId(i, defresID);
        my_image_array.recycle();
        return array_res;
    }

    public String[] getStringArray(int resId) {
        TypedArray my_string_array = getResources().obtainTypedArray(resId);
        String[] array_string = new String[my_string_array.length()];
        for(int i = 0 ; i < array_string.length ; i++)
            array_string[i] = my_string_array.getString(i);
        my_string_array.recycle();
        return array_string;
    }



}
