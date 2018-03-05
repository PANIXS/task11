package jp.co.realsys.controller;

import jp.co.realsys.common.JsonData;
import jp.co.realsys.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.realsys.error.TaskException;
import jp.co.realsys.service.StudentService;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class DeleteAction extends BaseAction {

	@Autowired
	private StudentService studentService;
	
	@RequestMapping(value="/delete",method = RequestMethod.GET)
	public String page(Model model) {
		List<Student> studentList = studentService.getAllStudent();
		model.addAttribute("studentList",studentList);
		return "showStudent";
	}
	
	@RequestMapping(value="/deleteStudent")
	@ResponseBody
	public JsonData deleteStudent(Integer stuId) {
		if (stuId==null)
			return JsonData.success();
		studentService.doDeleteStduent(stuId);
		return JsonData.success();
	}
}
