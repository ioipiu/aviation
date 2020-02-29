package cn.kgc.aviation.service.user.impl;

import cn.kgc.aviation.config.Logger;
import cn.kgc.aviation.dao.user.UserDao;
import cn.kgc.aviation.model.entity.Consulting;
import cn.kgc.aviation.model.entity.Users;
import cn.kgc.aviation.service.user.UserService;
import cn.kgc.aviation.utils.IDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: aviation
 * @description: TODO
 * @author: cuihao
 * @create: 2020-02-14 14:23
 * @version: V1.0
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public Map<String, Object> showUsers(Integer currentPage, Integer pageSize) {
        HashMap<String, Object> map = new HashMap<>();
        Integer start = (currentPage - 1) * pageSize;
        Integer total = userDao.getTotal();
        if (total == 0) {
            return null;
        }
        List<Users> users = userDao.showUsers(start, pageSize);
        map.put("total",total);
        map.put("tableData",users);
        return map;
    }

    @Logger("修改用户状态")
    @Override
    public Boolean updateUser(Users users) {
        int i = userDao.updateUser(users);
        if (i > 0) {
            return true;
        }
        return false;
    }

    @Override
    public Map<String, Object> showCons(Integer currentPage, Integer pageSize) {
        HashMap<String, Object> map = new HashMap<>();
        Integer start = (currentPage - 1) * pageSize;
        Integer total = userDao.getConTotal();
        if (total == 0) {
            return null;
        }
        List<Consulting> list = userDao.showCons(start, pageSize);
        map.put("total",total);
        map.put("tableData",list);
        return map;
    }

    @Logger("删除咨询")
    @Override
    public Boolean delCon(String zid) {
        int i = userDao.delCon(zid);
        if (i > 0) {
            return true;
        }
        return false;
    }

    @Override
    public Users login(String mobile, String password) {
        return userDao.login(mobile, password);
    }

    @Override
    public Boolean register(Users users) {
        users.setUid(IDGenerator.getID());
        int i = userDao.register(users);
        if (i > 0) {
            return true;
        }
        return false;
    }

    @Override
    public Boolean addConsulting(Consulting consulting) {
        consulting.setZid(IDGenerator.getID());
        int i = userDao.addConsulting(consulting);
        if (i > 0) {
            return true;
        }
        return false;
    }

    @Override
    public List<Consulting> getConByUid(String uid) {
        return userDao.getConByUid(uid);
    }

    @Override
    public Boolean changePwd(String oldPwd, String newPwd, String uid) {
        int i = userDao.changePwd(oldPwd, newPwd, uid);
        if (i > 0) {
            return true;
        }
        return false;
    }


}
