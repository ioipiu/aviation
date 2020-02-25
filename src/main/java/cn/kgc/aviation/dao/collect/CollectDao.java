package cn.kgc.aviation.dao.collect;

import cn.kgc.aviation.model.entity.Collect;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CollectDao {

    List<Collect> getCollectionByUid(@Param("uid") String uid);

    List<Collect> getCollection(@Param("uid") String uid);

    Collect getCollectionByCid(@Param("cid") Integer cid);

    int addCollection(@Param("uid") String uid, @Param("tid") Integer tid);

    int updateCollection(@Param("cid") Integer cid,@Param("status")Integer status);

    Collect getCollect(@Param("uid") String uid, @Param("tid") Integer tid);

    int updateCollect(@Param("uid") String uid, @Param("tid") Integer tid,@Param("status")Integer status);
}
