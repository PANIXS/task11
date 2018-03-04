package jp.co.realsys.dao;

import jp.co.realsys.model.Student;
import org.apache.ibatis.annotations.Param;


import java.util.List;

public interface StudentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

    List<Student> selectByName(String name);

    List<Integer> getClassIdList();

    int deleteStudentFromClass(Integer classId);

    int batchUpdateClass(@Param("classId") Integer classId,@Param("studentIdList")List<Integer> studentIdList);

    List<Student> selectStudentByClassId(Integer classId);

    int countByStudentId(Integer id);
}