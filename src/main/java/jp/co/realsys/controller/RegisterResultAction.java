package jp.co.realsys.controller;

import jp.co.realsys.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class RegisterResultAction {
    @RequestMapping(value = "registerResultAction",method = RequestMethod.GET)
    public String page(@ModelAttribute("student") Student student, @ModelAttribute("msg")String msg, Model model){
        model.addAttribute("msg",msg);
        model.addAttribute("student",student);
        return "registerResult";
    }
}
