package jp.co.realsys.param;

import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@ToString
public class VStudentParam {

    private Integer id;

    @NotBlank(message = "学生名字不能为空")
    @Length(min=1,max = 20,message = "角色名字在1-20个字之间")
    private String name;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    @NotBlank(message = "地址不可以为空")
    @Length(min = 2,max = 40,message = "地址长度在2-40个字之间")
    private String address;


    @Min(value = 1,message = "班级设置不合法")
    @Max(value = 100,message = "班级设置不合法")
    private Integer classid = 0;
}
