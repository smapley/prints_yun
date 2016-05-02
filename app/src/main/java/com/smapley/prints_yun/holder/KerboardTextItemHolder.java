package com.smapley.prints_yun.holder;

import android.view.View;
import android.widget.TextView;

import com.smapley.prints_yun.R;
import com.smapley.prints_yun.adapter.KeyboardAdapter;
import com.smapley.prints_yun.mode.KeyboardItemMode;

/**
 * Created by smapley on 16/4/29.
 */
public class KerboardTextItemHolder extends BaseHolder {

    private TextView keyboard_textItem;

    public KerboardTextItemHolder(View view) {
        super(view);
        keyboard_textItem=(TextView)view.findViewById(R.id.keyboard_textItem);
    }

    public void setData(final KeyboardItemMode mode, final KeyboardAdapter.MyItemClickListener myItemClickListener){
        keyboard_textItem.setText(mode.getItemText());
        keyboard_textItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myItemClickListener.onItemClick(view,mode.getItemText());
            }
        });
    }

}
