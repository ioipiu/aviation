package cn.kgc.aviation.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegulationsType {

  private Integer typeId;
  private String typeName;
  private List<RegulationsClassify> regulationsClassifyList;
}
