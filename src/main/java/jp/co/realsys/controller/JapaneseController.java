package jp.co.realsys.controller;

import com.sun.org.apache.regexp.internal.RE;
import jp.co.realsys.common.JsonData;
import jp.co.realsys.constant.UrlPattern;
import jp.co.realsys.model.Japanese;
import jp.co.realsys.param.JapaneseParam;
import jp.co.realsys.service.JapaneseService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class JapaneseController {

    @Resource
    private JapaneseService japaneseService;

    @RequestMapping(value = "",method = RequestMethod.GET)
    public String page(Model model){
        List<Japanese> japaneseList= japaneseService.getAll();
        List<Integer> japaneseSexList = japaneseService.getAllSex();
        model.addAttribute("japaneseList",japaneseList);
        model.addAttribute("sexList",japaneseSexList);
        return UrlPattern.INDEX;
    }
/*    @RequestMapping(value = "getAll",method = RequestMethod.POST)
    public String getAll(Model model){
       List<Japanese> japaneseList= japaneseService.getAll();
       model.addAttribute("japaneseList",japaneseList);
       return UrlPattern.INDEX;
    }*/

    @RequestMapping(value = "getByName",method = RequestMethod.POST)
    public String getByName(String name,Model model){
        List<Integer> japaneseSexList = japaneseService.getAllSex();
        model.addAttribute("sexList",japaneseSexList);
        if (StringUtils.isBlank(name))
            return UrlPattern.INDEX;
        List<Japanese> japaneseList = japaneseService.getByName(name);
        model.addAttribute("japaneseList",japaneseList);
        return UrlPattern.INDEX;
    }

    @RequestMapping(value = "updateBefore",method = RequestMethod.POST)
    @ResponseBody
    public JsonData updatebefore(JapaneseParam japaneseParam){
        Japanese before = japaneseService.getSingle(japaneseParam);
        return JsonData.success(before);
    }
    @RequestMapping(value = "update",method = RequestMethod.POST)
    public String update(JapaneseParam japaneseParam,Model model){
       if (japaneseService.update(japaneseParam)>0) {
           model.addAttribute("updateResult", "更新成功");
       }
       else {
         model.addAttribute("updateResult","更新失败");
       }
        List<Japanese> japaneseList= japaneseService.getAll();
        List<Integer> japaneseSexList = japaneseService.getAllSex();
        model.addAttribute("japaneseList",japaneseList);
        model.addAttribute("sexList",japaneseSexList);
       return UrlPattern.INDEX;
    }

}
