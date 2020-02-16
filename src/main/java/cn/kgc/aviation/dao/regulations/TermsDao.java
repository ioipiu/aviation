package cn.kgc.aviation.dao.regulations;

import cn.kgc.aviation.model.dto.vo.TermsVo;
import cn.kgc.aviation.model.entity.Terms;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TermsDao {

    Integer getTermsCount(@Param("rid") Integer rid);

    List<TermsVo> getTerms(@Param("rid") Integer rid, @Param("start") Integer start, @Param("pageSize") Integer pageSize);

    int delTerms(@Param("tid") Integer tid);

    Terms getTermsById(@Param("tid") Integer tid);

    int updateTerms(@Param("terms") Terms terms);

    int addTerms(@Param("terms") Terms terms);
}
