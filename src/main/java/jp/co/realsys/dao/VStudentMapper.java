package jp.co.realsys.dao;

import jp.co.realsys.model.VStudent;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VStudentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(VStudent record);

    int insertSelective(VStudent record);

    VStudent selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(VStudent record);

    int updateByPrimaryKey(VStudent record);

    List<VStudent> getAll();

    List<VStudent> getByClassID(Integer classID);

    List<VStudent> getByName(@Param("name") String name);
}