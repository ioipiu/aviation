package cn.kgc.aviation.controller.user;

import cn.kgc.aviation.api.user.UserApi;
import cn.kgc.aviation.model.dto.Result;
import cn.kgc.aviation.model.entity.Consulting;
import cn.kgc.aviation.model.entity.Users;
import cn.kgc.aviation.service.user.UserService;
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
 * @create: 2020-02-14 14:22
 * @version: V1.0
 **/
@RestController
@RequestMapping("/usr")
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserController implements UserApi {

    @Autowired
    public UserService userService;
    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Override
    @PostMapping("/getUsers")
    public Result showUsers(Integer currentPage, Integer pageSize) {
        Map<String, Object> map = userService.showUsers(currentPage, pageSize);
        logger.info("访问了UserController -> showUsers");
        if (null == map) {
            return ResultUtil.failure(3001);
        }
        return ResultUtil.success(map);
    }

    @Override
    @PostMapping("/update")
    public Result updateUser(@RequestBody Users users) {
        Boolean flag = userService.updateUser(users);
        logger.info("访问了UserController -> updateUser");
        if (!flag) {
            return ResultUtil.failure(3001);
        }
        return ResultUtil.success("修改成功");
    }

    @Override
    @PostMapping("/getCons")
    public Result showCons(Integer currentPage, Integer pageSize) {
        Map<String, Object> map = userService.showCons(currentPage, pageSize);
        logger.info("访问了UserController -> showCons");
        if (null == map) {
            return ResultUtil.failure(3001);
        }
        return ResultUtil.success(map);
    }

    @Override
    @PostMapping("/delCon")
    public Result delCon(String zid) {
        Boolean flag = userService.delCon(zid);
        logger.info("访问了UserController -> delCon");
        if (!flag) {
            return ResultUtil.failure(3001);
        }
        return ResultUtil.success("删除成功");
    }

    @Override
    @PostMapping("/login")
    public Result login(String mobile, String password) {
        Users users = userService.login(mobile, password);
        logger.info("访问了UserController -> login");
        if (null == users) {
            return ResultUtil.failure(3001);
        }
        return ResultUtil.success(users);
    }

    @Override
    @PostMapping("/register")
    public Result register(Users users) {
        Boolean flag = userService.register(users);
        logger.info("访问了UserController -> register");
        if (!flag) {
            return ResultUtil.failure(3001);
        }
        return ResultUtil.success("注册成功");
    }

    @Override
    @PostMapping("/changePwd")
    public Result changePwd(String oldPwd, String newPwd, String uid) {
        Boolean flag = userService.changePwd(oldPwd, newPwd, uid);
        if (!flag) {
            return ResultUtil.failure(3001);
        }
        return ResultUtil.success("修改成功");
    }

    @Override
    @PostMapping("/addCon")
    public Result addCon(Consulting consulting) {
        Boolean flag = userService.addConsulting(consulting);
        logger.info("访问了UserController -> addCon");
        if (!flag) {
            return ResultUtil.failure(3001);
        }
        return ResultUtil.success("提交成功");
    }

    @Override
    @PostMapping("/getConByUid")
    public Result getConByUid(String uid) {
        List<Consulting> consultingList = userService.getConByUid(uid);
        logger.info("访问了UserController -> getConByUid");
        if (consultingList.size() == 0) {
            return ResultUtil.failure(3001);
        }
        return ResultUtil.success(consultingList);
    }
}
