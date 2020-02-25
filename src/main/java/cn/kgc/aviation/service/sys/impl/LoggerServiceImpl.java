package cn.kgc.aviation.service.sys.impl;

import cn.kgc.aviation.dao.sys.SysLogDao;
import cn.kgc.aviation.model.dto.SysLog;
import cn.kgc.aviation.service.sys.LoggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: aviation
 * @description: TODO
 * @author: cuihao
 * @create: 2020-02-24 18:44
 * @version: V1.0
 **/
@Service
public class LoggerServiceImpl implements LoggerService {

    @Autowired
    private SysLogDao sysLogDao;

    @Override
    public Map<String, Object> showLoggers(Integer currentPage, Integer pageSize) {
        HashMap<String, Object> map = new HashMap<>();
        int total = sysLogDao.getCount();
        if (total == 0) {
            return null;
        }
        Integer start = (currentPage - 1) * pageSize;
        List<SysLog> list = sysLogDao.showLoggers(start, pageSize);
        map.put("total", total);
        map.put("tableData", list);
        return map;
    }
}
