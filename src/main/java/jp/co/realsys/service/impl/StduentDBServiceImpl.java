/*******************************************************************************
 *  �V�X�e���� : �w�����Ǘ�
 *  ���쌠    : Copyright (C)�@2002-2008�@Realsys Co. Ltd. �@All Rights Reserved.
 *  ��Ж�    : ���A���V�X�������
 *  ****************************************************************************
 *  �ύX����
 *  2008/03/20  �쐬�@
 */
package jp.co.realsys.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.realsys.dao.StudentDao;
import jp.co.realsys.dao.StudentMapper;
import jp.co.realsys.error.TaskException;
import jp.co.realsys.model.Student;
import jp.co.realsys.model.StudentModel;
import jp.co.realsys.service.StudentService;

/**
 * �w�����f�[�^�x�[�X�̋Ɩ��w�̎����N���X
 * 
 * @author Realsys
 */
@Service("studentService")
public class StduentDBServiceImpl implements StudentService{
    
   
    @Autowired
    private StudentMapper studentMapper;
    
    /**
     * �w������o�^����
     * 
     * @param student �w����񃂃f��
     * @return ���R�[�h��
     */
    public int doRegisterStduent(Student student) throws TaskException {
        //return studentDao.doRegisterStduent(student);
    	return studentMapper.insert(student);
    }

    /**
     * �w�������X�V����
     * 
     * @param student �w����񃂃f��
     * @return ���R�[�h��
     */
    public int doUpdateStduent(Student student) throws TaskException {
        //return studentDao.doUpdateStduent(student);
    	return studentMapper.updateByPrimaryKeySelective(student);
    }

    /**
     * �w�������폜����
     * 
     * @param studentId �w��ID
     * @return ���R�[�h��
     */
    public int doDeleteStduent(Integer studentId) throws TaskException {
        //return studentDao.doDeleteStduent(studentId);
        return studentMapper.deleteByPrimaryKey(studentId);
    }

    /**
     * �w��������������
     * 
     * @param name ���O
     * @return �w�����
     */
    public List<Student> doQueryStduentList(String name) throws TaskException {
        //return studentDao.doQueryStduentList(name);
    	return studentMapper.selectByName(name);
    }
    
    /**
     * �w��������������
     * 
     * @param name ���O
     * @return �w�����
     */
    public Student doQueryStduentId(Integer id) throws TaskException {
        //return studentDao.getQueryStudentById(id);
    	return studentMapper.selectByPrimaryKey(id);
    }

	
}
