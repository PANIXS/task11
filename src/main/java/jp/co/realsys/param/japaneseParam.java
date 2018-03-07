package jp.co.realsys.param;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
public class japaneseParam {

    private Integer id;

    @NotBlank(message = "名字不能为空")
    @Length(min=1,max = 20,message = "角色名字在1-40个字之间")
    private String user;

    @NotNull(message = "学生性别不能为空")
    @Min(value = 0,message = "性别错误")
    @Max(value = 2,message = "性别错误")
    private Integer sex;

    @NotNull
    @Min(value = 0,message = "年龄不能为负数")
    @Max(value = 10000,message = "年龄最多10000年")
    private Integer age;

}