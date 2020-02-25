package cn.kgc.aviation.utils;

import cn.kgc.aviation.dao.setup.SetupDao;
import cn.kgc.aviation.model.entity.Sms;
import cn.kgc.aviation.model.entity.Smtp;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @program: aviation
 * @description: TODO
 * @author: cuihao
 * @create: 2020-02-24 14:55
 * @version: V1.0
 **/
@Component
public class ApplicationParams {

    public static Sms sms;
    public static Smtp smtp;

    @Resource
    private SetupDao setupDao;

    @Bean
    public void init() {
        sms = setupDao.getSms();
        smtp = setupDao.getSmtp();
    }
}
