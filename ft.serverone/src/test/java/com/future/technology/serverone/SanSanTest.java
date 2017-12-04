package com.future.technology.serverone;

import com.future.technology.serverone.utils.GetDateUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by three on 2017/12/1.
 */
public class SanSanTest {
    @Test
    public void format() {
        Map<String,List<String>> map = new HashMap<>();
        ArrayList<String> listone = new ArrayList<>();
        listone.add("11111");
        listone.add("22222");

        ArrayList<String> listtwo = new ArrayList<>();
        listtwo.add("11111");
        listtwo.add("22222");
        map.put("one",listtwo);
        map.put("two",listtwo);

        StringBuilder sb = new StringBuilder();
        for (String key : map.keySet()) {
            List<String> value = map.get(key);
            sb.setLength(0);
            sb.append("[");
            for (String s : value) {
                sb.append(s).append(",");
            }
            String substring = sb.toString().substring(0, sb.toString().length() - 1);
            substring += "]";
            System.out.println(key + "\t" + substring);
        }
    }

    @Test
    public void getDateTest() {
        String date = GetDateUtil.getDate();
        System.out.println(date);
    }

    @Test
    public void getSuffixDateTest() {
        String s = GetDateUtil.suffixDateFormat();
        System.out.println(s);
    }
}
