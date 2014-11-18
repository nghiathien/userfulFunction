package per.thiennn.myuserfulfunction.createview;

import per.thiennn.myusefulfunction.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MyView extends LinearLayout{
    public String TAG= "MyView";
    private Button myButton;
    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initview(context);
    }

    public void initview(Context context) {
        LayoutInflater layoutInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.my_dinamic_view, this);
        myButton = (Button)view.findViewById(R.id.my_dynamic_button);
        myButton.setOnClickListener(onClickFuntion);
    }

    OnClickListener onClickFuntion = new OnClickListener() {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
            case R.id.my_dynamic_button:
                break;
            default:
                break;
            }
        }
    };
}
