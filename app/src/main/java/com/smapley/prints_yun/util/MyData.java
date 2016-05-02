package com.smapley.prints_yun.util;

/**
 * Created by smapley on 2015/5/20.
 */
public class MyData {

    public static String UserName;
    public static String PassWord;
    public static boolean Login = false;

    public static String IP = "120.25.208.188";

    private static String urlIndex = "index.php";
    private static String urlXiazai = ".php";


    public static String getBaseUrl() {
        return "http://" + IP + "/newera/";
    }

    public static String getUrlXiazai() {
        return getBaseUrl() + urlXiazai;
    }

    public static String getUrlIndex() {
        return getBaseUrl() + urlIndex;
    }
}
