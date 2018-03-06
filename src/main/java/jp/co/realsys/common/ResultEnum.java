package jp.co.realsys.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ResultEnum {
    SYSTEM_ERROR(-1,"系统错误"),
    SUCCESS(0,"成功"),
    PARAM_ERROR(99,"输入参数错误"),
    UNKNOWN_JSON_ERROR(100,"错误,未知json暴走"),
    UNKNOWN_PAGE_ERROR(101,"错误,未知页面暴走"),
    ROLE_NAME_ALREADY_EXIST(110,"角色名称已经存在"),
    NO_AUTH(111,"没有权限访问,如果需要访问,请联系管理员"),
    ;


    private Integer code;
    private String msg;



}
