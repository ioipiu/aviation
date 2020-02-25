package cn.kgc.aviation.controller.setup;

import cn.kgc.aviation.model.dto.Result;
import cn.kgc.aviation.model.entity.*;
import cn.kgc.aviation.service.setup.SetupService;
import cn.kgc.aviation.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static Logger logger = LoggerFactory.getLogger(SetupController.class);

    @RequestMapping("/getIntro")
    public Result getIntro() {
        Introduction intro = setupService.getIntro();
        logger.info("访问了SetupController -> getIntro");
        if (null == intro) {
            return ResultUtil.failure(3001);
        }
        return ResultUtil.success(intro);
    }

    @PostMapping("/updateIntro")
    public Result updateIntro(Integer id, String desc) {
        Boolean flag = setupService.updateIntro(id, desc);
        logger.info("访问了SetupController -> updateIntro");
        if (!flag) {
            return ResultUtil.failure(3001);
        }
        return ResultUtil.success("修改成功");
    }

    @RequestMapping("/getAgree")
    public Result getAgree() {
        Agreement agree = setupService.getAgree();
        logger.info("访问了SetupController -> getAgree");
        if (null == agree) {
            return ResultUtil.failure(3001);
        }
        return ResultUtil.success(agree);
    }

    @PostMapping("/updateAgree")
    public Result updateAgree(Integer id, String content) {
        Boolean flag = setupService.updateAgree(id, content);
        logger.info("访问了SetupController -> updateAgree");
        if (!flag) {
            return ResultUtil.failure(3001);
        }
        return ResultUtil.success("修改成功");
    }

    @RequestMapping("/getSmtp")
    public Result getSmtp() {
        Smtp smtp = setupService.getSmtp();
        logger.info("访问了SetupController -> getSmtp");
        if (null == smtp) {
            return ResultUtil.failure(3001);
        }
        return ResultUtil.success(smtp);
    }

    @PostMapping("/updateSmtp")
    public Result updateSmtp(@RequestBody Smtp smtp) {
        Boolean flag = setupService.updateSmtp(smtp);
        logger.info("访问了SetupController -> updateSmtp");
        if (!flag) {
            return ResultUtil.failure(3001);
        }
        return ResultUtil.success("修改成功");
    }

    @RequestMapping("/getSms")
    public Result getSms() {
        Sms sms = setupService.getSms();
        logger.info("访问了SetupController -> getSms");
        if (null == sms) {
            return ResultUtil.failure(3001);
        }
        return ResultUtil.success(sms);
    }

    @PostMapping("/updateSms")
    public Result updateSms(Integer id, String apiKey) {
        Boolean flag = setupService.updateSms(id, apiKey);
        logger.info("访问了SetupController -> updateSms");
        if (!flag) {
            return ResultUtil.failure(3001);
        }
        return ResultUtil.success("修改成功");
    }

    @PostMapping("/showFeedback")
    public Result showFeedback(Integer currentPage, Integer pageSize) {
        Map<String, Object> map = setupService.showFeedback(currentPage, pageSize);
        logger.info("访问了SetupController -> showFeedback");
        if (null == map) {
            return ResultUtil.failure(3001);
        }
        return ResultUtil.success(map);
    }

    @PostMapping("/delFeedback")
    public Result delFeedback(String fid) {
        Boolean flag = setupService.delFeedback(fid);
        logger.info("访问了SetupController -> delFeedback");
        if (!flag) {
            return ResultUtil.failure(3001);
        }
        return ResultUtil.success("删除成功");
    }

    @RequestMapping("/getWebSet")
    public Result getWebSet() {
        Websettings webSet = setupService.getWebSet();
        logger.info("访问了SetupController -> getWebSet");
        if (null == webSet) {
            return ResultUtil.failure(3001);
        }
        return ResultUtil.success(webSet);
    }

    @PostMapping("/updateWebSet")
    public Result updateWebSet(@RequestBody Websettings websettings) {
        Boolean flag = setupService.updateWebSet(websettings);
        logger.info("访问了SetupController -> updateWebSet");
        if (!flag) {
            return ResultUtil.failure(3001);
        }
        return ResultUtil.success("修改成功");
    }

    @PostMapping("/addFeedback")
    public Result addFeedback(@RequestBody Feedback feedback) {
        Boolean flag = setupService.addFeedback(feedback);
        logger.info("访问了SetupController -> addFeedback");
        if (!flag) {
            return ResultUtil.failure(3001);
        }
        return ResultUtil.success("提交成功");
    }
}
