package jp.co.realsys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/test")
public class IndexController {
    @RequestMapping(value = "/velocity",method = RequestMethod.GET)
    public String news(Model model){
        model.addAttribute("hello","test velocity");
        return "test";
    }
}
