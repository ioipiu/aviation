package cn.kgc.aviation.service.user;

import cn.kgc.aviation.model.entity.Admin;;
import java.util.Map;

public interface AdminService {

    Admin login(String mobile, String passWord);

    Map<String, Object> showAdmin(Integer currentPage, Integer pageSize);

    Boolean findMobile(String mobile);

    Boolean addAdmin(String mobile, String aname, String passWord);

    Boolean delAdmin(Integer aid);

    Boolean updateAdmin(Integer aid, String aname, String passWord);
}
