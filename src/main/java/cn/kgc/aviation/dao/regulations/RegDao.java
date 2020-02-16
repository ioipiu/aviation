package cn.kgc.aviation.dao.regulations;

import cn.kgc.aviation.model.dto.vo.RegulationsVo;
import cn.kgc.aviation.model.entity.Regulations;
import cn.kgc.aviation.model.entity.RegulationsClassify;
import cn.kgc.aviation.model.entity.RegulationsType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RegDao {

    List<RegulationsType> showType();

    int addType(@Param("typeName") String typeName);

    List<RegulationsClassify> showClassify(@Param("typeId") Integer typeId);

    int addClassify(@Param("typeId") Integer typeId, @Param("classifyName") String classifyName);

    int updateClassify(@Param("reg") RegulationsClassify regulationsClassify);

    int delClassify(@Param("classifyId") Integer classifyId);

    List<RegulationsVo> getAllReg(@Param("start") Integer start, @Param("pageSize") Integer pageSize);

    Integer getCount();

    int delReg(@Param("rid") Integer rid);

    int addReg(@Param("reg") Regulations regulations);

    int updateReg(@Param("reg") Regulations regulations);

    Regulations getRegById(@Param("rid") Integer rid);

}
