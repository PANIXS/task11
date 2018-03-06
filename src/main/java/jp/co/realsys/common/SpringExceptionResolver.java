package jp.co.realsys.common;


import jp.co.realsys.exception.FatherException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class SpringExceptionResolver implements HandlerExceptionResolver {


    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
       String url = request.getRequestURI();
       ModelAndView mv;

        //页面以.json或.page结尾
       if (url.endsWith(".json")){
           if (ex instanceof FatherException){
               FatherException exs = (FatherException)ex;
               JsonData result = JsonData.fail(exs.getCode(),exs.getMessage());
               mv = new ModelAndView("jsonView",result.toMap());
           } else{
               log.error("未知json暴走,url:"+url,ex);
               JsonData result = JsonData.fail(ResultEnum.UNKNOWN_JSON_ERROR.getCode(),ResultEnum.UNKNOWN_JSON_ERROR.getMsg());
               mv = new ModelAndView("jsonView",result.toMap());
           }
       } else if (url.endsWith(".page")) {
           log.error("未知页面暴走,url:"+url,ex);
           JsonData result = JsonData.fail(ResultEnum.UNKNOWN_PAGE_ERROR.getCode(),ResultEnum.UNKNOWN_PAGE_ERROR.getMsg());
           mv = new ModelAndView("jsonView",result.toMap());
       }else{
           log.error("未知错误,url:" + url,ex);
           JsonData result = JsonData.fail(ResultEnum.SYSTEM_ERROR.getCode(),ResultEnum.SYSTEM_ERROR.getMsg());
           mv = new ModelAndView("jsonView",result.toMap());
       }
       return mv;
    }
}
