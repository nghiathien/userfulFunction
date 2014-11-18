package per.thiennn.myuserfulfunction.createview;

import per.thiennn.myusefulfunction.R;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

public class MyDialog extends Dialog implements android.view.View.OnClickListener  {
    public String TAG="MemoImageDialog";
    public MyDialog(Context context) {
        super(context);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        this.setCancelable(false);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.static_dialog_size);
    }

    @Override
    public void dismiss() {
        super.dismiss();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
        default :
            break;
        }

    }
}
