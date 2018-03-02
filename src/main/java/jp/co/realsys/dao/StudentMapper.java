package jp.co.realsys.dao;

import java.util.List;

import jp.co.realsys.model.Student;

public interface StudentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer id);
    
    List<Student> selectByName(String name);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
}