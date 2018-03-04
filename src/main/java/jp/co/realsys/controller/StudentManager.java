/*
 * システム名      ：競技者ID共通PF
 * サブシステム名  ：競技者ID管理機能
 * ソースファイル名：StudentManager.java
 * Copyright       ：
 */
package jp.co.realsys.controller;

import com.google.common.collect.Sets;
import jp.co.realsys.common.JsonData;
import jp.co.realsys.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.realsys.error.TaskException;
import jp.co.realsys.service.StudentService;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

/**
 * アプリケーションID：StudentManager
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
public class StudentManager {
	
	@Autowired
	private StudentService studentService;
	
	@RequestMapping(value="/studentmanager",method=RequestMethod.GET)
	public String page(Integer id) throws TaskException{
		return "studentManager2";
	}

	@RequestMapping(value = "/getClassIdList",method = RequestMethod.POST)
	@ResponseBody
	public JsonData getClassIdList(Integer classId){
		Set<Integer> classIdList = Sets.newHashSet(studentService.getAllClassId());
		return JsonData.success(classIdList);
	}

	@RequestMapping(value = "getStudentByClass",method = RequestMethod.POST)
	@ResponseBody
	public JsonData getStudentByClassId(Integer classId){
		List<Student> studentList = studentService.getStudentByClassId(classId);
		return JsonData.success(studentList);
	}

	@RequestMapping(value = "/updateClass",method = RequestMethod.POST)
	@ResponseBody
	public JsonData updateClass(Integer classId,List<Integer> studentList){
		studentService.updateClass(classId,studentList);
		return JsonData.success();
	}
}
