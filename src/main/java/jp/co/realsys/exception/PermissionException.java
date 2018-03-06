package jp.co.realsys.exception;


import jp.co.realsys.common.ResultEnum;

public class PermissionException extends FatherException {

    public PermissionException(String message) {
        super(message);
    }
    public PermissionException(Integer code,String message) {
        super(code,message);
    }

    public PermissionException(ResultEnum resultEnum){
        super(resultEnum.getCode(),resultEnum.getMsg());
    }
}
