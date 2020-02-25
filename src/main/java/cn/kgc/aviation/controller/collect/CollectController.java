package cn.kgc.aviation.controller.collect;

import cn.kgc.aviation.model.dto.Result;
import cn.kgc.aviation.model.entity.Collect;
import cn.kgc.aviation.service.collect.CollectService;
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
 * @create: 2020-02-22 14:14
 * @version: V1.0
 **/
@RestController
@RequestMapping("/coll")
@CrossOrigin(origins = "*", maxAge = 3600)
public class CollectController {

    @Autowired
    private CollectService collectService;

    @PostMapping("/getCollectionByUid")
    public Result getCollectionByUid(String uid) {
        List<Collect> collectList = collectService.getCollectionByUid(uid);
        if (collectList.size() == 0) {
            return ResultUtil.failure(3001);
        }
        return ResultUtil.success(collectList);
    }

    @PostMapping("/getAllCollection")
    public Result getAllCollection(String uid) {
        List<Collect> collectList = collectService.getAllCollection(uid);
        if (collectList.size() == 0) {
            return ResultUtil.failure(3001);
        }
        return ResultUtil.success(collectList);
    }

    @PostMapping("/getCollectionByCid")
    public Result getCollectionByCid(Integer cid) {
        Collect collect = collectService.getCollectionByCid(cid);
        if (null == collect) {
            return ResultUtil.failure(3001);
        }
        return ResultUtil.success(collect);
    }

    @PostMapping("/addCollection")
    public Result addCollection(String uid, Integer tid) {
        Boolean flag = collectService.addCollection(uid, tid);
        if (!flag) {
            return ResultUtil.failure(3001);
        }
        return ResultUtil.success("添加成功");
    }

    @PostMapping("/delCollection")
    public Result delCollection(Integer cid) {
        Boolean flag = collectService.delCollection(cid);
        if (!flag) {
            return ResultUtil.failure(3001);
        }
        return ResultUtil.success("删除成功");
    }

    @PostMapping("/getCollect")
    public Result getCollect(String uid, Integer tid) {
        Collect collect = collectService.getCollect(uid, tid);
        if (null == collect) {
            return ResultUtil.failure(3001);
        }
        return ResultUtil.success(collect);
    }

}
