package per.thiennn.myuserfulfunction.view.adapter;


import per.thiennn.myusefulfunction.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MyListViewAdapter extends BaseAdapter{
    Context myContext;
    public String TAG="MyListViewAdapter";
    private int numItems;
    public MyListViewAdapter(Context myContext,int numItems) {
        super();
        this.myContext = myContext;
        this.numItems=numItems;
    }
    @Override
    public int getCount() {
        return numItems;
    }
    @Override
    public Object getItem(int arg0) {
        return null;
    }

    @Override
    public long getItemId(int arg0) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        MyViewHolder myHolder;
        if (row == null) {
            LayoutInflater inflater = LayoutInflater.from(myContext);
            row = (LinearLayout)inflater.inflate(R.layout.view_listview_item, null);
            myHolder = new MyViewHolder();
            myHolder.txtItem = (TextView)row.findViewById(R.id.txt_item_comp);
            row.setTag(myHolder);
        }else{
            myHolder = (MyViewHolder) row.getTag();
        }
        myHolder.txtItem.setText(""+position);
        return row;
    }

    /* Create holder for listview */
    static class MyViewHolder{
        TextView txtItem;
    }
}
