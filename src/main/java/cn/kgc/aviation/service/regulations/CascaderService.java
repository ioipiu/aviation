package cn.kgc.aviation.service.regulations;


import cn.kgc.aviation.model.dto.DirectoryDto;
import cn.kgc.aviation.model.dto.Options;
import cn.kgc.aviation.model.dto.vo.RegulationsVo;



import java.util.List;

public interface CascaderService {

    List<Options> showOptions();

    List<DirectoryDto> showDirOptions();

    List<DirectoryDto> getDire(Integer rid);

    List<RegulationsVo> getAllReg();

    Boolean delDir(Integer rid, Integer did) throws Exception;

}
