package jp.co.realsys.controller;

import com.google.common.collect.Lists;
import com.sun.org.apache.regexp.internal.RE;
import jp.co.realsys.common.JsonData;
import jp.co.realsys.constant.UrlPattern;
import jp.co.realsys.model.Japanese;
import jp.co.realsys.param.JapaneseParam;
import jp.co.realsys.service.JapaneseService;
import jp.co.realsys.util.StringUtil;
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
        List<Integer> japaneseSexList = Lists.newArrayList(0,1,2);
        model.addAttribute("japaneseList",japaneseList);
        model.addAttribute("sexList",japaneseSexList);
        return UrlPattern.INDEX;
    }

    @RequestMapping(value = "getByNameAndSex",method = RequestMethod.POST)
    public String getByName(String name,Integer sex,Model model){
        List<Integer> japaneseSexList = Lists.newArrayList(0,1,2);
        model.addAttribute("sexList",japaneseSexList);

        /*if (StringUtils.isBlank(name))
            return UrlPattern.INDEX;*/
        List<Japanese> japaneseList = japaneseService.getByNameAndSex(StringUtils.trim(name),sex);
        model.addAttribute("lastName",name);
        model.addAttribute("lastSex",sex);
        model.addAttribute("japaneseList",japaneseList);
        return UrlPattern.INDEX;
    }

    @RequestMapping(value = "updatePage",method = RequestMethod.GET)
    public String updatebefore(Integer japaneseID,Model model){
        Japanese before = japaneseService.getSingle(japaneseID);
        List<Integer> japaneseSexList = Lists.newArrayList(0,1,2);
        model.addAttribute("sexList",japaneseSexList);
        model.addAttribute("japanese",before);
        return UrlPattern.UPDATE;
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
        List<Integer> japaneseSexList = Lists.newArrayList(0,1,2);
        model.addAttribute("japaneseList",japaneseList);
        model.addAttribute("sexList",japaneseSexList);
       return UrlPattern.INDEX;
    }

    @RequestMapping(value = "deleteJapanese",method = RequestMethod.POST)
    @ResponseBody
    public JsonData delete(String deleteList){
        List<Integer> idList = StringUtil.spitToListInt(deleteList);
        idList.forEach(a->japaneseService.delete(a));
        return JsonData.success();
    }

    @RequestMapping(value = "insertPage",method = RequestMethod.GET)
    public String InsertPage(Model model){
        List<Integer> japaneseSexList = Lists.newArrayList(0,1,2);
        model.addAttribute("sexList",japaneseSexList);
        return UrlPattern.INSERT;
    }

    @RequestMapping(value = "insert",method = RequestMethod.POST)
    public String Insert(JapaneseParam japaneseParam,Model model){
        japaneseService.insert(japaneseParam);
        List<Japanese> japaneseList= japaneseService.getAll();
        List<Integer> japaneseSexList = Lists.newArrayList(0,1,2);
        model.addAttribute("japaneseList",japaneseList);
        model.addAttribute("sexList",japaneseSexList);
        return UrlPattern.INDEX;
    }
}
