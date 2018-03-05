/*******************************************************************************
 *  �V�X�e���� : �w�����Ǘ�
 *  ���쌠    : Copyright (C)�@2002-2008�@Realsys Co. Ltd. �@All Rights Reserved.
 *  ��Ж�    : ���A���V�X�������
 *  ****************************************************************************
 *  �ύX����
 *  2008/03/20  �쐬�@
 */
package jp.co.realsys.service.impl;

import java.util.List;

import jp.co.realsys.dao.StudentMapper;
import jp.co.realsys.model.Student;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.realsys.error.TaskException;
import jp.co.realsys.service.StudentService;
import org.springframework.transaction.annotation.Transactional;
import jp.co.realsys.dao.stuClassMapper;
/**
 * �w�����f�[�^�x�[�X�̋Ɩ��w�̎����N���X
 * 
 * @author Realsys
 */
@Service("studentService")
public class StduentDBServiceImpl implements StudentService{
    
   
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private stuClassMapper studentClassMapper;
    

    public int doRegisterStduent(Student student) {
    	return studentMapper.insertSelective(student);
    }


    public int doUpdateStduent(Student student) {
        if (!checkStudentExists(student.getId())){
            return 0;
        }
    	return studentMapper.updateByPrimaryKeySelective(student);
    }


    public int doDeleteStduent(Integer studentId)  {
        if (!checkStudentExists(studentId))
            return 0;
        return studentMapper.deleteByPrimaryKey(studentId);
    }


    public List<Student> doQueryStduentList(String name)  {
    	return studentMapper.selectByName(name);
    }
    

    public Student doQueryStduentId(Integer id)  {
    	return studentMapper.selectByPrimaryKey(id);
    }

    public  List<Integer> getAllClassId(){
        return studentClassMapper.getAllClassID();
    }

    /*
    left ->先根据班级id把对应classid置0,再批量插入左边的列表(改变学生的classid)
    * */
    @Transactional
    public void updateClass(Integer classId,List<Integer> studentIdList){
        Integer num=studentMapper.deleteStudentFromClass(classId);
        if (CollectionUtils.isEmpty(studentIdList)){
            return ;
        }
        studentMapper.batchUpdateClass(classId,studentIdList);
    }

    public List<Student> getStudentByClassId(Integer classId){
        return  studentMapper.selectStudentByClassId(classId);
    }

    public List<Student> getAllStudent(){
        return studentMapper.getAllStudent();
    }
    private boolean checkStudentExists(Integer id){
        int num=studentMapper.countByStudentId(id);
        return num>0;
    }
	
}
