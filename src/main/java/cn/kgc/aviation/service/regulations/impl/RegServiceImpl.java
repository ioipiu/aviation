package cn.kgc.aviation.service.regulations.impl;

import cn.kgc.aviation.config.Logger;
import cn.kgc.aviation.dao.regulations.RegDao;
import cn.kgc.aviation.model.dto.vo.RegulationsVo;
import cn.kgc.aviation.model.entity.Regulations;
import cn.kgc.aviation.model.entity.RegulationsClassify;
import cn.kgc.aviation.model.entity.RegulationsType;
import cn.kgc.aviation.service.regulations.RegService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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

    @Logger("添加一级分类")
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

    @Logger("添加二级分类")
    @Override
    public Boolean addClassify(Integer typeId, String classifyName) {
        int i = regDao.addClassify(typeId, classifyName);
        if (i > 0) {
            return true;
        }
        return false;
    }

    @Logger("修改二级分类")
    @Override
    public Boolean updateClassify(RegulationsClassify regulationsClassify) {
        int i = regDao.updateClassify(regulationsClassify);
        if (i > 0) {
            return true;
        }
        return false;
    }

    @Logger("删除二级分类")
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean delClassify(Integer classifyId) throws Exception{
        int i = regDao.delClassify(classifyId);
        if (i > 0) {
            int b = regDao.getReg(classifyId);
            if (b == 0) {
                return true;
            }else {
                int c = regDao.delRegByClassifyId(classifyId);
                if (c > 0) {
                    return true;
                }
            }
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

    @Logger("添加法规")
    @Override
    public Boolean addReg(Regulations regulations) {
        int i = regDao.addReg(regulations);
        if (i > 0) {
            return true;
        }
        return false;
    }

    @Logger("修改法规")
    @Override
    public Boolean updateReg(Regulations regulations) {
        int i = regDao.updateReg(regulations);
        if (i > 0) {
            return true;
        }
        return false;
    }

    @Logger("删除法规")
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean delReg(Integer rid) throws Exception{
        int i = regDao.delReg(rid);
        if (i > 0) {
            int a = regDao.getDirById(rid);
            if (a == 0) {
                return true;
            }
            int b = regDao.delAllDir(rid);
            if (b > 0) {
                int c = regDao.getTermsById(rid);
                if (c == 0) {
                    return true;
                }
                int d = regDao.delAllTerms(rid);
                if (d > 0) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Regulations getRegById(Integer rid) {
        return regDao.getRegById(rid);
    }

    @Logger("删除一级分类")
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean delType(Integer typeId) throws Exception{
        int i = regDao.delType(typeId);
        if (i > 0) {
            List<RegulationsClassify> classifyList = regDao.showClassify(typeId);
            if (classifyList.size() == 0) {
                return true;
            }else {
                ArrayList<Integer> list = new ArrayList<>();
                for (RegulationsClassify item : classifyList) {
                    list.add(item.getClassifyId());
                }
                int b = regDao.delAllClassify(typeId);
                if (b > 0) {
                    int c = regDao.getRegByClassifyId(list);
                    if (c == 0) {
                        return true;
                    }else {
                        int d = regDao.delAllReg(list);
                        if (d > 0) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override
    public List<RegulationsClassify> getRegsByTypeId(Integer typeId) {
        return regDao.getRegsByTypeId(typeId);
    }
}
