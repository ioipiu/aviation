package cn.kgc.aviation.utils;

import cn.kgc.aviation.model.dto.Result;

/**
 * @program: aviation
 * @description: TODO
 * @author: cuihao
 * @create: 2020-02-11 15:45
 * @version: V1.0
 **/
public class ResultUtil {

    public static Result success(Object object) {
        Result result = new Result();
        result.setCode(2001);
        result.setMessage("成功");
        result.setData(object);
        return result;
    }

    public static Result failure(Integer code) {
        Result result = new Result();
        result.setCode(code);
        result.setMessage("失败");
        return result;
    }
}
