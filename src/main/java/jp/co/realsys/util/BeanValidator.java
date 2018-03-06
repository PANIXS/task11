package jp.co.realsys.util;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import jp.co.realsys.exception.ParamException;
import org.apache.commons.collections.MapUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.*;

public class BeanValidator {

    private static ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();

    public static <T>Map<String,String> validate(T t,Class...groups){
        Validator validator = validatorFactory.getValidator();
        Set validateResult = validator.validate(t,groups);
        if (validateResult.isEmpty()){
            return Collections.emptyMap();
        }else{
            LinkedHashMap errors = Maps.newLinkedHashMap();
            Iterator iterator = validateResult.iterator();
            while (iterator.hasNext()){
                ConstraintViolation violation = (ConstraintViolation)iterator.next();
                errors.put(violation.getPropertyPath().toString(),violation.getMessage());
            }
            return errors;
        }
    }

    /*
     * 调用前面的方法,验证一个List,还是返回map
     * 遍历List
     * */
    public static Map<String,String> validateList(Collection<?> collection){
        Preconditions.checkNotNull(collection);
        Iterator iterator = collection.iterator();
        Map errors;
        do {
            if (!iterator.hasNext()){
                return Collections.emptyMap();//空集合则返回空
            }
            Object object = iterator.next();
            errors = validate(object,new Class[0]);
        }while(errors.isEmpty());
        return errors;
    }

    /*
     * 验证Object类型的对象,还是调用之前的方法
     * Object -> List
     * */
    public static <T> Map<String,String> validateObject(Object first,Object... objects){
        if (objects!=null && objects.length>0){//数组不为空的时候
            return validateList(Lists.asList(first,objects));
        }else{//只传了单个Object的时候
            return validate(first,new Class[0]);
        }
    }
    /*
     * 将之前的方法封装成静态方法,验证结果不为空则抛出传参数异常,并携带包含错误信息的map
     * */
    public static void check(Object param)throws ParamException {
        Map<String,String> map = BeanValidator.validateObject(param);
        if (MapUtils.isNotEmpty(map)){
            throw new ParamException(map.toString());
        }
    }
}
