package cn.kgc.aviation.config;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: aviation
 * @description: TODO
 * @author: cuihao
 * @create: 2020-02-24 15:48
 * @version: V1.0
 **/
@RestControllerAdvice
public class CustomExceptionHandler {

    private static Logger LOGGER = LoggerFactory.getLogger(CustomExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    public Map errorHander(Exception e) {
        HashMap<String, Object> map = new HashMap<>();
        LOGGER.error(e.toString());
        map.put("code", 3001);
        map.put("msg","未知错误");
        return map;
    }

}
