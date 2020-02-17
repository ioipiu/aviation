package cn.kgc.aviation.service.regulations;


import cn.kgc.aviation.model.entity.Terms;
import java.util.Map;

public interface TermsService {

    Map<String, Object> getTerms(Integer rid, Integer currentPage, Integer pageSize);

    Boolean delTerms(Integer tid) throws Exception;

    Terms getTermsById(Integer tid);

    Boolean updateTerms(Terms terms);

    Boolean addTerms(Terms terms);
}
