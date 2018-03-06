package jp.co.realsys.common;


import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class JsonData {
    //返回结果
    private boolean ret;
    //错误代码
    private Integer code;
    //异常时的msg
    private String msg;
    //数据
    private Object data;

    private JsonData(boolean result){
        this.ret = result;
    }

    //未含数据的成功
    public static JsonData success(){
        return new JsonData(true);
    }

    public static JsonData success(Object dataObject){
        JsonData jsonData = new JsonData(true);
        jsonData.data =dataObject;
        return jsonData;
    }

    //含有数据的成功返回
    public static JsonData success(Object dataObject,String msg){
        JsonData jsonData = new JsonData(true);
        jsonData.data =dataObject;
        jsonData.msg = msg;
        return jsonData;
    }
    public static JsonData success(Object dataObject,Integer  code,String msg){
        JsonData jsonData = new JsonData(true);
        jsonData.data =dataObject;
        jsonData.code = code;
        jsonData.msg = msg;
        return jsonData;
    }

    //含有错误代码的返回
    public static JsonData fail(Integer code,String msg){
        JsonData jsonData = new JsonData(false);
        jsonData.code=code;
        jsonData.msg=msg;
        return jsonData;
    }

    //转换成Map
    public Map<String,Object> toMap(){
        HashMap<String,Object> resultMap = new HashMap<>();
        resultMap.put("ret",ret);
        resultMap.put("code",code);
        resultMap.put("msg",msg);
        resultMap.put("data",data);
        return resultMap;
    }


}
