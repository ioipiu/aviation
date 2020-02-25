package cn.kgc.aviation.service.collect;

import cn.kgc.aviation.model.entity.Collect;
import java.util.List;

/**
 * @program: aviation
 * @description: TODO
 * @author: cuihao
 * @create: 2020-02-22 14:15
 * @version: V1.0
 **/
public interface CollectService {
    List<Collect> getCollectionByUid(String uid);

    List<Collect> getAllCollection(String uid);

    Collect getCollectionByCid(Integer cid);

    Boolean addCollection(String uid, Integer tid);

    Boolean delCollection(Integer cid);

    Collect getCollect(String uid, Integer tid);
}
