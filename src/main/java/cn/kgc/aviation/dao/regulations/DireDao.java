package cn.kgc.aviation.dao.regulations;

import cn.kgc.aviation.model.entity.Directory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface DireDao {

    int AddDir(@Param("dir") Directory directory);

    int updateDir(@Param("dir") Directory directory);
}
