package cn.kgc.aviation.controller.user;

import cn.kgc.aviation.model.dto.Result;
import cn.kgc.aviation.model.entity.Admin;
import cn.kgc.aviation.service.user.AdminService;
import cn.kgc.aviation.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        Admin admin = adminService.login(mobile, passWord);
        if (null == admin) {
            return ResultUtil.failure(3001);
        }
        return ResultUtil.success(admin);
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
}
