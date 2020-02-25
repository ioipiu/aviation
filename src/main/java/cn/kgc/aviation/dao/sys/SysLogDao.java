package cn.kgc.aviation.dao.sys;

import cn.kgc.aviation.model.dto.SysLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SysLogDao {

    void saveSysLog(@Param("log") SysLog sysLog);

    int getCount();

    List<SysLog> showLoggers(@Param("start") Integer start, @Param("pageSize") Integer pageSize);

}
