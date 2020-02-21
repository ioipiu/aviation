package cn.kgc.aviation.controller.regulations;

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
public class RegController {

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

    @RequestMapping("/type")
    public Result showType() {
        List<RegulationsType> regulationsTypes = regService.showType();
        if (regulationsTypes.size() == 0) {
            return ResultUtil.failure(3001);
        }
        return ResultUtil.success(regulationsTypes);
    }

    @PostMapping("/addType")
    public Result addType(String typeName) {
        Boolean flag = regService.addType(typeName);
        if (!flag) {
            return ResultUtil.failure(3001);
        }
        return ResultUtil.success("添加成功");
    }

    @PostMapping("/showClassify")
    public Result showClassify(Integer typeId) {
        List<RegulationsClassify> list = regService.showClassify(typeId);
        if (list.size() == 0) {
            return ResultUtil.failure(3001);
        }
        return ResultUtil.success(list);
    }

    @PostMapping("/addClassify")
    public Result addClassify(Integer typeId, String classifyName) {
        Boolean flag = regService.addClassify(typeId, classifyName);
        if (!flag) {
            return ResultUtil.failure(3001);
        }
        return ResultUtil.success("添加成功");
    }

    @PostMapping("/updateClassify")
    public Result updateClassify(@RequestBody RegulationsClassify regulationsClassify) {
        Boolean flag = regService.updateClassify(regulationsClassify);
        if (!flag) {
            return ResultUtil.failure(3001);
        }
        return ResultUtil.success("修改成功");
    }

    @PostMapping("/delClassify")
    public Result delClassify(Integer classifyId) throws Exception {
        Boolean flag = regService.delClassify(classifyId);
        if (!flag) {
            return ResultUtil.failure(3001);
        }
        return ResultUtil.success("删除成功");
    }

    @PostMapping("/getAll")
    public Result getAll(Integer currentPage, Integer pageSize) {
        Map<String, Object> map = regService.getAllReg(currentPage, pageSize);
        if (null == map) {
            return ResultUtil.failure(3001);
        }
        return ResultUtil.success(map);
    }

    @PostMapping("/delReg")
    public Result delReg(Integer rid) throws Exception {
        Boolean flag = regService.delReg(rid);
        if (!flag) {
            return ResultUtil.failure(3001);
        }
        return ResultUtil.success("删除成功");
    }

    @PostMapping("/getRegById")
    public Result getRegById(Integer rid) {
        HashMap<String, Object> map = new HashMap<>();
        Regulations regulations = regService.getRegById(rid);
        if (null == regulations) {
            return ResultUtil.failure(3001);
        }
        List<Options> options = cascaderService.showOptions();
        map.put("reg", regulations);
        map.put("options", options);
        return ResultUtil.success(map);
    }

    @PostMapping("/updateReg")
    public Result updateReg(@RequestBody Regulations regulations) {
        Boolean flag = regService.updateReg(regulations);
        if (!flag) {
            return ResultUtil.failure(3001);
        }
        return ResultUtil.success("修改成功");
    }

    @PostMapping("/addReg")
    public Result addReg(@RequestBody Regulations regulations) {
        Boolean flag = regService.addReg(regulations);
        if (!flag) {
            return ResultUtil.failure(3001);
        }
        return ResultUtil.success("添加成功");
    }

    @RequestMapping("/getToken")
    public Result getToken() {
        HashMap<String, Object> map = new HashMap<>();
        Auth auth = qiniu.auth();
        String token = auth.uploadToken(bucket);
        map.put("token", token);
        map.put("host", host);
        return ResultUtil.success(map);
    }

    @PostMapping("/delType")
    public Result delType(Integer typeId) throws Exception {
        Boolean flag = regService.delType(typeId);
        if (!flag) {
            return ResultUtil.failure(3001);
        }
        return ResultUtil.success("删除成功");
    }

    @PostMapping("/getRegsByTypeId")
    public Result getRegsByTypeId(Integer typeId) {
        List<RegulationsClassify> regs = regService.getRegsByTypeId(typeId);
        if (regs.size() == 0) {
            return ResultUtil.failure(3001);
        }
        return ResultUtil.success(regs);
    }
}
