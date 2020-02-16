package cn.kgc.aviation.service.regulations.impl;

import cn.kgc.aviation.dao.regulations.RegDao;
import cn.kgc.aviation.model.dto.vo.RegulationsVo;
import cn.kgc.aviation.model.entity.Regulations;
import cn.kgc.aviation.model.entity.RegulationsClassify;
import cn.kgc.aviation.model.entity.RegulationsType;
import cn.kgc.aviation.service.regulations.RegService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: aviation
 * @description: TODO
 * @author: cuihao
 * @create: 2020-02-11 18:59
 * @version: V1.0
 **/
@Service
public class RegServiceImpl implements RegService {

    @Autowired
    private RegDao regDao;

    @Override
    public List<RegulationsType> showType() {
        return regDao.showType();
    }

    @Override
    public Boolean addType(String typeName) {
        int i = regDao.addType(typeName);
        if (i > 0) {
            return true;
        }
        return false;
    }

    @Override
    public List<RegulationsClassify> showClassify(Integer typeId) {
        return regDao.showClassify(typeId);
    }

    @Override
    public Boolean addClassify(Integer typeId, String classifyName) {
        int i = regDao.addClassify(typeId, classifyName);
        if (i > 0) {
            return true;
        }
        return false;
    }

    @Override
    public Boolean updateClassify(RegulationsClassify regulationsClassify) {
        int i = regDao.updateClassify(regulationsClassify);
        if (i > 0) {
            return true;
        }
        return false;
    }

    @Override
    public Boolean delClassify(Integer classifyId) {
        int i = regDao.delClassify(classifyId);
        if (i > 0) {
            return true;
        }
        return false;
    }

    @Override
    public Map<String, Object> getAllReg(Integer currentPage, Integer pageSize) {
        HashMap<String, Object> map = new HashMap<>();
        Integer start = (currentPage-1)*pageSize;
        Integer total = regDao.getCount();
        if (total == 0) {
            return null;
        }
        List<RegulationsVo> regulationsVos = regDao.getAllReg(start, pageSize);
        map.put("total",total);
        map.put("tableData",regulationsVos);
        return map;
    }

    @Override
    public Boolean addReg(Regulations regulations) {
        int i = regDao.addReg(regulations);
        if (i > 0) {
            return true;
        }
        return false;
    }

    @Override
    public Boolean updateReg(Regulations regulations) {
        int i = regDao.updateReg(regulations);
        if (i > 0) {
            return true;
        }
        return false;
    }

    @Override
    public Boolean delReg(Integer rid) {
        int i = regDao.delReg(rid);
        if (i > 0) {
            return true;
        }
        return false;
    }

    @Override
    public Regulations getRegById(Integer rid) {
        return regDao.getRegById(rid);
    }
}
