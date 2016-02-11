package appbsru.supergolf.healthrecord;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by pradit on 11/2/2559.
 */
public class CustomAdapter extends BaseAdapter{
    Context mContext;
    String[] strName;
    int[] resId;

    public CustomAdapter(Context context, String[] strName) {
        this.mContext = context;
        this.strName = strName;
        this.resId = resId;
    }

    public int getCount() {
        return strName.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater mInflater =
                (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (view == null)
            view = mInflater.inflate(R.layout.list_drug1, parent, false);

        TextView textView = (TextView) view.findViewById(R.id.textView1);
        textView.setText(strName[position]);


        return view;
    }
}
