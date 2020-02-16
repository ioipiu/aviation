package cn.kgc.aviation.dao.user;

import cn.kgc.aviation.model.entity.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AdminDao {

    Admin login(@Param("mobile")String mobile,@Param("pwd")String passWord);

    Integer getTotal();

    List<Admin> showAdmin(@Param("start") Integer start, @Param("pageSize") Integer pageSize);

    int findMobile(@Param("mobile") String mobile);

    int addAdmin(@Param("mobile") String mobile, @Param("aname") String aname, @Param("pwd") String passWord);

    int delAdmin(@Param("aid") Integer aid);

    int updateAdmin(@Param("aid") Integer aid, @Param("aname") String aname, @Param("pwd") String passWord);
}
