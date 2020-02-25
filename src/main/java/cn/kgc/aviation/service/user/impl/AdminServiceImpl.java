package cn.kgc.aviation.service.user.impl;

import cn.kgc.aviation.config.Logger;
import cn.kgc.aviation.dao.user.AdminDao;
import cn.kgc.aviation.model.entity.Admin;
import cn.kgc.aviation.service.user.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: aviation
 * @description: TODO
 * @author: cuihao
 * @create: 2020-02-11 15:22
 * @version: V1.0
 **/
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDao adminDao;


    @Override
    public Admin login(String mobile, String passWord) {
        return adminDao.login(mobile, passWord);
    }

    @Override
    public Map<String,Object> showAdmin(Integer currentPage, Integer pageSize) {
        HashMap<String, Object> map = new HashMap<>();
        Integer start = (currentPage - 1) * pageSize;
        Integer total = adminDao.getTotal();
        if (total == 0) {
            return null;
        }
        List<Admin> admins = adminDao.showAdmin(start, pageSize);
        map.put("total", total);
        map.put("tableData", admins);
        return map;
    }

    @Override
    public Boolean findMobile(String mobile) {
        int i = adminDao.findMobile(mobile);
        if (i == 0) {
            return true;
        }
        return false;
    }

    @Logger("添加子管理员")
    @Override
    public Boolean addAdmin(String mobile, String aname, String passWord) {
        int i = adminDao.addAdmin(mobile, aname, passWord);
        if (i > 0) {
            return true;
        }
        return false;
    }

    @Logger("删除子管理员")
    @Override
    public Boolean delAdmin(Integer aid) {
        int i = adminDao.delAdmin(aid);
        if (i > 0) {
            return true;
        }
        return false;
    }

    @Logger("修改子管理员")
    @Override
    public Boolean updateAdmin(Integer aid, String aname, String passWord) {
        int i = adminDao.updateAdmin(aid, aname, passWord);
        if (i > 0) {
            return true;
        }
        return false;
    }
}
