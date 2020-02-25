package cn.kgc.aviation.service.regulations.impl;

import cn.kgc.aviation.config.Logger;
import cn.kgc.aviation.dao.regulations.TermsDao;
import cn.kgc.aviation.model.dto.vo.TermsVo;
import cn.kgc.aviation.model.entity.Terms;
import cn.kgc.aviation.service.regulations.TermsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: aviation
 * @description: TODO
 * @author: cuihao
 * @create: 2020-02-16 13:02
 * @version: V1.0
 **/
@Service
public class TermsServiceImpl implements TermsService {

    @Autowired
    private TermsDao termsDao;

    @Override
    public Map<String, Object> getTerms(Integer rid, Integer currentPage, Integer pageSize) {
        HashMap<String, Object> map = new HashMap<>();
        Integer start = (currentPage - 1) * pageSize;
        Integer total = termsDao.getTermsCount(rid);
        if (total == 0) {
            return null;
        }
        List<TermsVo> terms = termsDao.getTerms(rid, start, pageSize);
        map.put("total", total);
        map.put("tableData", terms);
        return map;
    }

    @Logger("删除条款")
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean delTerms(Integer tid) throws Exception{
        int i = termsDao.delTerms(tid);
        if (i > 0) {
            return true;
        }
        return false;
    }

    @Override
    public Terms getTermsById(Integer tid) {
        return termsDao.getTermsById(tid);
    }

    @Logger("修改条款")
    @Override
    public Boolean updateTerms(Terms terms) {
        int i = termsDao.updateTerms(terms);
        if (i > 0) {
            return true;
        }
        return false;
    }

    @Logger("添加条款")
    @Override
    public Boolean addTerms(Terms terms) {
        int i = termsDao.addTerms(terms);
        if (i > 0) {
            return true;
        }
        return false;
    }

    @Override
    public List<Terms> getTermsByDid(Integer did) {
        return termsDao.getTermByDid(did);
    }
}
