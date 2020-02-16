package cn.kgc.aviation.controller.setup;

import cn.kgc.aviation.model.dto.Result;
import cn.kgc.aviation.model.entity.*;
import cn.kgc.aviation.service.setup.SetupService;
import cn.kgc.aviation.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @program: aviation
 * @description: TODO
 * @author: cuihao
 * @create: 2020-02-15 10:16
 * @version: V1.0
 **/
@RestController
@RequestMapping("/setup")
@CrossOrigin(origins = "*", maxAge = 3600)
public class SetupController {
    @Autowired
    private SetupService setupService;

    @RequestMapping("/getIntro")
    public Result getIntro() {
        Introduction intro = setupService.getIntro();
        if (null == intro) {
            return ResultUtil.failure(3001);
        }
        return ResultUtil.success(intro);
    }

    @PostMapping("/updateIntro")
    public Result updateIntro(Integer id, String desc) {
        Boolean flag = setupService.updateIntro(id, desc);
        if (!flag) {
            return ResultUtil.failure(3001);
        }
        return ResultUtil.success("修改成功");
    }

    @RequestMapping("/getAgree")
    public Result getAgree() {
        Agreement agree = setupService.getAgree();
        if (null == agree) {
            return ResultUtil.failure(3001);
        }
        return ResultUtil.success(agree);
    }

    @PostMapping("/updateAgree")
    public Result updateAgree(Integer id, String content) {
        Boolean flag = setupService.updateAgree(id, content);
        if (!flag) {
            return ResultUtil.failure(3001);
        }
        return ResultUtil.success("修改成功");
    }

    @RequestMapping("/getSmtp")
    public Result getSmtp() {
        Smtp smtp = setupService.getSmtp();
        if (null == smtp) {
            return ResultUtil.failure(3001);
        }
        return ResultUtil.success(smtp);
    }

    @PostMapping("/updateSmtp")
    public Result updateSmtp(@RequestBody Smtp smtp) {
        Boolean flag = setupService.updateSmtp(smtp);
        if (!flag) {
            return ResultUtil.failure(3001);
        }
        return ResultUtil.success("修改成功");
    }

    @RequestMapping("/getSms")
    public Result getSms() {
        Sms sms = setupService.getSms();
        if (null == sms) {
            return ResultUtil.failure(3001);
        }
        return ResultUtil.success(sms);
    }

    @PostMapping("/updateSms")
    public Result updateSms(Integer id, String apiKey) {
        Boolean flag = setupService.updateSms(id, apiKey);
        if (!flag) {
            return ResultUtil.failure(3001);
        }
        return ResultUtil.success("修改成功");
    }

    @PostMapping("/showFeedback")
    public Result showFeedback(Integer currentPage, Integer pageSize) {
        Map<String, Object> map = setupService.showFeedback(currentPage, pageSize);
        if (null == map) {
            return ResultUtil.failure(3001);
        }
        return ResultUtil.success(map);
    }

    @PostMapping("/delFeedback")
    public Result delFeedback(String fid) {
        Boolean flag = setupService.delFeedback(fid);
        if (!flag) {
            return ResultUtil.failure(3001);
        }
        return ResultUtil.success("删除成功");
    }

    @RequestMapping("/getWebSet")
    public Result getWebSet() {
        Websettings webSet = setupService.getWebSet();
        if (null == webSet) {
            return ResultUtil.failure(3001);
        }
        return ResultUtil.success(webSet);
    }

    @PostMapping("/updateWebSet")
    public Result updateWebSet(@RequestBody Websettings websettings) {
        Boolean flag = setupService.updateWebSet(websettings);
        if (!flag) {
            return ResultUtil.failure(3001);
        }
        return ResultUtil.success("修改成功");
    }
}
