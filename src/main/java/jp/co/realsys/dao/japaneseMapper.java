package jp.co.realsys.dao;

import java.util.List;
import jp.co.realsys.model.japanese;
import jp.co.realsys.model.japaneseExample;
import org.apache.ibatis.annotations.Param;

public interface japaneseMapper {
    int countByExample(japaneseExample example);

    int deleteByExample(japaneseExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(japanese record);

    int insertSelective(japanese record);

    List<japanese> selectByExample(japaneseExample example);

    japanese selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") japanese record, @Param("example") japaneseExample example);

    int updateByExample(@Param("record") japanese record, @Param("example") japaneseExample example);

    int updateByPrimaryKeySelective(japanese record);

    int updateByPrimaryKey(japanese record);
}