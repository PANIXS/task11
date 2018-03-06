package jp.co.realsys.dao;

import jp.co.realsys.model.VUser;

public interface VUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(VUser record);

    int insertSelective(VUser record);

    VUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(VUser record);

    int updateByPrimaryKey(VUser record);
}