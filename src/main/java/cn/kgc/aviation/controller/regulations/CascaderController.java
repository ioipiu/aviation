package cn.kgc.aviation.controller.regulations;

import cn.kgc.aviation.api.regulations.CascaderApi;
import cn.kgc.aviation.model.dto.DirectoryDto;
import cn.kgc.aviation.model.dto.Options;
import cn.kgc.aviation.model.dto.Result;
import cn.kgc.aviation.model.dto.vo.RegulationsVo;
import cn.kgc.aviation.service.regulations.CascaderService;
import cn.kgc.aviation.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: aviation
 * @description: TODO
 * @author: cuihao
 * @create: 2020-02-13 10:08
 * @version: V1.0
 **/
@RestController
@RequestMapping("/cascader")
@CrossOrigin(origins = "*", maxAge = 3600)
public class CascaderController implements CascaderApi {
    @Autowired
    private CascaderService cascaderService;
    private static Logger logger = LoggerFactory.getLogger(CascaderController.class);

    @Override
    @RequestMapping("/showOptions")
    public Result showOptions() {
        List<Options> options = cascaderService.showOptions();
        logger.info("访问了CascaderController -> showOptions");
        if (options.size() == 0) {
            return ResultUtil.failure(3001);
        }
        return ResultUtil.success(options);
    }

    @Override
    @RequestMapping("/showDire")
    public Result showDire() {
        List<DirectoryDto> directoryDtos = cascaderService.showDirOptions();
        logger.info("访问了CascaderController -> showDire");
        if (directoryDtos.size() == 0) {
            return ResultUtil.failure(3001);
        }
        return ResultUtil.success(directoryDtos);

    }

    @Override
    @PostMapping("/getDir")
    public Result getDir(Integer rid) {
        List<DirectoryDto> directoryDtos = cascaderService.getDire(rid);
        logger.info("访问了CascaderController -> getDir");
        if (directoryDtos.size() == 0) {
            return ResultUtil.failure(3001);
        }
        return ResultUtil.success(directoryDtos);
    }

    @Override
    @RequestMapping("/getAllReg")
    public Result getReg() {
        List<RegulationsVo> list = cascaderService.getAllReg();
        logger.info("访问了CascaderController -> getReg");
        if (list.size() == 0) {
            return ResultUtil.failure(3001);
        }
        return ResultUtil.success(list);
    }

    @Override
    @PostMapping("/delDir")
    public Result delDir(Integer rid, Integer did) throws Exception {
        Boolean flag = cascaderService.delDir(rid, did);
        logger.info("访问了CascaderController -> delDir");
        if (!flag) {
            return ResultUtil.failure(3001);
        }
        return ResultUtil.success("删除成功");
    }
}
