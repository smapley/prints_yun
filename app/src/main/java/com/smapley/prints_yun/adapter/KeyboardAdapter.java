package com.smapley.prints_yun.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.smapley.prints_yun.R;
import com.smapley.prints_yun.holder.KerboardEdiTextHolder;
import com.smapley.prints_yun.holder.KerboardTextItemHolder;
import com.smapley.prints_yun.mode.BaseMode;
import com.smapley.prints_yun.mode.KeyboardItemMode;
import com.smapley.prints_yun.util.KeyboardUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by smapley on 15/11/16.
 */
public class KeyboardAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<BaseMode> modeList;
    private Context context;
    private LayoutInflater inflater;
    private Activity activity;
    private KeyboardUtil keyboardUtil;

    private MyItemClickListener myItemClickListener;
    private KeyboardAdapter.MyLimitListener myLimitListener = new KeyboardAdapter.MyLimitListener() {
        @Override
        public void ToNextInput(View view, Integer position) {
            if(position+1<holderList.size()) {
                ((KerboardEdiTextHolder) holderList.get(position + 1)).keyboard_ediText.requestFocus();
                keyboardUtil.setEditext(((KerboardEdiTextHolder) holderList.get(position + 1)).keyboard_ediText, myLimitListener, ((KeyboardItemMode) modeList.get(position + 1)).getEdit(), position + 1);
            }
        }
    };

    private List<RecyclerView.ViewHolder> holderList;

    public KeyboardAdapter(Activity activity, Context context, List<BaseMode> modeList, KeyboardUtil keyboardUtil) {
        this.modeList = modeList;
        this.activity = activity;
        this.context = context;
        this.keyboardUtil = keyboardUtil;
        holderList = new ArrayList<>();
        inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        switch (viewType) {
            case 1:
                view = inflater.inflate(R.layout.layout_keyboard_textitem, parent, false);
                return new KerboardTextItemHolder(view);
            case 2:
                view = inflater.inflate(R.layout.layout_keyboard_editext, parent, false);
                return new KerboardEdiTextHolder(view);

        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        holderList.add(position, holder);
        switch (getItemViewType(position)) {
            case 1:
                ((KerboardTextItemHolder) holder).setData((KeyboardItemMode) modeList.get(position), myItemClickListener);
                break;
            case 2:
                ((KerboardEdiTextHolder) holder).setData((KeyboardItemMode) modeList.get(position), position, keyboardUtil,myLimitListener);
        }
    }


    @Override
    public int getItemViewType(int position) {
        return modeList.get(position).getType();
    }

    @Override
    public int getItemCount() {
        if (modeList == null) {
            return 0;
        } else {
            return modeList.size();
        }
    }

    /**
     * 设置Item点击监听
     *
     * @param listener
     */
    public void setOnItemClickListener(MyItemClickListener listener) {
        this.myItemClickListener = listener;
    }


    public interface MyItemClickListener {
        void onItemClick(View view, String text);
    }

    public interface MyLimitListener {
        void ToNextInput(View view, Integer position);
    }
}
