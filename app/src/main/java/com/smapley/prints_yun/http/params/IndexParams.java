package com.smapley.prints_yun.http.params;

import com.smapley.prints_yun.util.MyData;

import org.xutils.common.util.LogUtil;
import org.xutils.http.RequestParams;

/**
 * Created by smapley on 16/4/28.
 */
public class IndexParams extends RequestParams{

    public IndexParams(){
        super(MyData.getUrlIndex());

        try{
            LogUtil.d(toJSONString());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
