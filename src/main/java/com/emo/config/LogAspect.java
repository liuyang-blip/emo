package com.emo.config;


import com.emo.mapper.LogMapper;
import com.emo.pojo.Syslog;
import com.emo.pojo.User;
import com.emo.service.LogServiceImpl;
import com.emo.until.UntilTools;
import com.emo.until.aLog;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

@Slf4j
@Aspect
@Component
@Order(1)
public class LogAspect {

    private String contentA;
    private String requestIpA;
    private Method method1;

    public String getContentA() {
        return contentA;
    }

    public void setContentA(String contentA) {
        this.contentA = contentA;
    }

    public String getRequestIpA() {
        return requestIpA;
    }

    public void setRequestIpA(String requestIpA) {
        this.requestIpA = requestIpA;
    }

    /**
     * 操作数据库
     */
    @Autowired
    private LogMapper logMapper;
    @Autowired
    private LogServiceImpl logService;
    @Autowired
    private ObjectMapper mapper;

    Logger log = LoggerFactory.getLogger(getClass());
    /**
     * 开始时间
     */
    private Long visitTime;
    /**
     * 访问的类
     */
    private Class clazz;
    /**
     * 访问的方法
     */
    private Method method;

    /**
     * 申明一个切点，里面是execution表达式
     */
   @Pointcut("execution(public * com.emo.controller.*.*(..))")
    //@Pointcut("@annotation( com.emo.until.aLog)")
    private void aspect() {
    }


    @Before("aspect()")
    public void before(JoinPoint joinPoint) {
        visitTime = System.currentTimeMillis();
        Date date = new Date(visitTime);
        clazz = joinPoint.getTarget().getClass();
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        log.info("=============请求内容=============");
        String requestMethod = request.getMethod();
        log.info("请求时间:" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));
        log.info("请求IP:" + UntilTools.getRemoteIP(request));
        log.info("请求地址:" + request.getRequestURI());
        log.info("请求方式:" + requestMethod);
        log.info("请求类方法:" + joinPoint.getSignature());
        log.info("请求类方法参数:" + Arrays.toString(joinPoint.getArgs()));
        String url = "";
        if (clazz != null && method != null) {
            RequestMapping clazzAnnotation = (RequestMapping) clazz.getAnnotation(RequestMapping.class);
            if (clazzAnnotation != null) {
                String[] classValues = clazzAnnotation.value();
                if ("GET".equals(requestMethod)) {
                    GetMapping methodAnnotation = method.getAnnotation(GetMapping.class);
                    url(classValues, methodAnnotation != null, methodAnnotation.value());
                } else {
                    PostMapping methodAnnotation = method.getAnnotation(PostMapping.class);
                    url(classValues, methodAnnotation != null, methodAnnotation.value());
                }
            }
            log.info("类名:{},方法名{}", clazz.getName(), methodName);
        }
        log.info("=============请求内容=============");

        contentA = request.getRequestURI();
        requestIpA = UntilTools.getRemoteIP(request);
        method1 = ((MethodSignature) joinPoint.getSignature()).getMethod();
       //Syslog syslog = new Syslog();
//        //从切面织入点处通过反射机制获取织入点处的方法
//        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
//        //获取切入点所在的方法
//        Method method = signature.getMethod();
//        //获取操作
//        aLog aLog = method.getAnnotation(com.deyu.util.aLog.class);
//        if (aLog!=null){
//            String value = aLog.value();
//            syslog.setContent(value);//保存获取的操作
//        }
//        //获取请求的类名
//        String account = joinPoint.getTarget().getClass().getName();
//        syslog.setContent(account);
//        //获取用户名
//        String username = syslog.getName();
//        syslog.setName(username);
//        //获取用户ip地址
//       String request1 = UtilTools.getRemoteIP(request);
//       syslog.setRequestIp(request1);
       //logService.addLog(syslog);
    }

    @AfterReturning(returning = "obj", pointcut = "aspect()")
    public void methodAfterReturning(Object obj) {
        long time = System.currentTimeMillis() - visitTime;
        log.info("执行时间:{}ms", time);
        log.info("=============返回内容=============");
        try {
            log.info(mapper.writeValueAsString(obj));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            log.error("发生错误", e);
        }
        log.info("=============返回内容=============");
        System.out.println("===============================++++++++++++++++++++");
        HttpServletRequest requestA = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        System.out.println("requestIpA：" + requestIpA);
        if (requestA.getSession().getAttribute("login_session") == null) {
            System.out.println("操作人信息为空");
            return;
        } else {
            User userA = ((User) requestA.getSession().getAttribute("login_session"));
            String Cname = userA.getUsername();
            String CID = userA.getUsername();
            if (!requestIpA.equals("0:0:0:0:0:0:0:1")) {
                Syslog syslog = new Syslog(0, Cname, CID, contentA, requestIpA);

                aLog Clog = method1.getAnnotation(aLog.class);
                if (Clog != null) {
                    syslog.setContent(Clog.value());
                    System.out.println(syslog);
                    int code = logMapper.addLog(syslog);
                }
            }
        }
        System.out.println("===============================++++++++++++++++++++");
    }

    private void url(String[] classValues, boolean b, String[] value) {
        String url;
        if (b) {
            url = classValues[0] + value[0];
            log.info("url:{}", url);
        }
    }

}


