package jp.co.realsys.common;


import jp.co.realsys.util.JsonMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Slf4j
public class HttpInterceptor extends HandlerInterceptorAdapter {

    private static final String START_TIME = "requestStartTime";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String url = request.getRequestURI();
        Map parameterMap = request.getParameterMap();
        log.info("请求开始.url:{},params:{}",url, JsonMapper.obj2String(parameterMap));//将请求参数转成Json
        long start = System.currentTimeMillis();
        request.setAttribute(START_TIME,start);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
       String url = request.getRequestURI();
       long start = (Long)request.getAttribute(START_TIME);
       long end = System.currentTimeMillis();
       log.info("完成请求.url:{},cost:{}",url,end-start);
       /* removeThreadLocalInfo();*/
    }

 /*   public void removeThreadLocalInfo(){
        RequestHolder.remove();
    }*/
}