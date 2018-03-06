package jp.co.realsys.controller;

import jp.co.realsys.common.JsonData;
import jp.co.realsys.constant.UrlPattern;
import jp.co.realsys.model.VStudent;
import jp.co.realsys.param.VStudentParam;
import jp.co.realsys.service.VStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping(value = "vregister")
@Controller
public class VRegisterController {

    @Autowired
    private VStudentService vStudentService;

    @RequestMapping(value = "",method = RequestMethod.GET)
    public String page(){
        return UrlPattern.V_REGISTER;
    }

    @RequestMapping(value = "/insertStudent.page",method = RequestMethod.POST)
    public String register(VStudentParam student){
        vStudentService.Register(student);
        return UrlPattern.V_REGISTER;
    }

}
