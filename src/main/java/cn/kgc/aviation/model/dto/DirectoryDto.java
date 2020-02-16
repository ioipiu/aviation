package cn.kgc.aviation.model.dto;


import cn.kgc.aviation.model.entity.Directory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DirectoryDto implements Serializable {

  private Integer did;
  private String dname;
  private Integer rid;
  private Integer sort;
  private Integer parentId;
  private Integer level;
  private String key;
  private List<DirectoryDto> children = new ArrayList<>();


  public DirectoryDto(Directory dire){
    this.did = dire.getDid();
    this.dname = dire.getDname();
    this.rid = dire.getRid();
    this.parentId = dire.getParentId();
    this.sort = dire.getSort();
    this.level = dire.getLevel();
    this.key = dire.getKey();
  }



}
