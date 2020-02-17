package cn.kgc.aviation.service.regulations.impl;

import cn.kgc.aviation.dao.regulations.DireDao;
import cn.kgc.aviation.model.entity.Directory;
import cn.kgc.aviation.service.regulations.DireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: aviation
 * @description: TODO
 * @author: cuihao
 * @create: 2020-02-13 20:36
 * @version: V1.0
 **/
@Service
public class DireServiceImpl implements DireService {

    @Autowired
    private DireDao direDao;

    @Override
    public Boolean addDir(Directory directory) {
        int i = direDao.AddDir(directory);
        if (i > 0) {
            return true;
        }
        return false;
    }

    @Override
    public Boolean updateDir(Directory directory) {
        int i = direDao.updateDir(directory);
        if (i > 0) {
            return true;
        }
        return false;
    }
}
