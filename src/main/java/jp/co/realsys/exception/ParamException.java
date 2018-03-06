package jp.co.realsys.exception;

import jp.co.realsys.common.ResultEnum;

public class ParamException extends FatherException {

    public ParamException(String message) {
        super(message);
    }
    public ParamException(Integer code,String message) {
        super(code,message);
    }
    public ParamException(ResultEnum resultEnum){
        super(resultEnum.getCode(),resultEnum.getMsg());
    }

}
