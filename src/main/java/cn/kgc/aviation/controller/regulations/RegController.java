package cn.kgc.aviation.controller.regulations;

import cn.kgc.aviation.api.regulations.RegApi;
import cn.kgc.aviation.config.QNConfig;
import cn.kgc.aviation.model.dto.Options;
import cn.kgc.aviation.model.dto.Result;
import cn.kgc.aviation.model.entity.Regulations;
import cn.kgc.aviation.model.entity.RegulationsClassify;
import cn.kgc.aviation.model.entity.RegulationsType;
import cn.kgc.aviation.service.regulations.CascaderService;
import cn.kgc.aviation.service.regulations.RegService;
import cn.kgc.aviation.utils.ResultUtil;
import com.qiniu.util.Auth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: aviation
 * @description: TODO
 * @author: cuihao
 * @create: 2020-02-11 18:41
 * @version: V1.0
 **/
@RestController
@RequestMapping("/reg")
@CrossOrigin(origins = "*", maxAge = 3600)
public class RegController implements RegApi {

    private static Logger logger = LoggerFactory.getLogger(RegController.class);
    @Autowired
    private RegService regService;

    @Autowired
    private CascaderService cascaderService;

    @Autowired
    private QNConfig qiniu;

    @Value("${qiniu.Bucket}")
    private String bucket;

    @Value("${qiniu.path}")
    private String host;

    @Override
    @RequestMapping("/type")
    public Result showType() {
        List<RegulationsType> regulationsTypes = regService.showType();
        logger.info("访问了RegController -> showType");
        if (regulationsTypes.size() == 0) {
            return ResultUtil.failure(3001);
        }
        return ResultUtil.success(regulationsTypes);
    }

    @Override
    @PostMapping("/addType")
    public Result addType(String typeName) {
        Boolean flag = regService.addType(typeName);
        logger.info("访问了RegController -> addType");
        if (!flag) {
            return ResultUtil.failure(3001);
        }
        return ResultUtil.success("添加成功");
    }

    @Override
    @PostMapping("/showClassify")
    public Result showClassify(Integer typeId) {
        List<RegulationsClassify> list = regService.showClassify(typeId);
        logger.info("访问了RegController -> showClassify");
        if (list.size() == 0) {
            return ResultUtil.failure(3001);
        }
        return ResultUtil.success(list);
    }

    @Override
    @PostMapping("/addClassify")
    public Result addClassify(Integer typeId, String classifyName) {
        Boolean flag = regService.addClassify(typeId, classifyName);
        logger.info("访问了RegController -> addClassify");
        if (!flag) {
            return ResultUtil.failure(3001);
        }
        return ResultUtil.success("添加成功");
    }

    @Override
    @PostMapping("/updateClassify")
    public Result updateClassify(@RequestBody RegulationsClassify regulationsClassify) {
        Boolean flag = regService.updateClassify(regulationsClassify);
        logger.info("访问了RegController -> updateClassify");
        if (!flag) {
            return ResultUtil.failure(3001);
        }
        return ResultUtil.success("修改成功");
    }

    @Override
    @PostMapping("/delClassify")
    public Result delClassify(Integer classifyId) throws Exception {
        Boolean flag = regService.delClassify(classifyId);
        logger.info("访问了RegController -> delClassify");
        if (!flag) {
            return ResultUtil.failure(3001);
        }
        return ResultUtil.success("删除成功");
    }

    @Override
    @PostMapping("/getAll")
    public Result getAll(Integer currentPage, Integer pageSize) {
        Map<String, Object> map = regService.getAllReg(currentPage, pageSize);
        logger.info("访问了RegController -> getAll");
        if (null == map) {
            return ResultUtil.failure(3001);
        }
        return ResultUtil.success(map);
    }

    @Override
    @PostMapping("/delReg")
    public Result delReg(Integer rid) throws Exception {
        Boolean flag = regService.delReg(rid);
        logger.info("访问了RegController -> delReg");
        if (!flag) {
            return ResultUtil.failure(3001);
        }
        return ResultUtil.success("删除成功");
    }

    @Override
    @PostMapping("/getRegById")
    public Result getRegById(Integer rid) {
        HashMap<String, Object> map = new HashMap<>();
        Regulations regulations = regService.getRegById(rid);
        logger.info("访问了RegController -> getRegById");
        if (null == regulations) {
            return ResultUtil.failure(3001);
        }
        List<Options> options = cascaderService.showOptions();
        map.put("reg", regulations);
        map.put("options", options);
        return ResultUtil.success(map);
    }

    @Override
    @PostMapping("/updateReg")
    public Result updateReg(@RequestBody Regulations regulations) {
        Boolean flag = regService.updateReg(regulations);
        logger.info("访问了RegController -> updateReg");
        if (!flag) {
            return ResultUtil.failure(3001);
        }
        return ResultUtil.success("修改成功");
    }

    @Override
    @PostMapping("/addReg")
    public Result addReg(@RequestBody Regulations regulations) {
        Boolean flag = regService.addReg(regulations);
        logger.info("访问了RegController -> addReg");
        if (!flag) {
            return ResultUtil.failure(3001);
        }
        return ResultUtil.success("添加成功");
    }

    @Override
    @RequestMapping("/getToken")
    public Result getToken() {
        logger.info("访问了RegController -> getToken");
        HashMap<String, Object> map = new HashMap<>();
        Auth auth = qiniu.auth();
        String token = auth.uploadToken(bucket);
        map.put("token", token);
        map.put("host", host);
        return ResultUtil.success(map);
    }

    @Override
    @PostMapping("/delType")
    public Result delType(Integer typeId) throws Exception {
        Boolean flag = regService.delType(typeId);
        logger.info("访问了RegController -> delType");
        if (!flag) {
            return ResultUtil.failure(3001);
        }
        return ResultUtil.success("删除成功");
    }

    @Override
    @PostMapping("/getRegsByTypeId")
    public Result getRegsByTypeId(Integer typeId) {
        List<RegulationsClassify> regs = regService.getRegsByTypeId(typeId);
        logger.info("访问了RegController -> getRegsByTypeId");
        if (regs.size() == 0) {
            return ResultUtil.failure(3001);
        }
        return ResultUtil.success(regs);
    }
}
