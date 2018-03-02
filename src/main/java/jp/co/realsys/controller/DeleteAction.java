package jp.co.realsys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.realsys.error.TaskException;
import jp.co.realsys.service.StudentService;

@Controller
public class DeleteAction extends BaseAction {

	@Autowired
	private StudentService studentService;
	
	@RequestMapping(value="/delete")
	public String page(Integer id) throws TaskException{
		return "deleteStudent";
	}
	
	@RequestMapping(value="/deleteStudent")
	public String deleteStudent(Integer id) throws TaskException{
		studentService.doDeleteStduent(id);
		return "deleteResult";
	}
}
