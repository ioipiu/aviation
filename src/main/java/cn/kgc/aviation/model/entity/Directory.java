package cn.kgc.aviation.model.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Directory {

  private Integer did;
  private String dname;
  private Integer rid;
  private Integer sort;
  private Integer parentId;
  private String key;
  private Integer level;
  private Integer status;
  private Date createTime;
  private Date updateTime;

}
