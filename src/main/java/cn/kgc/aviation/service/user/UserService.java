package cn.kgc.aviation.service.user;


import cn.kgc.aviation.model.entity.Consulting;
import cn.kgc.aviation.model.entity.Users;

import java.util.List;
import java.util.Map;

public interface UserService {

    Map<String, Object> showUsers(Integer currentPage, Integer pageSize);

    Boolean updateUser(Users users);

    Map<String, Object> showCons(Integer currentPage, Integer pageSize);

    Boolean delCon(String zid);

    Users login(String mobile, String password);

    Boolean register(Users users);

    Boolean addConsulting(Consulting consulting);

    List<Consulting> getConByUid(String uid);

    Boolean changePwd(String oldPwd, String newPwd, String uid);

}
