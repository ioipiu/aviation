package cn.kgc.aviation.controller.regulations;

import cn.kgc.aviation.model.dto.Result;
import cn.kgc.aviation.model.entity.Terms;
import cn.kgc.aviation.service.regulations.TermsService;
import cn.kgc.aviation.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @program: aviation
 * @description: TODO
 * @author: cuihao
 * @create: 2020-02-16 13:01
 * @version: V1.0
 **/
@RestController
@RequestMapping("/term")
@CrossOrigin(origins = "*", maxAge = 3600)
public class TermsController {

    @Autowired
    private TermsService termsService;

    @PostMapping("/getTerms")
    public Result getTerms(Integer rid, Integer currentPage, Integer pageSize) {
        Map<String, Object> map = termsService.getTerms(rid, currentPage, pageSize);
        if (null == map) {
            return ResultUtil.failure(3001);
        }
        return ResultUtil.success(map);
    }

    @PostMapping("/getTermsById")
    public Result getTermsById(Integer tid) {
        Terms terms = termsService.getTermsById(tid);
        if (null == terms) {
            return ResultUtil.failure(3001);
        }
        return ResultUtil.success(terms);
    }

    @PostMapping("/delTerms")
    public Result delTerms(Integer tid) {
        Boolean flag = termsService.delTerms(tid);
        if (!flag) {
            return ResultUtil.failure(3001);
        }
        return ResultUtil.success("删除成功");
    }

    @PostMapping("/updateTerms")
    public Result updateTerms(@RequestBody Terms terms) {
        Boolean flag = termsService.updateTerms(terms);
        if (!flag) {
            return ResultUtil.failure(3001);
        }
        return ResultUtil.success("修改成功");
    }

    @PostMapping("/addTerms")
    public Result addTerms(@RequestBody Terms terms) {
        Boolean flag = termsService.addTerms(terms);
        if (!flag) {
            return ResultUtil.failure(3001);
        }
        return ResultUtil.success("添加成功");
    }
}
