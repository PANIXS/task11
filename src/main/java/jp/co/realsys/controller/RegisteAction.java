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


import jp.co.realsys.service.StudentService;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

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
	
	@RequestMapping(value="/registerPage",method=RequestMethod.GET)
	public String page(){
		return "registerStudent";
	}
	
	@RequestMapping(value="/registerNewStu",method=RequestMethod.GET)
	public String registeStudent(Student student,RedirectAttributes attributes) {
		if (studentService.doRegisterStduent(student)>0){
			attributes.addFlashAttribute("student",student);
			attributes.addFlashAttribute("msg","新增成功");
		}else{
			attributes.addFlashAttribute("msg","新增失败");
		}
		return "redirect:registerResultAction";
	}
	
	
	
}
