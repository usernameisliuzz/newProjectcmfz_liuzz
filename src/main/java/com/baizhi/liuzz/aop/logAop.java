package com.baizhi.liuzz.aop;

import com.baizhi.liuzz.annotation.LogAnnotation;
import com.baizhi.liuzz.entity.Log;
import com.baizhi.liuzz.entity.User;
import com.baizhi.liuzz.service.LogService;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.fileupload.servlet.ServletRequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Component
public class logAop implements MethodInterceptor{
    @Autowired
    private LogService logService;

    public Object invoke(MethodInvocation invocation) throws Throwable {
        Log log=new Log();
        Object proceed=null;
        HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
        User user = (User) request.getSession().getAttribute("user");
        //System.out.println(user);
        log.setUsername(user.getName());
        log.setDoDate(new Date());
        LogAnnotation annotation = invocation.getMethod().getAnnotation(LogAnnotation.class);
        log.setDoThing(annotation.description());
        try {
            proceed = invocation.proceed();
            log.setState("操作成功");
        }catch (Exception e){
            e.printStackTrace();
            log.setState("操作失败");
        }
        logService.addLog(log);
        return proceed;
    }
}
