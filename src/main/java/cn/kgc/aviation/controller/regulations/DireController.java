package cn.kgc.aviation.controller.regulations;

import cn.kgc.aviation.model.dto.Result;
import cn.kgc.aviation.model.entity.Directory;
import cn.kgc.aviation.service.regulations.DireService;
import cn.kgc.aviation.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @program: aviation
 * @description: TODO
 * @author: cuihao
 * @create: 2020-02-13 20:35
 * @version: V1.0
 **/
@RestController
@RequestMapping("/dir")
@CrossOrigin(origins = "*", maxAge = 3600)
public class DireController {

    @Autowired
    private DireService direService;

    @PostMapping("/addDir")
    public Result addDir(@RequestBody Directory directory) {
        Boolean flag = direService.addDir(directory);
        if (!flag) {
            return ResultUtil.failure(3001);
        }
        return ResultUtil.success("添加成功");
    }
}
