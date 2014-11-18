package per.thiennn.myuserfulfunction.view.view;

import per.thiennn.myusefulfunction.R;
import per.thiennn.myuserfulfunction.view.adapter.MyListViewAdapter;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

/**
 *  @author ThienNN
 *  ListView example
 */
public class MyListView extends Activity{
    public String TAG="ListView";
    private ListView myListView;
    private MyListViewAdapter myListViewAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_listview_layout);
        /* Init component */
        myListViewAdapter= new MyListViewAdapter(getApplicationContext(),20);
        myListView = (ListView)this.findViewById(R.id.my_list_view);
        myListView.setAdapter(myListViewAdapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private void validateListViewData(){
        /**
         * @nonJava
         * using notifyDataSetChanged() function after change data of constructor like list<> object
         */
        myListViewAdapter.notifyDataSetChanged();
    }
}
