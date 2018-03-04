/*
 * システム名      ：競技者ID共通PF
 * サブシステム名  ：競技者ID管理機能
 * ソースファイル名：RegisteController.java
 * Copyright       ：
 */
package jp.co.realsys.controller;

import jp.co.realsys.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.realsys.error.TaskException;
import jp.co.realsys.service.StudentService;

/**
 * アプリケーションID：RegisteController
 * 
 * TODO
 *
 * [変更履歴]
 * 1.0.0 2018/03/02 Fujitsu)admin H29競技者ID共通プラットフォームの構築
 *
 * @author Fujitsu)admin
 * @version 1.0.0
 */
@Controller
public class RegisteAction {
	
	@Autowired
	private StudentService studentService;
	
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String page(){
		return "registerStudent";
	}
	
	@RequestMapping(value="/registe",method=RequestMethod.POST)
	public String registeStudent(Student student) throws TaskException{
		studentService.doRegisterStduent(student);
		return "registerResult";
	}
	
	
	
}
