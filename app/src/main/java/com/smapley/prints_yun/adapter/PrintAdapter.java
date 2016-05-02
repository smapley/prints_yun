package com.smapley.prints_yun.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.smapley.prints_yun.R;
import com.smapley.prints_yun.view.AutoItemTextView;

import java.text.DecimalFormat;
import java.util.List;

/**
 * Created by hao on 2015/11/9.
 */
public class PrintAdapter extends BaseAdapter {

    private List<String> list;
    private LayoutInflater inflater;
    private Context context;
    private DecimalFormat df = new DecimalFormat("######0.0");
    private DecimalFormat dfs = new DecimalFormat("######0");

    public PrintAdapter(Context context, List<String> list) {
        this.list = list;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final String data = list.get(position);
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.layout_autoitemtextview, null);
            viewHolder = new ViewHolder();
            viewHolder.textView = (AutoItemTextView) convertView.findViewById(R.id.AutoItemTextView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.textView.setText(data);

        return convertView;
    }

    public class ViewHolder {
        AutoItemTextView textView;
    }
}
