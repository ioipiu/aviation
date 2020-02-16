package cn.kgc.aviation.service.setup.impl;

import cn.kgc.aviation.dao.setup.SetupDao;
import cn.kgc.aviation.model.entity.*;
import cn.kgc.aviation.service.setup.SetupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: aviation
 * @description: TODO
 * @author: cuihao
 * @create: 2020-02-15 10:16
 * @version: V1.0
 **/
@Service
public class SetupServiceImpl implements SetupService {

    @Autowired
    private SetupDao setupDao;


    @Override
    public Introduction getIntro() {
        return setupDao.getIntro();
    }

    @Override
    public Boolean updateIntro(Integer id, String desc) {
        int i = setupDao.updateIntro(id, desc);
        if (i > 0) {
            return true;
        }
        return false;
    }

    @Override
    public Agreement getAgree() {
        return setupDao.getAgree();
    }

    @Override
    public Boolean updateAgree(Integer id, String content) {
        int i = setupDao.updateAgree(id, content);
        if (i > 0) {
            return true;
        }
        return false;
    }

    @Override
    public Smtp getSmtp() {
        return setupDao.getSmtp();
    }

    @Override
    public Boolean updateSmtp(Smtp smtp) {
        int i = setupDao.updateSmtp(smtp);
        if (i > 0) {
            return true;
        }
        return false;
    }

    @Override
    public Sms getSms() {
        return setupDao.getSms();
    }

    @Override
    public Boolean updateSms(Integer id, String apiKey) {
        int i = setupDao.updateSms(id, apiKey);
        if (i > 0) {
            return true;
        }
        return false;
    }

    @Override
    public Map<String, Object> showFeedback(Integer currentPage, Integer pageSize) {
        HashMap<String, Object> map = new HashMap<>();
        Integer start = (currentPage - 1) * pageSize;
        Integer total = setupDao.getFeedbackCount();
        if (total == 0) {
            return null;
        }
        List<Feedback> feedbacks = setupDao.showFeedback(start, pageSize);
        map.put("total", total);
        map.put("tableData", feedbacks);
        return map;
    }

    @Override
    public Boolean delFeedback(String fid) {
        int i = setupDao.delFeedback(fid);
        if (i > 0) {
            return true;
        }
        return false;
    }

    @Override
    public Websettings getWebSet() {
        return setupDao.getWebSet();
    }

    @Override
    public Boolean updateWebSet(Websettings websettings) {
        int i = setupDao.updateWebSet(websettings);
        if (i > 0) {
            return true;
        }
        return false;
    }
}
