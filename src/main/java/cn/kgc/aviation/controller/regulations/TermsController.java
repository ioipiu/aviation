package cn.kgc.aviation.controller.regulations;

import cn.kgc.aviation.api.regulations.TermsApi;
import cn.kgc.aviation.model.dto.Result;
import cn.kgc.aviation.model.entity.Terms;
import cn.kgc.aviation.service.regulations.TermsService;
import cn.kgc.aviation.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
public class TermsController implements TermsApi {

    @Autowired
    private TermsService termsService;
    private static Logger logger = LoggerFactory.getLogger(TermsController.class);

    @Override
    @PostMapping("/getTerms")
    public Result getTerms(Integer rid, Integer currentPage, Integer pageSize) {
        Map<String, Object> map = termsService.getTerms(rid, currentPage, pageSize);
        logger.info("访问了TermsController -> getTerms");
        if (null == map) {
            return ResultUtil.failure(3001);
        }
        return ResultUtil.success(map);
    }

    @Override
    @PostMapping("/getTermsById")
    public Result getTermsById(Integer tid) {
        Terms terms = termsService.getTermsById(tid);
        logger.info("访问了TermsController -> getTermsById");
        if (null == terms) {
            return ResultUtil.failure(3001);
        }
        return ResultUtil.success(terms);
    }

    @Override
    @PostMapping("/delTerms")
    public Result delTerms(Integer tid) throws Exception {
        Boolean flag = termsService.delTerms(tid);
        logger.info("访问了TermsController -> delTerms");
        if (!flag) {
            return ResultUtil.failure(3001);
        }
        return ResultUtil.success("删除成功");
    }

    @Override
    @PostMapping("/updateTerms")
    public Result updateTerms(@RequestBody Terms terms) {
        Boolean flag = termsService.updateTerms(terms);
        logger.info("访问了TermsController -> updateTerms");
        if (!flag) {
            return ResultUtil.failure(3001);
        }
        return ResultUtil.success("修改成功");
    }

    @Override
    @PostMapping("/addTerms")
    public Result addTerms(@RequestBody Terms terms) {
        Boolean flag = termsService.addTerms(terms);
        logger.info("访问了TermsController -> addTerms");
        if (!flag) {
            return ResultUtil.failure(3001);
        }
        return ResultUtil.success("添加成功");
    }

    @Override
    @PostMapping("/getTermsByDid")
    public Result getTermsByDid(Integer did) {
        List<Terms> termsList = termsService.getTermsByDid(did);
        logger.info("访问了TermsController -> getTermsByDid");
        if (termsList.size() == 0) {
            return ResultUtil.failure(3001);
        }
        return ResultUtil.success(termsList);
    }

    @Override
    @PostMapping("/getTermsByKeyWord")
    public Result getTermsByKeyWord(String keyWord) {
        List<Terms> termsList = termsService.getTermsByKeyWord(keyWord);
        if (termsList.size() == 0) {
            return ResultUtil.failure(3001);
        }
        return ResultUtil.success(termsList);
    }
}
