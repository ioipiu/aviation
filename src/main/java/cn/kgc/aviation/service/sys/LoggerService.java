package cn.kgc.aviation.service.sys;


import java.util.Map;

public interface LoggerService {
    Map<String, Object> showLoggers(Integer currentPage, Integer pageSize);
}
