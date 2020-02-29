package cn.kgc.aviation.controller.collect;

import cn.kgc.aviation.api.collect.CollectApi;
import cn.kgc.aviation.model.dto.Result;
import cn.kgc.aviation.model.entity.Collect;
import cn.kgc.aviation.service.collect.CollectService;
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
 * @create: 2020-02-22 14:14
 * @version: V1.0
 **/
@RestController
@RequestMapping("/coll")
@CrossOrigin(origins = "*", maxAge = 3600)
public class CollectController implements CollectApi {

    @Autowired
    private CollectService collectService;
    private static Logger logger = LoggerFactory.getLogger(CollectController.class);

    @Override
    @PostMapping("/getCollectionByUid")
    public Result getCollectionByUid(String uid) {
        List<Collect> collectList = collectService.getCollectionByUid(uid);
        logger.info("访问了CollectController -> getCollectionByUid");
        if (collectList.size() == 0) {
            return ResultUtil.failure(3001);
        }
        return ResultUtil.success(collectList);
    }

    @Override
    @PostMapping("/getAllCollection")
    public Result getAllCollection(String uid) {
        List<Collect> collectList = collectService.getAllCollection(uid);
        logger.info("访问了CollectController -> getAllCollection");
        if (collectList.size() == 0) {
            return ResultUtil.failure(3001);
        }
        return ResultUtil.success(collectList);
    }

    @Override
    @PostMapping("/getCollectionByCid")
    public Result getCollectionByCid(Integer cid) {
        Collect collect = collectService.getCollectionByCid(cid);
        logger.info("访问了CollectController -> getCollectionByCid");
        if (null == collect) {
            return ResultUtil.failure(3001);
        }
        return ResultUtil.success(collect);
    }

    @Override
    @PostMapping("/addCollection")
    public Result addCollection(String uid, Integer tid) {
        Boolean flag = collectService.addCollection(uid, tid);
        logger.info("访问了CollectController -> addCollection");
        if (!flag) {
            return ResultUtil.failure(3001);
        }
        return ResultUtil.success("添加成功");
    }

    @Override
    @PostMapping("/delCollection")
    public Result delCollection(Integer cid) {
        Boolean flag = collectService.delCollection(cid);
        logger.info("访问了CollectController -> delCollection");
        if (!flag) {
            return ResultUtil.failure(3001);
        }
        return ResultUtil.success("删除成功");
    }

    @Override
    @PostMapping("/getCollect")
    public Result getCollect(String uid, Integer tid) {
        Collect collect = collectService.getCollect(uid, tid);
        logger.info("访问了CollectController -> getCollect");
        if (null == collect) {
            return ResultUtil.failure(3001);
        }
        return ResultUtil.success(collect);
    }


}
