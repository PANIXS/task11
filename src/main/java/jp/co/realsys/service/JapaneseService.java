package jp.co.realsys.service;

import jp.co.realsys.dao.JapaneseMapper;
import jp.co.realsys.model.Japanese;
import jp.co.realsys.model.JapaneseExample;
import jp.co.realsys.param.JapaneseParam;
import jp.co.realsys.util.BeanValidator;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class JapaneseService {
    @Resource
    JapaneseMapper japaneseMapper;


    public List<Japanese> getAll(){
       return japaneseMapper.getAll();
    }

    public int insert(JapaneseParam japaneseParam){
        BeanValidator.check(japaneseParam);
        if (!checkExist(japaneseParam.getId()))
            return 0;
        Japanese before = Japanese.builder().id(japaneseParam.getId()).age(japaneseParam.getAge()).sex(japaneseParam.getSex()).user(japaneseParam.getUser()).build();
      return   japaneseMapper.insertSelective(before);
    }

    public List<Japanese> getByName(String name){
        JapaneseExample japaneseExample = new JapaneseExample();
        JapaneseExample.Criteria japaneseExampleCriteria= japaneseExample.createCriteria();
        japaneseExampleCriteria.andUserEqualTo(name);
       return  japaneseMapper.selectByExample(japaneseExample);
    }

    public int update(JapaneseParam japaneseParam){
        BeanValidator.check(japaneseParam);
        Japanese japanese = Japanese.builder().user(japaneseParam.getUser()).sex(japaneseParam.getSex()).age(japaneseParam.getAge()).build();
        return japaneseMapper.updateByPrimaryKey(japanese);
    }

    public int delete(Integer id){
        if (checkExist(id)){
         return  japaneseMapper.deleteByPrimaryKey(id);
        }
        return 0;
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
