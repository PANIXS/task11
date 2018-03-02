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

import org.springframework.stereotype.Service;

import jp.co.realsys.error.TaskException;
import jp.co.realsys.model.Student;

/**
 * �w�����̋Ɩ��w�̃C���^�t�F�[�X
 * 
 * @author Realsys
 */
public interface StudentService {

    /**
     * �w������o�^����
     * 
     * @param student �w����񃂃f��
     * @return ���R�[�h��
     */
    public int doRegisterStduent(Student student) throws TaskException;

    /**
     * �w�������X�V����
     * 
     * @param student �w����񃂃f��
     * @return ���R�[�h��
     */
    public int doUpdateStduent(Student student) throws TaskException;

    /**
     * �w�������폜����
     * 
     * @param studentId �w��ID
     * @return ���R�[�h��
     */
    public int doDeleteStduent(Integer studentId) throws TaskException;

    /**
     * �w��������������
     * 
     * @param name ���O
     * @return �w�����
     */
    public List<Student> doQueryStduentList(String name) throws TaskException;
    
    /**
     * �w��������������
     * 
     * @param name ���O
     * @return �w�����
     */
    public Student doQueryStduentId(Integer id) throws TaskException;
}