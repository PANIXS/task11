package jp.co.realsys.dao;

import java.util.List;
import jp.co.realsys.model.Japanese;
import jp.co.realsys.model.JapaneseExample;
import org.apache.ibatis.annotations.Param;

public interface JapaneseMapper {
    int countByExample(JapaneseExample example);

    int deleteByExample(JapaneseExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Japanese record);

    int insertSelective(Japanese record);

    List<Japanese> selectByExample(JapaneseExample example);

    Japanese selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Japanese record, @Param("example") JapaneseExample example);

    int updateByExample(@Param("record") Japanese record, @Param("example") JapaneseExample example);

    int updateByPrimaryKeySelective(Japanese record);

    int updateByPrimaryKey(Japanese record);

    List<Japanese> getAll();

    List<Integer> getAllSex();

    List<Japanese> getByNameAndSex(@Param("name") String name,@Param("sex") Integer sex);
}