package jp.co.realsys.controller;

import jp.co.realsys.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class QueryResultAction {


    @RequestMapping(value = "queryResult",method = RequestMethod.GET)
    public String page(@ModelAttribute("studentList") List<Student> studentList, Model model){
        model.addAttribute("studentList",studentList);
        return "queryResult";
    }
}
