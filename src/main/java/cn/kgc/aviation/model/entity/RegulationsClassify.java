package cn.kgc.aviation.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegulationsClassify {

  private Integer classifyId;
  private Integer typeId;
  private String classifyName;

}
