package com.smapley.prints_yun.util;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;

import com.smapley.prints_yun.activity.MainActivity;
import com.smapley.prints_yun.adapter.KeyboardAdapter;
import com.smapley.prints_yun.http.result.IndexResult;
import com.smapley.prints_yun.mode.BaseMode;
import com.smapley.prints_yun.mode.KeyboardItemMode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by smapley on 16/5/2.
 */
public class KeyboardUtil {
    private Context ctx;
    private Activity act;
    private RecyclerView keyboardItem;
    private KeyboardAdapter keyboardAdapter;
    private List<BaseMode> keyboardList;

    private EditText ed;
    private int mPosition;

    public KeyboardUtil(Activity act, Context ctx,RecyclerView keyboardItem){
        this.act = act;
        this.ctx = ctx;
        this.keyboardItem=keyboardItem;
        //初始化键盘
        keyboardList = new ArrayList<>();
        keyboardAdapter = new KeyboardAdapter(act, ctx, keyboardList,null);
        keyboardItem.setAdapter(keyboardAdapter);


    }

    public void setKeyboard(IndexResult.Keyboard keyboard){
        keyboardList.clear();
        String[] items = keyboard.getCell().split(",");
        for (String item : items) {
            keyboardList.add(new KeyboardItemMode(item));
        }
        keyboardAdapter.notifyDataSetChanged();
        GridLayoutManager layoutManager = new GridLayoutManager(act, keyboard.getLayout());
        keyboardItem.setLayoutManager(layoutManager);
    }

    public void setEditext(EditText editext, final KeyboardAdapter.MyLimitListener myLimitListener, final IndexResult.Edit edit,int position){
        this.ed=editext;
        this.mPosition=position;
        ed.setText("");
        keyboardAdapter.setOnItemClickListener(new KeyboardAdapter.MyItemClickListener() {
            @Override
            public void onItemClick(View view, String text) {
                Editable editable = ed.getText();
                if(editable.length()<edit.getLimit()) {
                    int start = ed.getSelectionStart();
                    editable.insert(start, text);
                }


                if(editable.length()>=edit.getLimit()) {
                    myLimitListener.ToNextInput(ed,mPosition);
                }
            }
        });
    }



    public void showKeyboard() {
        int visibility = keyboardItem.getVisibility();
        if (visibility == View.GONE || visibility == View.INVISIBLE) {
            keyboardItem.setVisibility(View.VISIBLE);
            ((MainActivity)act).hideBottom();
        }
    }

    public void hideKeyboard() {
        int visibility = keyboardItem.getVisibility();
        if (visibility == View.VISIBLE) {
            keyboardItem.setVisibility(View.GONE);
            ((MainActivity)act).showBottom();
        }
    }

}
