package com.smapley.prints_yun.fragment;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.smapley.prints_yun.R;
import com.smapley.prints_yun.adapter.KeyboardAdapter;
import com.smapley.prints_yun.adapter.PrintAdapter;
import com.smapley.prints_yun.http.params.IndexParams;
import com.smapley.prints_yun.http.result.IndexResult;
import com.smapley.prints_yun.http.service.BaseService;
import com.smapley.prints_yun.mode.BaseMode;
import com.smapley.prints_yun.mode.KeyboardItemMode;
import com.smapley.prints_yun.util.KeyboardUtil;
import com.smapley.prints_yun.view.listview.SwipeMenu;
import com.smapley.prints_yun.view.listview.SwipeMenuCreator;
import com.smapley.prints_yun.view.listview.SwipeMenuItem;
import com.smapley.prints_yun.view.listview.SwipeMenuListView;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by smapley on 16/4/28.
 */
@ContentView(R.layout.fragment_print)
public class PrintFragment extends Fragment {

    @ViewInject(R.id.listView)
    private SwipeMenuListView listView;
    private PrintAdapter adapter;
    private List<String> dataList;

    @ViewInject(R.id.inputView)
    private RecyclerView inputView;
    private KeyboardAdapter inputAdapter;
    private List<BaseMode> inputList;

    @ViewInject(R.id.keyboardItem)
    private RecyclerView keyboardItem;

    private KeyboardUtil keyboardUtil;



    private BaseService baseService=new BaseService<IndexResult>() {
        @Override
        public void Success(IndexResult result) {
            initView(result);
        }
    };


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=x.view().inject(this, inflater, container);
        initData();
        initView();
        return view;
    }

    private void initData() {
        baseService.load(new IndexParams());

    }

    private void initView() {

        //初始化列表
        SwipeMenuCreator creator = new SwipeMenuCreator() {
            @Override
            public void create(SwipeMenu menu) {
                SwipeMenuItem deleteItem = new SwipeMenuItem(getActivity());
                // set item background
                deleteItem.setBackground(new ColorDrawable(Color.rgb(0xF9,
                        0x3F, 0x25)));
                // set item width
                deleteItem.setWidth(dp2px(90));
                // set a icon
                deleteItem.setIcon(R.mipmap.ic_delete);
                // add to menu
                menu.addMenuItem(deleteItem);
            }
        };
        // set creator
        listView.setMenuCreator(creator);

        // step 2. listener item click event
        listView.setOnMenuItemClickListener(new SwipeMenuListView.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(final int position, SwipeMenu menu, int index) {
                if (position != 0) {
                }
                return false;
            }
        });
        dataList=new ArrayList<>();
        adapter = new PrintAdapter(getActivity(), dataList);
        listView.setDivider(null);
        listView.setAdapter(adapter);

        //初始化輸入框
        inputList=new ArrayList<>();
        keyboardUtil=new KeyboardUtil(getActivity(),getActivity(),keyboardItem);
        inputAdapter=new KeyboardAdapter(getActivity(),getActivity(),inputList,keyboardUtil);
        inputView.setAdapter(inputAdapter);

    }


    private void initView(IndexResult result) {


        //加载列表
        dataList.clear();
        dataList.add(result.getSpace().getContent());
        adapter.notifyDataSetChanged();

        keyboardUtil.setKeyboard(result.getKeyboard());
        //加载输入框
        inputList.clear();
        for(int i=0;i< result.getEdit().getCount();i++){
            inputList.add(new KeyboardItemMode(result.getEdit()));
        }
        inputAdapter.notifyDataSetChanged();
        GridLayoutManager inputLayout=new GridLayoutManager(getActivity(),inputList.size());
        inputView.setLayoutManager(inputLayout);



    }

    private int dp2px(int dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp,
                getResources().getDisplayMetrics());
    }
}
