package com.smapley.prints_yun.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by smapley on 16/4/29.
 */
public class AutoItemTextView extends TextView {

    private String[] autoText;

    private Rect[] rects;
    private Paint paint;

    public AutoItemTextView(Context context) {
        super(context);
    }

    public AutoItemTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AutoItemTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }



    @Override
    protected void onDraw(Canvas canvas) {
        /**
         * 获得绘制文本的宽和高
         */
        autoText=getText().toString().split(",");
        rects = new Rect[autoText.length];
        for (int i = 0; i < autoText.length; i++) {
            paint = new Paint();
            paint.setTextSize(getTextSize());
            rects[i] = new Rect();
            paint.getTextBounds(autoText[i], 0, autoText[i].length(), rects[i]);
        }

//        paint.setColor(Color.YELLOW);
//        canvas.drawRect(0, 0, getMeasuredWidth(), getMeasuredHeight(), paint);


        paint.setColor(getCurrentTextColor());
        for (int i = 0; i < autoText.length; i++) {
            canvas.drawText(autoText[i],
                    getWidth() / autoText.length / 2 - rects[i].width() / 2 + getWidth() / autoText.length * i,
                    getHeight() / 2 + rects[i].height() / 2,
                    paint);
        }
    }

}
