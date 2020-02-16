package cn.kgc.aviation.dao.user;

import cn.kgc.aviation.model.entity.Consulting;
import cn.kgc.aviation.model.entity.Users;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserDao {

    Integer getTotal();

    List<Users> showUsers(@Param("start") Integer start, @Param("pageSize") Integer pageSize);

    int updateUser(@Param("usr") Users users);

    List<Consulting> showCons(@Param("start") Integer start, @Param("pageSize") Integer pageSize);

    int delCon(@Param("zid") String zid);

    Integer getConTotal();

}
