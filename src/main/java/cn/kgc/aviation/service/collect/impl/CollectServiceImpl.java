package cn.kgc.aviation.service.collect.impl;

import cn.kgc.aviation.config.Logger;
import cn.kgc.aviation.dao.collect.CollectDao;
import cn.kgc.aviation.model.entity.Collect;
import cn.kgc.aviation.service.collect.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: aviation
 * @description: TODO
 * @author: cuihao
 * @create: 2020-02-22 14:16
 * @version: V1.0
 **/
@Service
public class CollectServiceImpl implements CollectService {

    @Autowired
    private CollectDao collectionDao;

    @Override
    public List<Collect> getCollectionByUid(String uid) {
        return collectionDao.getCollectionByUid(uid);
    }

    @Override
    public List<Collect> getAllCollection(String uid) {
        return collectionDao.getCollection(uid);
    }

    @Override
    public Collect getCollectionByCid(Integer cid) {
        return collectionDao.getCollectionByCid(cid);
    }

    @Override
    public Boolean addCollection(String uid, Integer tid) {
        Collect collect = getCollect(uid, tid);
        if (null == collect) {
            int i = collectionDao.addCollection(uid, tid);
            if (i > 0) {
                return true;
            }
        }else {
            int b = collectionDao.updateCollect(uid, tid, 1);
            if (b > 0) {
                return true;
            }
        }

        return false;
    }

    @Override
    public Boolean delCollection(Integer cid) {
        int i = collectionDao.updateCollection(cid,0);
        if (i > 0) {
            return true;
        }
        return false;
    }

    @Override
    public Collect getCollect(String uid, Integer tid) {
        Collect collect = collectionDao.getCollect(uid, tid);
        if (null == collect) {
            return null;
        }
        return collect;
    }
}
