package cn.kgc.aviation.dao.regulations;

import cn.kgc.aviation.model.dto.vo.RegulationsVo;
import cn.kgc.aviation.model.entity.Directory;
import cn.kgc.aviation.model.entity.RegulationsType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CascaderDao {

    List<RegulationsType> showType();

    List<Directory> getAllNodes();

    List<Directory> getDire(@Param("rid") Integer rid);

    List<RegulationsVo> getAllReg();
}
