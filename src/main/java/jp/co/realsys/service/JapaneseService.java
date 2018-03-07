package jp.co.realsys.service;

import com.google.common.base.Preconditions;
import jp.co.realsys.dao.JapaneseMapper;
import jp.co.realsys.model.Japanese;
import jp.co.realsys.model.JapaneseExample;
import jp.co.realsys.param.JapaneseParam;
import jp.co.realsys.util.BeanValidator;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

@Service
public class JapaneseService {
    @Resource
    private JapaneseMapper japaneseMapper;


    public List<Japanese> getAll(){
       return japaneseMapper.getAll();
    }

    public int insert(JapaneseParam japaneseParam){
        BeanValidator.check(japaneseParam);
        Japanese japanese = Japanese.builder().age(japaneseParam.getAge()).sex(japaneseParam.getSex()).user(japaneseParam.getUser()).build();
      return   japaneseMapper.insertSelective(japanese);
    }

    public List<Japanese> getByNameAndSex(String name,Integer sex){
        JapaneseExample japaneseExample = new JapaneseExample();
        JapaneseExample.Criteria japaneseExampleCriteria= japaneseExample.createCriteria();
        japaneseExampleCriteria.andUserLike(name);
        if (null!=sex)
            japaneseExampleCriteria.andSexEqualTo(sex);
       return  japaneseMapper.selectByExample(japaneseExample);
    }

    public Japanese getSingle(Integer japaneseID){
        return japaneseMapper.selectByPrimaryKey(japaneseID);
    }

    public List<Integer> getAllSex(){
        List<Integer> sexList =  japaneseMapper.getAllSex();
        Collections.sort(sexList);
        return sexList;
    }

    public int update(JapaneseParam japaneseParam){
        BeanValidator.check(japaneseParam);
        Japanese japanese = Japanese.builder().id(japaneseParam.getId()).user(japaneseParam.getUser()).sex(japaneseParam.getSex()).age(japaneseParam.getAge()).build();
        return japaneseMapper.updateByPrimaryKey(japanese);
    }

    public int delete(Integer id){
        Japanese before = japaneseMapper.selectByPrimaryKey(id);
        Preconditions.checkNotNull(before,"待删除的日本人不存在");
        return  japaneseMapper.deleteByPrimaryKey(id);
    }

    private boolean checkExist(Integer id){
        JapaneseExample japaneseExample = new JapaneseExample();
        JapaneseExample.Criteria japaneseExampleCriteria= japaneseExample.createCriteria();
        japaneseExampleCriteria.andIdEqualTo(id);
        int num =  japaneseMapper.countByExample(japaneseExample);
        if (num>0)
            return Boolean.TRUE;
        return Boolean.FALSE;
    }
}
