package jp.co.realsys.dao;

import jp.co.realsys.model.VClass;

public interface VClassMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(VClass record);

    int insertSelective(VClass record);

    VClass selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(VClass record);

    int updateByPrimaryKey(VClass record);
}