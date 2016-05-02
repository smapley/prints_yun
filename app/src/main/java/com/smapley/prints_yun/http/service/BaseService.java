package com.smapley.prints_yun.http.service;

import android.widget.Toast;

import com.smapley.prints_yun.LocalApplication;
import com.smapley.prints_yun.R;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

/**
 * Created by smapley on 16/4/28.
 */
public abstract class BaseService<ResultType> implements Callback.CommonCallback<ResultType> {


    public void load(RequestParams params){
        x.http().post(params, this);

    }

    @Override
    public void onSuccess(ResultType result) {
        Success(result);
    }

    @Override
    public void onError(Throwable ex, boolean isOnCallback) {
        Toast.makeText(LocalApplication.getInstance(), R.string.internet_err,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCancelled(CancelledException cex) {

    }

    @Override
    public void onFinished() {

    }


    public abstract void Success(ResultType result);
}