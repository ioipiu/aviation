package cn.kgc.aviation.controller.regulations;

import cn.kgc.aviation.model.dto.DirectoryDto;
import cn.kgc.aviation.model.dto.Options;
import cn.kgc.aviation.model.dto.Result;
import cn.kgc.aviation.model.dto.vo.RegulationsVo;
import cn.kgc.aviation.service.regulations.CascaderService;
import cn.kgc.aviation.utils.ResultUtil;
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
public class CascaderController {
    @Autowired
    private CascaderService cascaderService;

    @RequestMapping("/showOptions")
    public Result showOptions() {
        List<Options> options = cascaderService.showOptions();
        if (options.size() == 0) {
            return ResultUtil.failure(3001);
        }
        return ResultUtil.success(options);
    }

    @RequestMapping("/showDire")
    public Result showDire() {
        List<DirectoryDto> directoryDtos = cascaderService.showDirOptions();
        if (directoryDtos.size() == 0) {
            return ResultUtil.failure(3001);
        }
        return ResultUtil.success(directoryDtos);

    }

    @PostMapping("/getDir")
    public Result getDir(Integer rid) {
        List<DirectoryDto> directoryDtos = cascaderService.getDire(rid);
        if (directoryDtos.size() == 0) {
            return ResultUtil.failure(3001);
        }
        return ResultUtil.success(directoryDtos);
    }

    @RequestMapping("/getAllReg")
    public Result getReg() {
        List<RegulationsVo> list = cascaderService.getAllReg();
        if (list.size() == 0) {
            return ResultUtil.failure(3001);
        }
        return ResultUtil.success(list);
    }

    @PostMapping("/delDir")
    public Result delDir(Integer rid, Integer did) throws Exception {
        Boolean flag = cascaderService.delDir(rid, did);
        if (!flag) {
            return ResultUtil.failure(3001);
        }
        return ResultUtil.success("删除成功");
    }
}
