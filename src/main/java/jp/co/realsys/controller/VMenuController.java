package jp.co.realsys.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping(value = "vmenu")
public class VMenuController {

    @RequestMapping(value="",method= RequestMethod.GET)
    public String executeAction(@RequestParam(value="actionType",required=false,defaultValue="") String actionType){

        String forward = "vmenu";

        if(StringUtils.isNotBlank(actionType)){
            if ("register".equals(actionType)) {
                forward = "redirect:vregister";
            } else if ("query".equals(actionType)) {
                forward = "redirect:vquery";
            } else if ("delete".equals(actionType)) {
                forward = "redirect:vdelete";
            } else if ("update".equals(actionType)) {
                forward = "redirect:vupdate";
            } else if("manager".equals(actionType)){
                forward = "redirect:vstudentmanager";
            }
        }

        return forward;
    }
}
