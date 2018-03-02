/*
 * システム名      ：競技者ID共通PF
 * サブシステム名  ：競技者ID管理機能
 * ソースファイル名：UpdateController.java
 * Copyright       ：
 */
package jp.co.realsys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.realsys.error.TaskException;
import jp.co.realsys.model.Student;
import jp.co.realsys.service.StudentService;

/**
 * アプリケーションID：UpdateController
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
public class UpdateAction {
	
	@Autowired
	private StudentService studentService;
	
	
	@RequestMapping(value="update",method=RequestMethod.GET)
	public String page(){
		return "updateStudent";
	}
	
	
	public String updateStudent(Student student) throws TaskException{
		studentService.doUpdateStduent(student);
		return "updateResult";
	}
}