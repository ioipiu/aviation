package cn.kgc.aviation.controller.user;

import cn.kgc.aviation.model.dto.Result;
import cn.kgc.aviation.model.entity.Consulting;
import cn.kgc.aviation.model.entity.Users;
import cn.kgc.aviation.service.user.UserService;
import cn.kgc.aviation.utils.ResultUtil;
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
public class UserController {

    @Autowired
    public UserService userService;

    @PostMapping("/getUsers")
    public Result showUsers(Integer currentPage, Integer pageSize) {
        Map<String, Object> map = userService.showUsers(currentPage, pageSize);
        if (null == map) {
            return ResultUtil.failure(3001);
        }
        return ResultUtil.success(map);
    }

    @PostMapping("/update")
    public Result updateUser(@RequestBody Users users) {
        Boolean flag = userService.updateUser(users);
        if (!flag) {
            return ResultUtil.failure(3001);
        }
        return ResultUtil.success("修改成功");
    }

    @PostMapping("/getCons")
    public Result showCons(Integer currentPage, Integer pageSize) {
        Map<String, Object> map = userService.showCons(currentPage, pageSize);
        if (null == map) {
            return ResultUtil.failure(3001);
        }
        return ResultUtil.success(map);
    }

    @PostMapping("/delCon")
    public Result delCon(String zid) {
        Boolean flag = userService.delCon(zid);
        if (!flag) {
            return ResultUtil.failure(3001);
        }
        return ResultUtil.success("删除成功");
    }

    @PostMapping("/login")
    public Result login(String mobile, String password) {
        Users users = userService.login(mobile, password);
        if (null == users) {
            return ResultUtil.failure(3001);
        }
        return ResultUtil.success(users);
    }

    @PostMapping("/register")
    public Result register(Users users) {
        Boolean flag = userService.register(users);
        if (!flag) {
            return ResultUtil.failure(3001);
        }
        return ResultUtil.success("注册成功");
    }

    @PostMapping("/addCon")
    public Result addCon(@RequestBody Consulting consulting) {
        Boolean flag = userService.addConsulting(consulting);
        if (!flag) {
            return ResultUtil.failure(3001);
        }
        return ResultUtil.success("提交成功");
    }

    @PostMapping("/getConByUid")
    public Result getConByUid(String uid) {
        List<Consulting> consultingList = userService.getConByUid(uid);
        if (consultingList.size() == 0) {
            return ResultUtil.failure(3001);
        }
        return ResultUtil.success(consultingList);
    }
}
