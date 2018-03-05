package jp.co.realsys.util;

import com.google.common.base.Splitter;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class StringUtil {
    public static List<Integer> spitToListInt(String str){
        List<String> strList = Splitter.on(",").trimResults().omitEmptyStrings().splitToList(str);
        return strList.stream().map(Integer::parseInt).collect(toList());
    }
}
