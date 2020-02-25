package cn.kgc.aviation.controller.sys;

import cn.kgc.aviation.model.dto.Result;
import cn.kgc.aviation.service.sys.LoggerService;
import cn.kgc.aviation.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @program: aviation
 * @description: TODO
 * @author: cuihao
 * @create: 2020-02-24 18:43
 * @version: V1.0
 **/
@RestController
@RequestMapping("/log")
@CrossOrigin(origins = "*", maxAge = 3600)
public class LoggerController {

    @Autowired
    private LoggerService loggerService;

    @PostMapping("/showLoggers")
    public Result showLoggers(Integer currentPage, Integer pageSize) {
        Map<String, Object> map = loggerService.showLoggers(currentPage, pageSize);
        if (null == map) {
            return ResultUtil.failure(3001);
        }
        return ResultUtil.success(map);
    }


}
