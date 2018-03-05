package jp.co.realsys.dao;

import jp.co.realsys.model.stuClass;

import java.util.List;

public interface stuClassMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(stuClass record);

    int insertSelective(stuClass record);

    stuClass selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(stuClass record);

    int updateByPrimaryKey(stuClass record);

    List<Integer> getAllClassID();
}