package cn.kgc.aviation.controller.user;

import cn.kgc.aviation.model.dto.Result;
import cn.kgc.aviation.model.entity.Admin;
import cn.kgc.aviation.model.entity.Info;
import cn.kgc.aviation.service.user.AdminService;
import cn.kgc.aviation.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @program: aviation
 * @description: TODO
 * @author: cuihao
 * @create: 2020-02-11 15:22
 * @version: V1.0
 **/
@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "*", maxAge = 3600)
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/login")
    public Result login(String mobile, String passWord) {
        Result result = new Result();
        Admin admin = adminService.login(mobile, passWord);
        if (null == admin) {
            result.setCode(60204);
            result.setMessage("账号或者密码错误");
            return result;
        }
        if (admin.getType() == 0) {
            result.setCode(20000);
            result.setData("admin-token");
        }else {
            result.setCode(20000);
            result.setData("editor-token");
        }
        return result;
    }

    @PostMapping("/showAdmin")
    public Result showAdmin(Integer currentPage, Integer pageSize) {
        Map<String, Object> map = adminService.showAdmin(currentPage, pageSize);
        if (null == map) {
            return ResultUtil.failure(3001);
        }
        return ResultUtil.success(map);
    }

    @PostMapping("/findMobile")
    public Result findMobile(String mobile) {
        Boolean flag = adminService.findMobile(mobile);
        if (!flag) {
            return ResultUtil.failure(3001);
        }
        return ResultUtil.success("手机号可以添加");
    }

    @PostMapping("/addAdmin")
    public Result addAdmin(String mobile, String aname, String passWord) {
        Boolean flag = adminService.addAdmin(mobile, aname, passWord);
        if (!flag) {
            return ResultUtil.failure(3001);
        }
        return ResultUtil.success("添加成功");
    }

    @PostMapping("/delAdmin")
    public Result delAdmin(Integer aid) {
        Boolean flag = adminService.delAdmin(aid);
        if (!flag) {
            return ResultUtil.failure(3001);
        }
        return ResultUtil.success("删除成功");
    }

    @PostMapping("/updateAdmin")
    public Result updateAdmin(Integer aid, String aname, String passWord) {
        Boolean flag = adminService.updateAdmin(aid, aname, passWord);
        if (!flag) {
            return ResultUtil.failure(3001);
        }
        return ResultUtil.success("修改成功");
    }

    @RequestMapping("/getInfo")
    public Result getInfo(@RequestParam("token") String token) {
        Info info = new Info();
        Result result = new Result();
        if (token.equals("admin-token")) {
            info.setRoles("['admin']");
            info.setIntroduction("I am a super administrator");
            info.setAvatar("https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
            info.setName("超级管理员");
        }
        if (token.equals("editor-token")) {
            info.setRoles("['editor']");
            info.setIntroduction("I am an editor");
            info.setAvatar("https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
            info.setName("子管理员");
        }
        result.setCode(20000);
        result.setData(info);
        return result;
    }

    @PostMapping("/logout")
    public Result logout() {
        Result result = new Result();
        result.setCode(20000);
        result.setData("success");
        return  result;
    }
}
