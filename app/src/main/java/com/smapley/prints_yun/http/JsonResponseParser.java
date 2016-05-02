package com.smapley.prints_yun.http;

import com.alibaba.fastjson.JSON;

import org.xutils.common.util.LogUtil;
import org.xutils.common.util.ParameterizedTypeUtil;
import org.xutils.http.app.ResponseParser;
import org.xutils.http.request.UriRequest;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by smapley on 16/4/28.
 */
public class JsonResponseParser  implements ResponseParser {// 如果实现 InputStreamResponseParser, 可实现自定义流数据转换.

    @Override
    public void checkResponse(UriRequest request) throws Throwable {
        // custom check ?
        // get headers ?
    }

    /**
     * 转换result为resultType类型的对象
     *
     * @param resultType  返回值类型(可能带有泛型信息)
     * @param resultClass 返回值类型
     * @param result      字符串数据
     * @return
     * @throws Throwable
     */
    @Override
    public Object parse(Type resultType, Class<?> resultClass, String result) throws Throwable {
        // TODO: json to java bean
        LogUtil.d(result);
        if (resultClass == List.class) {
            // fastJson 解析:
            return JSON.parseArray(result, (Class<?>) ParameterizedTypeUtil.getParameterizedType(resultType, List.class, 0));
        } else {
            // fastjson 解析:
             return JSON.parseObject(result, resultClass);
        }

    }
}