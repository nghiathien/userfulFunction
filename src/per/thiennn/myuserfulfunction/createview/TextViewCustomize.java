package per.thiennn.myuserfulfunction.createview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

public class TextViewCustomize extends TextView {

    public TextViewCustomize(Context context) {
        super(context);
        init(null);
    }

    public TextViewCustomize(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(null);
    }

    public TextViewCustomize(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(null);
    }


    @Override
    public void setText(CharSequence text, BufferType type) {
        super.setText(text, type);
    }

    @Override
    public void setTextSize(float size) {
        super.setTextSize(size);
    }
    private void init(AttributeSet attrs) {
    }

    @Override
    public void setTextColor(int color) {
    }

}
