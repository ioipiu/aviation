package cn.kgc.aviation.service.regulations;


import cn.kgc.aviation.model.entity.Regulations;
import cn.kgc.aviation.model.entity.RegulationsClassify;
import cn.kgc.aviation.model.entity.RegulationsType;
import java.util.List;
import java.util.Map;

public interface RegService {

    List<RegulationsType> showType();

    Boolean addType(String typeName);

    List<RegulationsClassify> showClassify(Integer typeId);

    Boolean addClassify(Integer typeId,String classifyName);

    Boolean updateClassify(RegulationsClassify regulationsClassify);

    Boolean delClassify(Integer classifyId) throws Exception;

    Map<String, Object> getAllReg(Integer currentPage, Integer pageSize);

    Boolean addReg(Regulations regulations);

    Boolean updateReg(Regulations regulations);

    Boolean delReg(Integer rid) throws Exception;

    Regulations getRegById(Integer rid);

    Boolean delType(Integer typeId) throws Exception;

    List<RegulationsClassify> getRegsByTypeId(Integer typeId);
}
