/*******************************************************************************
 *  �V�X�e���� : �w�����Ǘ�
 *  ���쌠    : Copyright (C)�@2002-2008�@Realsys Co. Ltd. �@All Rights Reserved.
 *  ��Ж�    : ���A���V�X�������
 *  ****************************************************************************
 *  �ύX����
 *  2008/03/20  �쐬�@
 */
package jp.co.realsys.controller;

import java.util.List;

import jp.co.realsys.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.realsys.error.TaskException;
import jp.co.realsys.service.StudentService;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * �����A�N�V�����N���X
 * 
 * @author Realsys
 */
@Controller
public class QueryAction extends BaseAction {

	@Autowired
	private StudentService studentService;
	
	@RequestMapping(value="query",method=RequestMethod.GET)
	public String page(){
		return "queryStudent";
	}
	
	@RequestMapping(value="queryStudent",method=RequestMethod.GET)
	public String queryStudent(String name, RedirectAttributes attributes) {
		List<Student> studentList= studentService.doQueryStduentList(name);
		attributes.addFlashAttribute("studentList",studentList);
		return "redirect:queryResult";
	}

}
