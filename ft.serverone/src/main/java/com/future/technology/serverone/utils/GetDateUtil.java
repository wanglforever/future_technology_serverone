package com.future.technology.serverone.utils;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by three on 2017/12/1.
 */
public class GetDateUtil {

    public static String getDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String dateStr = sdf.format(date);
        return dateStr;
    }

    public static String suffixDateFormat() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String dateStr = sdf.format(date);
        return dateStr;
    }
}
