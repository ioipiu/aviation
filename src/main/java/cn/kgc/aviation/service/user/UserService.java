package cn.kgc.aviation.service.user;


import cn.kgc.aviation.model.entity.Users;

import java.util.Map;

public interface UserService {

    Map<String, Object> showUsers(Integer currentPage, Integer pageSize);

    Boolean updateUser(Users users);

    Map<String, Object> showCons(Integer currentPage, Integer pageSize);

    Boolean delCon(String zid);

}
