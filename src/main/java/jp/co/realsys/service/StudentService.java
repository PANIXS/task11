/*******************************************************************************
 *  �V�X�e���� : �w�����Ǘ�
 *  ���쌠    : Copyright (C)�@2002-2008�@Realsys Co. Ltd. �@All Rights Reserved.
 *  ��Ж�    : ���A���V�X�������
 *  ****************************************************************************
 *  �ύX����
 *  2008/03/20  �쐬�@
 */
package jp.co.realsys.service;

import java.util.List;

import jp.co.realsys.error.TaskException;
import jp.co.realsys.model.Student;

/**
 * �w�����̋Ɩ��w�̃C���^�t�F�[�X
 * 
 * @author Realsys
 */
public interface StudentService {


     int doRegisterStduent(Student student) ;


     int doUpdateStduent(Student student) ;


     int doDeleteStduent(Integer studentId) ;


     List<Student> doQueryStduentList(String name) ;
    

     Student doQueryStduentId(Integer id) ;

     List<Integer> getAllClassId();

     List<Student> getAllStudent();

     void updateClass(Integer classId,List<Integer> studentIdList);

     List<Student> getStudentByClassId(Integer classId);
}