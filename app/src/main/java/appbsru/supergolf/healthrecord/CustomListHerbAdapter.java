package appbsru.supergolf.healthrecord;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by pradit on 12/2/2559.
 */
public class CustomListHerbAdapter extends ArrayAdapter<String> {
    String[] STR;
    int[] RESOURCE_ID;
    LayoutInflater INFLATER;

    public CustomListHerbAdapter(Context context, int tvResId, String[] objects, int[] resId) {
        super(context, tvResId, objects);
        STR = objects;
        RESOURCE_ID = resId;
        INFLATER = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView = null;
        if(convertView == null) {
            convertView = INFLATER.inflate(R.layout.mylistherb, parent, false);
            imageView = (ImageView)convertView.findViewById(R.id.iconHerb);
        } else {
            imageView = (ImageView)convertView.findViewById(R.id.iconHerb);
            DecodeTask dt1 = (DecodeTask)imageView.getTag(R.id.iconHerb);
            if(dt1 != null)
                dt1.cancel(true);
        }

        imageView.setImageBitmap(null);
        DecodeTask dt2 = new DecodeTask(getContext(), imageView, RESOURCE_ID[position]);
        dt2.execute();
        imageView.setTag(R.id.iconHerb, dt2);

        TextView textView = (TextView)convertView.findViewById(R.id.itemHerb);
        textView.setText(STR[position]);

        return convertView;
    }
}
