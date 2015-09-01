package joydroid.kanokpan.hello;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by HP on 30/8/2558.
 */
public class MyAdapter extends BaseAdapter {
    //EXplicit เชื่อมต่อ
    private Context objContext;  //ประกาศตัวแปร context
    private int[] iconInts;     //integer
    private String[] titleStrings;  //string, information that want to add
//below press Alt+Insert/Enter, find Constructor then select all variables (ObjContext, iconInts, titleStrings)

    public MyAdapter(Context objContext, int[] iconInts, String[] titleStrings) {
        this.objContext = objContext;
        this.iconInts = iconInts;
        this.titleStrings = titleStrings;
    }  //Constructor

    @Override
    public int getCount() {
        return titleStrings.length; //loops amount
    }

    @Override
    public Object getItem(int i) {
        return null;
    }  //not use

    @Override
    public long getItemId(int i) {
        return 0;
    }  //not use

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        //action on each loop
        //for send photo and text to layout (page1) คนหิ้วของ จากที่มี ไปลงในลิส
        LayoutInflater objLayoutInflator = (LayoutInflater) objContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //engine for tell position to post photo
        View objView1 = objLayoutInflator.inflate(R.layout.traffic_listview, viewGroup, false);

        //show icon
        ImageView iconImageView = (ImageView) objView1.findViewById(R.id.imvShowIcon);
        iconImageView.setImageResource(iconInts[i]);

        //show title
        TextView titleTextView = (TextView) objView1.findViewById(R.id.txtTitleDetail);
        titleTextView.setText(titleStrings[i]);

        return objView1;
    }

}   //Main class for make looping task
