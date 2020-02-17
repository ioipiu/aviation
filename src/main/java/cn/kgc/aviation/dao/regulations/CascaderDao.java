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

    int delDir(@Param("did") Integer did);

    int delTreeDir(@Param("list") List<Integer> treeList);

    Integer getTerms(@Param("list") List<Integer> treeList);

    int delTerms(@Param("list") List<Integer> treeList);
}
