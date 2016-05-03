package com.smapley.prints_yun.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.smapley.prints_yun.R;
import com.smapley.prints_yun.adapter.MainViewPageAdapter;
import com.smapley.prints_yun.fragment.PrintFragment;
import com.smapley.prints_yun.view.CustomViewPager;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

@ContentView(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    @ViewInject(R.id.title_item1)
    private TextView title_item1;
    @ViewInject(R.id.title_item2)
    private TextView title_item2;
    @ViewInject(R.id.title_item3)
    private TextView title_item3;

    @ViewInject(R.id.bottom_item1)
    private TextView bottom_item1;
    @ViewInject(R.id.bottom_item2)
    private TextView bottom_item2;
    @ViewInject(R.id.bottom_item3)
    private TextView bottom_item3;
    @ViewInject(R.id.bottom_item4)
    private TextView bottom_item4;

    @ViewInject(R.id.bottom_layout)
    private LinearLayout bottom_layout;

    @ViewInject(R.id.fragment)
    private CustomViewPager viewPager;

    private PrintFragment printFragment;

    private MainViewPageAdapter viewPageAdapter;
    private List<Fragment> fragmentList;
    private int position = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        initData();
        initView();

    }

    private void initData() {

    }

    private void initView() {
        title_item2.setText("首页");

        fragmentList = new ArrayList<>();
        printFragment = new PrintFragment();
        fragmentList.add(printFragment);


        viewPageAdapter = new MainViewPageAdapter(getSupportFragmentManager(), fragmentList);
        viewPager.setAdapter(viewPageAdapter);
    }

    @Event({R.id.bottom_item1,R.id.bottom_item2})
    private void onClick(View view) {
        switch (view.getId()) {
            case R.id.bottom_item1:
                viewPagerGo(0);
                position = 1;
                break;
            case R.id.bottom_item2:
                viewPagerGo(1);
                position = 2;
                break;
            case R.id.bottom_item3:
                viewPagerGo(2);
                position = 3;
                break;
            case R.id.bottom_item4:
                viewPagerGo(3);
                position = 4;
                break;
        }
    }

    public void viewPagerGo(int num) {
        switch (num) {
            case 0:
                break;
            case 2:
                break;
            case 1:
                break;
            case 3:
                break;
        }

        viewPager.setCurrentItem(num);
    }

    public void showBottom() {
        int visibility = bottom_layout.getVisibility();
        if (visibility == View.GONE || visibility == View.INVISIBLE) {
            bottom_layout.setVisibility(View.VISIBLE);
        }
    }

    public void hideBottom() {
        int visibility = bottom_layout.getVisibility();
        if (visibility == View.VISIBLE) {
            bottom_layout.setVisibility(View.GONE);
        }
    }
}
