package com.smapley.prints_yun.holder;

import android.text.InputType;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;

import com.smapley.prints_yun.R;
import com.smapley.prints_yun.adapter.KeyboardAdapter;
import com.smapley.prints_yun.mode.KeyboardItemMode;
import com.smapley.prints_yun.util.KeyboardUtil;

/**
 * Created by smapley on 16/4/29.
 */
public class KerboardEdiTextHolder extends BaseHolder {

    public  EditText keyboard_ediText;
    private KeyboardUtil keyboardUtil;


    public KerboardEdiTextHolder(View view) {
        super(view);
        keyboard_ediText=(EditText)view.findViewById(R.id.keyboard_ediText);
    }

    public void setData(final KeyboardItemMode mode,final int position,final KeyboardUtil keyboardUtil,final KeyboardAdapter.MyLimitListener myLimitListener){
        if(mode.getEdit().getRoot()==1) {
            this.keyboardUtil=keyboardUtil;
            keyboard_ediText.setInputType(InputType.TYPE_NULL);
            keyboard_ediText.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    keyboardUtil.setEditext(keyboard_ediText,myLimitListener,mode.getEdit(),position);
                    keyboardUtil.showKeyboard();
                    return false;
                }
            });

        }
    }

}
