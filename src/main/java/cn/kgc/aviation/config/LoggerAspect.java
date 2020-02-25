package cn.kgc.aviation.config;

import cn.kgc.aviation.dao.sys.SysLogDao;
import cn.kgc.aviation.model.dto.SysLog;
import cn.kgc.aviation.utils.IDGenerator;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Date;

/**
 * @program: aviation
 * @description: TODO
 * @author: cuihao
 * @create: 2020-02-24 16:37
 * @version: V1.0
 **/
@Aspect
@Component
public class LoggerAspect {

    @Autowired
    private SysLogDao sysLogDao;

    @Pointcut("@annotation(cn.kgc.aviation.config.Logger)")
    public void pointcut(){}

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint){
        Object obj = null;
        try {
            obj=joinPoint.proceed(); // 执行方法
        }catch (Throwable e){
        }
        saveSysLog(joinPoint);
        return obj;
    }

    private void saveSysLog(ProceedingJoinPoint joinPoint){
        SysLog sysLog = getSysLog(joinPoint);
        sysLogDao.saveSysLog(sysLog);
    }

    private SysLog getSysLog(ProceedingJoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        // 方法
        Method method = methodSignature.getMethod();
        // 方法上的注解
        Logger loggerAnnotation = method.getAnnotation(Logger.class);

        SysLog sysLog = new SysLog();

        if (loggerAnnotation != null){
            // 注解上的描述
            sysLog.setOperation(loggerAnnotation.value());
        }
        // 方法名
        String className = joinPoint.getTarget().getClass().getName();
        String methonName = methodSignature.getName();
        sysLog.setMethod(className + "." + methonName + "()");

        // 方法参数值
        Object[] args = joinPoint.getArgs();
        // 方法参数名
        LocalVariableTableParameterNameDiscoverer discoverer = new LocalVariableTableParameterNameDiscoverer();
        String[] paramNames = discoverer.getParameterNames(method);
        if (args != null && paramNames != null){
            String params = "";
            for (int i = 0; i < args.length; i++){
                params += " " + paramNames[i] + ": " + args[i];
            }
            sysLog.setParams(params);
        }
        sysLog.setSid(IDGenerator.getID());
        sysLog.setUsername("admin");
        sysLog.setLogDate(new Date());
        return sysLog;
    }
}
